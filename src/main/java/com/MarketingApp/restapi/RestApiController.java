package com.MarketingApp.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MarketingApp.entity.Registration;
import com.MarketingApp.repository.RegistrationRepository;

@RestController
public class RestApiController {

	
	//http://localhost:8080/api/registration
	@Autowired
	public RegistrationRepository registrationrepo;
	
	@GetMapping("/api/registration")
	public List<Registration> getAllReg(){
		
		List<Registration> reg = registrationrepo.findAll();
		
		return reg;
		
	}
	@PostMapping("/api/registration")
	public void saveRegistration(@RequestBody Registration registration) {
		
		registrationrepo.save(registration);
	}

	
	
	//http://localhost:8080/api/registration/1

	@DeleteMapping("api/registration/{id}")
	public void deleteRegisttration(@PathVariable long id) {
		registrationrepo.deleteById(id);
	}
	@PutMapping("api/registration/{id}")
	public void updateRegistration(@PathVariable long id, @RequestBody Registration registration) {
		Optional<Registration> findById = registrationrepo.findById(id);
		Registration reg = findById.get();
		reg.setFirstName(registration.getFirstName());
		reg.setLastName(registration.getLastName());
        reg.setEmail(registration.getEmail());
        reg.setMobile(registration.getMobile());
        registrationrepo.save(reg);
	}

	
	
	
}

