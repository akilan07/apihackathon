package com.fss.cms.sftpapi.modal;

import io.swagger.annotations.ApiModelProperty;

public class FileDetail {

	@ApiModelProperty(notes = "fieldId", example = "1")
	private String fileId;
	@ApiModelProperty(notes = "filename", example = "test2.txt")
	private String fileName;
	@ApiModelProperty(notes = "filesize", example = "5 Kb")
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
