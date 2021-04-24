package com.swashtech.controller;

import java.util.Enumeration;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@ApiOperation(value = "Get Client Details")
	@RequestMapping(method = RequestMethod.GET, value = "/api/swashtech/getClientDetails", produces = "application/json")
	public ResponseEntity<String> getClientDetails(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		try {
			Enumeration<String> headers = request.getHeaderNames();
			while(headers.hasMoreElements()) {
				String key = headers.nextElement();
				jsonObject.put(key, request.getHeader(key));
			}
			jsonObject.put("Remote Address", request.getRemoteAddr());
			jsonObject.put("Remote Host", request.getRemoteHost());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
	}
}
