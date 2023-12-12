package com.MarketingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.MarketingApp.dto.Registrationdto;
import com.MarketingApp.entity.Registration;
import com.MarketingApp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationrepo;
	
	public void saveRegistration(Registration registration) {
		registrationrepo.save(registration);
	}
	
	public List<Registration> readRegistration(){
		List<Registration> registrations = registrationrepo.findAll();
		return registrations;

		
	}
	public void deletelead(long id) {
		registrationrepo.deleteById(id);
	}
	
	public Registration getRegistrationbyId(long id) {
		
		
		Optional<Registration> findById = registrationrepo.findById(id);
		
		return findById.get();
		
	}
	public void saveupdatedRegistration(Registration registration) {
		registrationrepo.save(registration);
	}
	
	public List<Registration> search(String Search) {
		// searching by any parameter
		List<Registration> sf = registrationrepo.findByfirstNameContainingIgnoreCase(Search);
		return sf;
		
		
	}
	
}
