package com.vipinjoseph.assignmentproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vipinjoseph.assignmentproducer.request.PushRequest;

@Component
public class ValueService {

	@Value("${amqp.queue.name}")
	private String queueName;

	private static final Logger LOGGER = LoggerFactory.getLogger(ValueService.class);

	private final RabbitTemplate rabbitTemplate;
	
	private final ObjectMapper objectMapper;

	@Autowired
	public ValueService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
	}
	
	public void sendValuesToQueue(PushRequest request) {
		LOGGER.info("Sending Message");
		try {
			String valuesJsonString = objectMapper.writeValueAsString(request);
			rabbitTemplate.convertAndSend(queueName, valuesJsonString);
		} catch (JsonProcessingException e) {
			LOGGER.error("Parsing Exception", e);
		}
	}

}
