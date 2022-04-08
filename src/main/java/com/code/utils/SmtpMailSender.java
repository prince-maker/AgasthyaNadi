package com.code.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SmtpMailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String name, String email,String subject,String mes ) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper = new MimeMessageHelper(message, true);
		helper.setTo("notification.sunil@gmail.com");
		helper.setSubject(subject);
		helper.setText("Hello i'm " + name + " and my mail Id is " +email+" My message is "+ mes);
		javaMailSender.send(message);
		
	}													

}
