package edu.ssafy.boot.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.ssafy.boot.dto.UploadFile;
import edu.ssafy.boot.repository.FileDAO;
import edu.ssafy.boot.repository.FileDAOImpl;
import edu.ssafy.boot.util.UploadFileUtils;

@Service
public class ImageService {
    
    private static final Logger logger = LoggerFactory.getLogger(ImageService.class);
    
    private final Path rootLocation;
    
    @Autowired
    public ImageService(String uploadPath) {
        logger.info("PATH :: " + uploadPath);
        this.rootLocation = Paths.get(uploadPath);
    }
    
    @Autowired
    FileDAOImpl filedao;
    
    public Stream<Object> loadAll() {
        List<UploadFile> files = filedao.findAll();
        return files.stream().map(file -> file.getFileid());
    }
    
    public UploadFile load(int fileId) {
         UploadFile uploadedFile = filedao.findOne(fileId);
         System.out.println("findOne === Service"+ fileId+ " "+ uploadedFile);
         return uploadedFile;
    }
    
    public Resource loadAsResource(String fileName) throws Exception {
        try {
            if (fileName.toCharArray()[0] == '/') {
                fileName = fileName.substring(1);
            }
            
            Path file = loadPath(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new Exception("Could not read file: " + fileName);
            }
        } catch (Exception e) {
            throw new Exception("Could not read file: " + fileName);
        }
    }
    
    private Path loadPath(String fileName) {
        return rootLocation.resolve(fileName);
    }
    
    public UploadFile store(MultipartFile file) throws Exception {
        try {
            if (file.isEmpty()) {
//            	System.out.println("uploadfile store failed to store empty file");
                throw new Exception("Failed to store empty file " + file.getOriginalFilename());
            }
            
            String saveFileName = UploadFileUtils.fileSave(rootLocation.toString(), file);
            
            if (saveFileName.toCharArray()[0] == '/') {
                saveFileName = saveFileName.substring(1);
            }
            Resource resource = loadAsResource(saveFileName);
            UploadFile saveFile = new UploadFile();
            saveFile.setSaveFileName(saveFileName);
            saveFile.setFileName(file.getOriginalFilename());
            saveFile.setContentType(file.getContentType());
            saveFile.setFilePath(rootLocation.toString().replace(File.separatorChar, '/') + File.separator + saveFileName);
            saveFile.setSize(resource.contentLength());
            saveFile.setRegDate(new Date());
            UploadFile save = filedao.save(saveFile);
            /*
             * fileId int primary key, 
    			content_type varchar(100),
    			file_name varchar(200),
    			file_path varchar(200),
    			reg_date varchar(200),
    			save_file_name varchar(300),
    			size int
             */
            return save;
        } catch (IOException e) {
            throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
}