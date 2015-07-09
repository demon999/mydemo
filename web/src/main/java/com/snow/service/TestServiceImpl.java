package com.snow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	private static Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

	public void setName(String name) {
		log.info("----->setName");
	}

	public String getName() {
		log.info("----->getName");
		return "name";
	}

}
