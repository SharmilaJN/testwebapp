package com.harman;
import com.azure.messaging.eventhubs.*;

import java.util.Arrays;
import java.util.List;

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
		publishEvents();
	}

	public static String getConnectionString () {	
	return connectionString;
	}
	
	public static String getEventhubname() {
		return eventHubName;
	}
	
	/**
     * Code sample for publishing events.
     * @throws IllegalArgumentException if the EventData is bigger than the max batch size.
     */
    public static void publishEvents() {
        // create a producer client
        EventHubProducerClient producer = new EventHubClientBuilder()
            .connectionString(connectionString, eventHubName)
            .buildProducerClient();

        // sample events in an array
        List<EventData> allEvents = Arrays.asList(new EventData({\"phno\":\"12345\",\"city\":\"pune\",\"age\":27}), new EventData({\"phno\":\"12345678\",\"city\":\"pune11\",\"age\":27}));
	//List<EventData> allEvents = Arrays.asList(new EventData("test1111"), new EventData("message111"));

        // create a batch
        EventDataBatch eventDataBatch = producer.createBatch();

        for (EventData eventData : allEvents) {
            // try to add the event from the array to the batch
            if (!eventDataBatch.tryAdd(eventData)) {
                // if the batch is full, send it and then create a new batch
                producer.send(eventDataBatch);
                eventDataBatch = producer.createBatch();

                // Try to add that event that couldn't fit before.
                if (!eventDataBatch.tryAdd(eventData)) {
                    throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
                        + eventDataBatch.getMaxSizeInBytes());
                }
            }
        }
        // send the last batch of remaining events
        if (eventDataBatch.getCount() > 0) {
            producer.send(eventDataBatch);
        }
        producer.close();
    }
	
}

