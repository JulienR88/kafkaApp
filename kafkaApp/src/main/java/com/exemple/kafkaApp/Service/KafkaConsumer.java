package com.exemple.kafkaApp.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class); 
	
	@KafkaListener(topicPartitions = {@TopicPartition(topic = "testTopic_v1", 
			partitions = {"0", "1"}, 
			partitionOffsets = @PartitionOffset(partition = "*", 
												initialOffset = "0"))})
	public void consume(@Payload String message,
			@Header(KafkaHeaders.OFFSET) int offset,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			@Header(KafkaHeaders.RECEIVED_TOPIC) String topic){

		logger.info("TOPIC : " + topic + " - " + "PARTITION : " +  partition + " OFFSET : " + offset +  " MESSAGE : " + message);
	}
	
}
