package com.MarketingApp.practice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MarketingApp.entity.Registration;
import com.MarketingApp.repository.RegistrationRepository;
import com.MarketingApp.service.RegistrationService;
import com.MarketingApp.util.EmailService;
@SuppressWarnings(value = { "unused" })
public class Practice {

	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegistrationRepository registrationrepo;
	
	@Test
	public void pr(Registration registration) {
		
	System.out.println(registrationrepo.count());
	
	
}
}