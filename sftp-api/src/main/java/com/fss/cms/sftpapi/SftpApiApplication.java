package com.fss.cms.sftpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fss.cms.*")
public class SftpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SftpApiApplication.class, args);
	}

}
