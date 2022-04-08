package com.code.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.code.utils.SmtpMailSender;


@RestController
public class CodeTruffleController {

	@Autowired
	private SmtpMailSender smtpmailSender;

	@RequestMapping("/")
	public ModelAndView homepage() {
		return new ModelAndView("homepage");
	}

	

	@RequestMapping(value = "/sent", method = RequestMethod.POST)
	public String handleForm(HttpServletRequest request, SessionStatus status) throws MessagingException

	{
		String name = request.getParameter("name").toUpperCase().trim();
		String email = request.getParameter("email").trim();
		String subject = request.getParameter("subject").trim();
		String message = request.getParameter("message").trim();

		System.out.println(name);
		System.out.println(email);
		System.out.println(subject);

		System.out.println(message);

		smtpmailSender.send(name, email, subject, message);

		status.setComplete();
		return "Your message has been sent successfully";
	}

	@RequestMapping(value = "/codetruffle")
	public ModelAndView codeTruffle() {
		return new ModelAndView("CodeTruffle");
	}

	@RequestMapping(value = "/chat")
	public ModelAndView chat() {
		return new ModelAndView("chat");
	}

}

