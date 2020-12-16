package com.lti.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	public void sendEmailId(SimpleMailMessage emailId);
}