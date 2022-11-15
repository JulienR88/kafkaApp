package com.exemple.kafkaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class KafkaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAppApplication.class, args);
	}

}
