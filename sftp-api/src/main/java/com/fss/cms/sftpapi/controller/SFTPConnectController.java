package com.fss.cms.sftpapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fss.cms.sftpapi.dto.FileDetailsDTO;
import com.fss.cms.sftpapi.dto.FileTransferDTO;
import com.fss.cms.sftpapi.service.SFTPConnectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
@Api(value = "/sftpconnect", description = "Services used to get the file list and transfer files from SFTP")
public class SFTPConnectController {

	Logger logger = LoggerFactory.getLogger("sftpfile");

	@Autowired
	SFTPConnectService sftpConnectService;

	@ApiOperation(value = "API for get file list from SFTP", notes = "List the files from the SFTP")
	@RequestMapping(value = "/getfilelist", method = RequestMethod.GET, produces = "application/json")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "List of files get from SFTP")
		})
	public FileDetailsDTO getFileList() {
		FileDetailsDTO fileDetailsDTO = new FileDetailsDTO();
		try {
			fileDetailsDTO.setFileDetails(sftpConnectService.getFileList());
			fileDetailsDTO.setResponseCode(0);
			fileDetailsDTO.setResponseMsg("Success");
		} catch (Exception e) {
			logger.debug("Exception while getting File lists :: ", e);
			logger.error("Exception while getting File lists :: ", e);
			fileDetailsDTO.setResponseCode(1);
			fileDetailsDTO.setResponseMsg("Error while fetching file details");
		} finally {
			if (fileDetailsDTO.getFileDetails().size() == 0) {
				fileDetailsDTO.setResponseCode(0);
				fileDetailsDTO.setResponseMsg("No file found");
			}
		}
		return fileDetailsDTO;
	}

	@ApiOperation(value = "API For transfer files from SFTP", notes = "Transfer files from SFTP to local given loaction")
	@RequestMapping(value = "/transferfile", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Download file response")
		})
	public FileTransferDTO transferFile(@RequestBody FileTransferDTO fileTransferDTO) {
		try {
			if (sftpConnectService.transferfile(fileTransferDTO)) {
				fileTransferDTO.setResponseCode(0);
				fileTransferDTO.setResponseMsg("Success");
			} else {
				fileTransferDTO.setResponseCode(1);
				fileTransferDTO.setResponseMsg("Error occured while downloading");
			}
		} catch (Exception e) {
			logger.debug("Exception while transfer File :: ", e);
			logger.error("Exception while transfer File :: ", e);
			fileTransferDTO.setResponseCode(1);
			fileTransferDTO.setResponseMsg("Error while downloading file");
		} finally {
			if (fileTransferDTO.getResponseCode() != 0) {
				fileTransferDTO.setResponseCode(1);
				fileTransferDTO.setResponseMsg("Failed");
			}
		}
		return fileTransferDTO;
	}
}
