package com.fss.cms.sftpapi.dto;

public class FileTransferDTO {

	private String filename;
	private String downloadloaction;
	private int responseCode;
	private String responseMsg;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDownloadloaction() {
		return downloadloaction;
	}

	public void setDownloadloaction(String downloadloaction) {
		this.downloadloaction = downloadloaction;
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
		return "FileTransferDTO [filename=" + filename + ", downloadloaction=" + downloadloaction + ", responseCode="
				+ responseCode + ", responseMsg=" + responseMsg + "]";
	}

}
