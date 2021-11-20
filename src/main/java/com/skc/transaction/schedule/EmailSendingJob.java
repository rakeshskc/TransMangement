package com.skc.transaction.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.skc.transaction.Service.EmailService;

public class EmailSendingJob implements Job {

	@Autowired
	private EmailService jobService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {

		// Logic here to get email Id and body
		jobService.sendEmail("rakeshchaudhari1111@gmail.com", "Hi Rakesh!!");
	}

}