package com.skc.transaction.config;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.skc.transaction.schedule.EmailSendingJob;

@Configuration
public class Config {

	@Bean
	public JobDetailFactoryBean jobDetail() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(EmailSendingJob.class);
		jobDetailFactory.setDescription("Invoke Sample Job service...");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	@Bean
	public SimpleTriggerFactoryBean trigger(JobDetail job) {
		SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
		trigger.setJobDetail(job);
		trigger.setRepeatInterval(1000);
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		return trigger;
	}
		
}
