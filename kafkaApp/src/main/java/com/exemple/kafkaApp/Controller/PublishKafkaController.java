package com.exemple.kafkaApp.Controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.kafkaApp.Service.KafkaPublisher;

@RestController
@RequestMapping("/kafka")
public class PublishKafkaController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(PublishKafkaController.class);
	
	@Autowired
	private KafkaPublisher publisher;
	
	@GetMapping
	public ResponseEntity<String> healtcheck(){
		
		return new ResponseEntity<String>("STATUS UP", HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String body){
		
		publisher.publishMessage("testTopic_v1", body);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
}
