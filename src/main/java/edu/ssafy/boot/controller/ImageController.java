package edu.ssafy.boot.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.ssafy.boot.dto.UploadFile;
import edu.ssafy.boot.service.ImageService;
import edu.ssafy.boot.util.MediaUtils;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api")
public class ImageController {
    
    @Autowired
    ImageService imageService;
    
    @GetMapping("/image")
    public String listUploadedFiles(Model model) throws IOException {
        
        model.addAttribute("files", imageService.loadAll().collect(Collectors.toList()));
        
        return "index";
    }
    
    @GetMapping("/image/{fileId}")
    @ResponseBody
    public ResponseEntity<?> serveFile(@PathVariable int fileId) {
        try {
        	System.out.println("controller  ");
            UploadFile uploadedFile = imageService.load(fileId);
            System.out.println("controller");
            System.out.println(uploadedFile.toString());
            HttpHeaders headers = new HttpHeaders();
            
            String fileName = uploadedFile.getFileName();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

            if (MediaUtils.containsImageMediaType(uploadedFile.getContentType())) {
                headers.setContentType(MediaType.valueOf(uploadedFile.getContentType()));
            } else {
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            }

            Resource resource = imageService.loadAsResource(uploadedFile.getSaveFileName());
            return ResponseEntity.ok().headers(headers).body(resource);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/image/fileupload")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleFileUpload(HttpServletResponse res, HttpServletRequest req) {
    	System.out.println("!!");
    	String path = "/upload";
    	String realPath = req.getServletContext().getRealPath(path);
		File f = new File(realPath);
		if (!f.exists()) {// 경로가 없다면 폴더를 만든다.
			f.mkdir();
		}
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) req;
		Iterator<String> fileNames = mhsr.getFileNames();
		if (!f.isDirectory()) {
			f.mkdir();
		}
		
		Map<String, Object> outData = new HashMap<String, Object>();
		try {
			while (fileNames.hasNext()) {
				String fileName = fileNames.next();
				System.out.println(fileName);
				MultipartFile file = mhsr.getFile(fileName);
				String oriName = new String(file.getOriginalFilename().getBytes("UTF-8"));
				String ext = oriName.substring(oriName.lastIndexOf(".")); //확장자 끊어서.
				String saveFileName = oriName; //저장할 파일이름을 만드는데 뒤에 확장자도 붙임?
				File serverFile = new File(realPath+File.separator+saveFileName);
				file.transferTo(serverFile);
//				map.put("resmsg", "succ");
				map.put("uploaded", 1);
				map.put("url", req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + saveFileName);
				map.put("fileName", saveFileName);
//				JSONObject outData = new JSONObject();
				outData.put("uploaded", 1);
				outData.put("url", req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/" + saveFileName);
				outData.put("fileName", saveFileName);
				System.out.println(outData);
				System.out.println("!!!");
			}
			resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resEntity;
    }
    
}