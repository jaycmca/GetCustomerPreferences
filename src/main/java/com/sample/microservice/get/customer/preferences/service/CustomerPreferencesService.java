package com.sample.microservice.get.customer.preferences.service;

import com.sample.microservice.get.customer.preferences.model.CustomerPreferencesVO;

public interface CustomerPreferencesService {
	
	CustomerPreferencesVO getCustomerPreferencesById(long id);
	
	CustomerPreferencesVO getCustomerPreferences(String emailId, String phoneNumber);
	
	

}
