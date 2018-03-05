package com.vipinjoseph.assignmentproducer.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipinjoseph.assignmentproducer.request.PushRequest;
import com.vipinjoseph.assignmentproducer.service.ValueService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private ValueService valueService;
	
	@PostMapping("/push")
	public String push(@RequestBody PushRequest request) {
		//TODO: Implement this method
		
		System.out.println("Values are " + request.getValueOne() + ", " + request.getValueTwo());
		valueService.sendValuesToQueue(request);
		return "success";
	}
	
	

}
