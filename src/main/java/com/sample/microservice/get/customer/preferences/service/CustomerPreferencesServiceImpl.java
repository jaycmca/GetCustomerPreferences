package com.sample.microservice.get.customer.preferences.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.microservice.get.customer.preferences.entity.CustomerPreferences;
import com.sample.microservice.get.customer.preferences.model.CustomerPreferencesVO;
import com.sample.microservice.get.customer.preferences.repository.CustomerPreferencesRepository;

@Service
public class CustomerPreferencesServiceImpl implements CustomerPreferencesService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private CustomerPreferencesRepository repository;

	@Override
	public CustomerPreferencesVO getCustomerPreferencesById(long id) {
		Optional<CustomerPreferences> pre = repository.findById(id);
		if (pre == null) {
			log.error("id does not exist!");
			return null;
		}
		return buildCustomerPreferencesVO(pre.get());
	}

	@Override
	public CustomerPreferencesVO getCustomerPreferences(String emailId, String phoneNumber) {
		Optional<CustomerPreferences> pre = null;
		if (emailId != null && phoneNumber != null) {
			pre = repository.findByEmailIdAndPhoneNumber(emailId, phoneNumber);
		} else if (emailId != null && phoneNumber == null) {
			pre = repository.findByEmailId(emailId);
		} else if (emailId == null && phoneNumber != null) {
			pre = repository.findByPhoneNumber(phoneNumber);
		} else {
			log.error("No value found in db!");
			return null;
		}
		
		return buildCustomerPreferencesVO(pre.get());
	}

	private CustomerPreferencesVO buildCustomerPreferencesVO(CustomerPreferences customerPreferences) {
		CustomerPreferencesVO customerPreferencesVO = new CustomerPreferencesVO();
		if (customerPreferences.getFirstName() != null)
			customerPreferencesVO.setFirstName(customerPreferences.getFirstName());
		if (customerPreferences.getLastName() != null)
			customerPreferencesVO.setLastName(customerPreferences.getLastName());
		if (customerPreferences.getEmailId() != null)
			customerPreferencesVO.setEmailId(customerPreferences.getEmailId());
		if (customerPreferences.getPostalAddress() != null)
			customerPreferencesVO.setPostalAddress(customerPreferences.getPostalAddress());
		if (customerPreferences.getPhoneNumber() != null)
			customerPreferencesVO.setPhoneNumber(customerPreferences.getPhoneNumber());
		return customerPreferencesVO;
	}

}
