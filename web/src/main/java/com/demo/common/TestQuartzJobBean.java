package com.demo.common;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestQuartzJobBean extends QuartzJobBean {
	
	private String name;
	
	private String prop;

	@Override
	protected void executeInternal(JobExecutionContext context)throws JobExecutionException {
		System.out.println("TestQuartzJobBean:"+name+"--->"+prop);
	}

}
