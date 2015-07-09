package com.snow.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snow.service.TestService;

@Controller
public class MvcDemo {
	
	private static Logger log = LoggerFactory.getLogger(MvcDemo.class);
	
	@Autowired
	private TestService testService;
	
//	@Resource(name="dataMap")
//	private HashMap<String, String> dataMap;
	
//	@Resource(name="mapBean")
//	private MapFactoryBean mapBean;
	
//	@Resource(name="emailMap")
//	private HashMap<String, String> emailMap;
//
//	@Resource(name="emailList")
//	private ArrayList<String> emailList;
//
//	@Resource(name="dataList")
//	private ArrayList<String> dataList;
	
	@RequestMapping(value="index")
	public String index() {
//		testService.setName("index");
//		log.info("name----->"+testService.getName());
		
//		log.info("xxx-->"+dataMap.get("xxx"));
//
//		log.info("emailMap-->"+emailMap.get("pechorin"));
//
//		log.info("emailList:(0)--->"+emailList.get(0));
//
//		log.info("dataList:(0)--->"+dataList.get(0));
		
		return "../index";
	}
	
}
