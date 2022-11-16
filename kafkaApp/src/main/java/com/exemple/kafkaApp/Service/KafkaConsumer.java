package com.exemple.kafkaApp.Service;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.exemple.kafkaApp.Model.Person;

@Service
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class); 
	
	@Autowired
	PersonService personService;
	
	/*@KafkaListener(topicPartitions = {@TopicPartition(topic = "testTopic_v1", 
			partitions = {"0", "1"}, 
			partitionOffsets = @PartitionOffset(partition = "*", 
												initialOffset = "0"))})*/
	@KafkaListener(topics = "testTopic_v1")
	public void consume(@Payload String message,
			@Header(KafkaHeaders.OFFSET) int offset,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic){

		logger.info("TOPIC : " + topic + " - " + "PARTITION : " +  partition + " OFFSET : " + offset +  " MESSAGE : " + message);
		
		JSONObject jsonObject = new JSONObject(message);
		String name = jsonObject.getString("name");
		String firstname = jsonObject.getString("firstname");
		
		Person Person = new Person.PersonBuilder().setFirstname(firstname).setName(name).build();
		
		logger.info("---------------" + Person.toString());
		
		personService.insert(Person);
	}
	
}
