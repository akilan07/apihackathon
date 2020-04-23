package com.fss.cms.sftpapi.modal;

public class FileDetail {

	private String fileId;
	private String fileName;
	private String filesize;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "FileDetail [fileId=" + fileId + ", fileName=" + fileName + ", filesize=" + filesize + "]";
	}

}
