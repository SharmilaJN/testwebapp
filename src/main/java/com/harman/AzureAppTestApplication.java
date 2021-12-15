package com.harman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AzureAppTestApplication {
	
	@GetMapping(value ="/message")
	public String getStarupMessage() {
		return "webapp deployed Successfully";
	}

	public static void main(String[] args) {
		SpringApplication.run(AzureAppTestApplication.class, args);
	}

}
