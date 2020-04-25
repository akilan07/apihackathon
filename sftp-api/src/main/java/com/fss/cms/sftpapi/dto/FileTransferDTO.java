package com.fss.cms.sftpapi.dto;

import io.swagger.annotations.ApiModelProperty;

public class FileTransferDTO {

	@ApiModelProperty(notes = "filename download from sftp", example = "test2.txt")
	private String filename;
	@ApiModelProperty(notes = "download Location in local system", example = "C:\\Downloads")
	private String downloadloaction;
	@ApiModelProperty(notes = "Response code after download 0 - success, 1 - failure")
	private int responseCode;
	@ApiModelProperty(notes = "Response Description after download success, failure", example = "Success")
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
