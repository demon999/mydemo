package com.snow.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServiceImpl implements ITestService {
	
	private static Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

	public void setName(String name) {
		log.info("----->setName");
	}

	public String getName() {
		log.info("----->getName");
		return "name";
	}

}
