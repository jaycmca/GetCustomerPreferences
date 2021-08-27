package com.sample.microservice.get.customer.preferences.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.microservice.get.customer.preferences.constants.Constants;
import com.sample.microservice.get.customer.preferences.model.CustomerPreferencesVO;
import com.sample.microservice.get.customer.preferences.service.CustomerPreferencesService;

@RestController
@RequestMapping(Constants.DOMAIN + Constants.VERSION)
public class CustomerPreferenceController {
	private static final Logger log = LogManager.getLogger();
	@Autowired
	private CustomerPreferencesService service;

	@Autowired
	private HttpServletRequest request;

	@GetMapping(Constants.HEALTH)
	public String health() {
		return "OK";
	}

	
	@GetMapping(Constants.GET_CUSTOMER_PREFERENCES + Constants.PATH_ID)
	public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") Long customerId) {

		return responseEntity200(service.getCustomerPreferencesById(customerId));
	}
	
	@GetMapping(Constants.GET_CUSTOMER_PREFERENCES)
	public ResponseEntity<?> getCustomerPreferences(@RequestParam(value = "emailId", required = false) String emailId,
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
		
		return responseEntity200(service.getCustomerPreferences(emailId, phoneNumber));
	}

	
	
	private ResponseEntity<Object> responseEntity200(Object response) {
		HttpHeaders headers = generateResponseHeaders();
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	private HttpHeaders generateResponseHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("unique-request-id", request.getHeader("unique-request-id"));
		return headers;
	}

}
