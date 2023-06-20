package com.brunobcp.ociappbcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OciAppBcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(OciAppBcpApplication.class, args);
	}

}
