package com.swashtech.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@ApiOperation(value = "Say Hello")
	@RequestMapping(method = RequestMethod.GET, value = "/api/swashtech/hello")
	public String sayHello() {
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		return "Swagger Hello World";
	}

	@ApiOperation(value = "Get Client Details")
	@RequestMapping(method = RequestMethod.GET, value = "/api/swashtech/getClientDetails", produces = "application/json")
	public ResponseEntity<String> getClientDetails(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		try {
			Enumeration<String> httpheader = request.getHeaderNames();
			logger.debug("Headers : {}", httpheader.toString());
			while (httpheader.hasMoreElements()) {
				String key = httpheader.nextElement();
				jsonObject.put(key, request.getHeader(key));
			}
			jsonObject.put("Remote Address", request.getRemoteAddr());
			jsonObject.put("Remote Host", request.getRemoteHost());
			logger.debug("Final Response : {}", jsonObject);
		} catch (Exception e) {
			logger.error("Exception occured : {}", e.getMessage());
		}
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
	}
}
