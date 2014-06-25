package com.snow.log;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLog {
	
	
	static Logger log = LoggerFactory.getLogger(TestLog.class);
	
	public static void main(String[] args) {
		
		log.info("aaaa");
		
		// 
		log.info("date == calendar:"+(new Date().getTime() == Calendar.getInstance().getTimeInMillis()));
	}
}
