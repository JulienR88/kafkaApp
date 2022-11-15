package com.exemple.kafkaApp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;


// Classe remplacé par application.properties => équivalent
@EnableKafka
@Configuration
public class KafkaConfig {
/*
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		
		Map<String, Object> config = new HashMap<String, Object>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id-test");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(config);
	}
	
	public ConcurrentKafkaListenerContainerFactory<String, String> listenerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}*/
}
