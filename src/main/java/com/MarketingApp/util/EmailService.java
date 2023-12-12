package com.MarketingApp.util;

import java.util.Random;

import javax.mail.Message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	
	public void sendemail(String to, String subject,int otpp) {
		 

		        int otp = 0;
		        for (int i = 0; i < 100; i++) {
		            Random rand = new Random();
		            int min = 100000;
		            int max = 999999;
		            otp = rand.nextInt(max - min + 1) + min;
		            System.out.println(otp);
		        }
		        SimpleMailMessage message = new SimpleMailMessage();
		        message.setTo(to);
		        message.setSubject(subject);
		        message.setText(String.valueOf(otp));

		        sender.send(message);
		    }


	
           
}