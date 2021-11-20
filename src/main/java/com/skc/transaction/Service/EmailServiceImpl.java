package com.skc.transaction.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Override
	public void sendEmail(String email, String body) {
		logger.info(String.format("Sending email"));
	}

}
