package com.fss.cms.sftpapi.dto;

import java.util.List;

import com.fss.cms.sftpapi.modal.FileDetail;

public class FileDetailsDTO {

	private List<FileDetail> fileDetails;
	private int responseCode;
	private String responseMsg;

	public List<FileDetail> getFileDetails() {
		return fileDetails;
	}

	public void setFileDetails(List<FileDetail> fileDetails) {
		this.fileDetails = fileDetails;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	@Override
	public String toString() {
		return "FileDetailsDTO [fileDetails=" + fileDetails + ", responseCode=" + responseCode + ", responseMsg="
				+ responseMsg + "]";
	}

}
