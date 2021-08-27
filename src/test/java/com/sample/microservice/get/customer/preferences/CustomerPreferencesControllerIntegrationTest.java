package com.sample.microservice.get.customer.preferences;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.microservice.get.customer.preferences.CustomerPreferencesApplication;
import com.sample.microservice.get.customer.preferences.constants.Constants;
import com.sample.microservice.get.customer.preferences.model.CustomerPreferencesVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerPreferencesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerPreferencesControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}
	
	@Test
	public void testGetCustomerPreferencesById() {
		long id = 1;
		CustomerPreferencesVO customerPreferencesVO = restTemplate.getForObject(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.GET_CUSTOMER_PREFERENCES + "/"+id, CustomerPreferencesVO.class);
		assertNotNull(customerPreferencesVO);
	}
	
	@Test
	public void testGetCustomerPreferences() {
		String emailId="jaycmca@gmail.com";
		String phoneNumber = "+971123123123";
		CustomerPreferencesVO customerPreferencesVO = restTemplate.getForObject(getRootUrl() + Constants.DOMAIN + Constants.VERSION+ Constants.GET_CUSTOMER_PREFERENCES + "?emailId="+emailId+"&phoneNumber="+phoneNumber, CustomerPreferencesVO.class);
		assertNotNull(customerPreferencesVO);
	}
	
}
