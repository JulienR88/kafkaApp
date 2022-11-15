package com.exemple.kafkaApp.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {

	Logger logger = LoggerFactory.getLogger(KafkaPublisher.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void publishMessage(String topic, String message) {
		
		MessageBuilder<String> builder = MessageBuilder.withPayload(message).
				setHeader(KafkaHeaders.TOPIC, topic);
		
		kafkaTemplate.send(builder.build());
	}
	
}
