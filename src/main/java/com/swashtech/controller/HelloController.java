package com.swashtech.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController {
	
	@ApiOperation(value = "Say Hello")
	@RequestMapping(method = RequestMethod.GET, value = "/api/swashtech/hello")
	public String sayHello() {
		return "Swagger Hello World";
	}
}
