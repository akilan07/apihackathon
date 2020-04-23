package com.fss.cms.sftpapi.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fss.cms.sftpapi.dto.FileTransferDTO;
import com.fss.cms.sftpapi.modal.FileDetail;

@Service
@PropertySource({ "classpath:application.properties" })
public class SFTPConnectService {

	@Autowired
	Environment env;

	Logger logger = LoggerFactory.getLogger("sftpfile");

	public List<FileDetail> getFileList() throws IOException {
		LinkedList<FileDetail> filesDetails = new LinkedList<FileDetail>();
		FTPClient ftpClient = new FTPClient();
		logger.debug("FTP Details:: host :: {} ", env.getProperty("ftp.host"));
		ftpClient.connect(env.getProperty("ftp.host"), Integer.parseInt(env.getProperty("ftp.port")));
		ftpClient.login(env.getProperty("ftp.user"), env.getProperty("ftp.password"));

		FTPFile[] files = ftpClient.listFiles();

		FileDetail fileDetail = null;
		for (FTPFile file : files) {
			if (file.isFile()) {
				fileDetail = new FileDetail();
				fileDetail.setFileName(file.getName());
				fileDetail.setFilesize(file.getSize() + " KB");
				if (logger.isDebugEnabled())
					logger.debug("File Details :: " + fileDetail.toString());
				filesDetails.add(fileDetail);
			}
		}
		ftpClient.logout();
		ftpClient.disconnect();
		return filesDetails;
	}

	public boolean transferfile(FileTransferDTO fileTransferDTO) throws IOException {
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect(env.getProperty("ftp.host"), Integer.parseInt(env.getProperty("ftp.port")));
		ftpClient.login(env.getProperty("ftp.user"), env.getProperty("ftp.password"));
		ftpClient.enterLocalPassiveMode();
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

		String remoteFile1 = fileTransferDTO.getFilename();
		File downloadFile1 = new File(
				fileTransferDTO.getDownloadloaction() + File.separator + fileTransferDTO.getFilename());
		OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
		boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
		outputStream1.close();

		return success;
	}

}
