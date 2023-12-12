package com.MarketingApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarketingApp.dto.Registrationdto;
import com.MarketingApp.entity.Registration;
import com.MarketingApp.repository.RegistrationRepository;
import com.MarketingApp.service.RegistrationService;
import com.MarketingApp.util.EmailService;
@Controller

public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RegistrationRepository registrationrepo;

	
	

	
	//http://localhost:8080/view
	
	@RequestMapping("/view")
	public String viewRegistrationpage() {
		return "Create_lead";
		
	}
	
//	@RequestMapping("/SaveReg")
//	public String saveRegistrationpage( 
//	
//		@RequestParam("firstName") String firstName,
//		@RequestParam("lastName") String lastName,
//		@RequestParam("email") String email,
//		@RequestParam("mobile") String mobile)
//	{
//		
//		System.out.println(firstName);
//		System.out.println(lastName);
//
//		System.out.println(email);
//
//		System.out.println(mobile);
//		 Registration reg = new Registration();
//		 reg.setFirstName(firstName);
//		 reg.setLastName(lastName);
//		 reg.setEmail(email);
//		 reg.setMobile(mobile);
//	      registrationService.saveRegistration(reg);
//
//
//		return "Create_lead";
//	}


//	@RequestMapping("/SaveReg")
//public String saveRegistrationpage(Registration registration) {
//		
//		System.out.println(registration.getId());
//		System.out.println(registration.getFirstName());
//		System.out.println(registration.getLastName());
//		System.out.println(registration.getEmail());
//		System.out.println(registration.getMobile());
//
//		
//      registrationService.saveRegistration(registration);
//	return "Create_lead";
//	}
//	
//
	@RequestMapping("/ReadAll")
	public String readRegistrationpage(Model model) {
		
        List<Registration> registrations =registrationService.readRegistration();
        System.out.println(registrations);
        model.addAttribute("registrations",registrations);
		return "list_registrationsjsp";
		
	}
//	
	
	@RequestMapping("/SaveReg")
	public String saveRegistrationpage(Registrationdto dto,Model model ) {
		
		Registration reg = new Registration();
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
         registrationService.saveRegistration(reg);
        
       emailService.sendemail(dto.getEmail(), "welcome", " Congratulations!!!!!!You are now a member of Mark1");
			model.addAttribute("msg","Record is Saved");
			model.addAttribute("cre","Account Created Successfully");

			
	
		return "Create_lead";
		
	}
	@RequestMapping("/CreateReg")
	public String createRegistrationpage(Registrationdto dto,Model model ) {
		
		Registration reg = new Registration();
		reg.setId(dto.getId());
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
         registrationService.saveRegistration(reg);
        
        	 
		//	model.addAttribute("msg","Record is Saved");
			model.addAttribute("cre","Account Created Successfully");

			
	
		return "Create_registration";
		
	}
	
	@RequestMapping("/gotocreate")
	public String gotocreatecreate() {
	
	return "create_registration";
			
}
	@RequestMapping("/delete")
	public String deletecontroller(Registrationdto dto,@RequestParam long id, Model model) {
		
           registrationService.deletelead(id);
		List<Registration> registrations = registrationService.readRegistration();
	      emailService.sendemail(dto.getEmail(), "Alert", " Your Account Validity is Expired Please Contact Our Customer care team to renew it");

		model.addAttribute("registrations",registrations);
		return "list_registrationsjsp";
		
	}
	@RequestMapping("/update")
	public String  updatecontroller(@RequestParam long id, Model model) {
		
		Registration registration = registrationService.getRegistrationbyId(id);
		model.addAttribute("registration", registration);
//		model.addAttribute("up", "Updated Info Suceessfully");

		
		return "update_registration";
		
	}
	@RequestMapping("/updatereg")
	public String  updateregcontroller( Registrationdto dto, Model model) {
	Registration reg = new Registration();
		reg.setId(dto.getId());
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
        registrationService.saveupdatedRegistration(reg);
        List<Registration> registrations = registrationService.readRegistration();
			 model.addAttribute("up", "Updated Info Suceessfully");
           model.addAttribute("registrations",registrations );      
			 return "list_registrationsjsp";	
	}
	@RequestMapping("/SearchRecord")
	public String searchbyfirstname(@RequestParam("Search") String Search ,  Model model) {
        List<Registration> registrations = registrationService.search(Search);
          
        
        model.addAttribute("registrations", registrations);
        return "list_registrationsjsp";		
	}	
	@RequestMapping("/logout")
	public String logout() {
		
		return "Create_lead";
		
	}  
	@RequestMapping("/gotohtml")
	public String gotohtml() {
		return "demoHtml";
	}
	}


	
