package com.harman;
import com.azure.messaging.eventhubs.*;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class AzureAppTestApplication {
	
	
	
	private static final String connectionString = "Endpoint=sb://aanamespace.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=sjjnI8IM10yujqiIlwp+2YFRpZvVkUfBgPGZX3t9BzA=";		
	private static final String eventHubName = "aaeventhub";
	
	public static void main(String[] args) {
		SpringApplication.run(AzureAppTestApplication.class, args);
		
	}

	public static String getConnectionString () {	
	return connectionString;
	}
	
	public static String getEventhubname() {
		return eventHubName;
	}
	
}

