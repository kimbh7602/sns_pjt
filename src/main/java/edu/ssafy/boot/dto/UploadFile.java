package edu.ssafy.boot.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class UploadFile {
    
    private int fileid;
    private String fileName;
    private String saveFileName;
    private String filePath;
    private String contentType;
    private long size;
    
    private Date regDate;
    
    public UploadFile() {
		super();
	}

  
	public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public UploadFile(int fileid, String fileName, String saveFileName, String filePath, String contentType, long size,
			Date regDate) {
		super();
		this.fileid = fileid;
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.filePath = filePath;
		this.contentType = contentType;
		this.size = size;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UploadFile [fileid=" + fileid + ", fileName=" + fileName + ", saveFileName=" + saveFileName
				+ ", filePath=" + filePath + ", contentType=" + contentType + ", size=" + size + ", regDate=" + regDate
				+ "]";
	}


	
}