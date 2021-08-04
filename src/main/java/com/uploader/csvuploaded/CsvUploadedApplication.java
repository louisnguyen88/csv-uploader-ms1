package com.uploader.csvuploaded;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;

@SpringBootApplication(exclude = ContextRegionProviderAutoConfiguration.class)
public class CsvUploadedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsvUploadedApplication.class, args);
	}

}
