   package com.harman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.messaging.eventhubs.EventHubClientBuilder;

import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.impl.EventHubClientImpl;

@RestController
public class AzureAppTestController {

	
	@GetMapping(value ="/message")
	public String getStarupMessage() {
		return "This is a Demo webapp deployed Successfully";
	}
	
	
	
	
	
}
