package com.sample.microservice.get.customer.preferences.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.microservice.get.customer.preferences.entity.CustomerPreferences;

@Repository
public interface CustomerPreferencesRepository extends JpaRepository<CustomerPreferences, Long> {
	Optional<CustomerPreferences> findByEmailIdAndPhoneNumber(String emailId, String phoneNumber);

	Optional<CustomerPreferences> findByEmailId(String emailId);

	Optional<CustomerPreferences> findByPhoneNumber(String phoneNumber);

}
