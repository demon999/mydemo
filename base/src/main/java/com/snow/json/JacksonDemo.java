package com.snow.json;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonDemo {
	private static ObjectMapper mapper = new ObjectMapper();
	
	static {
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}
	
	

	public static <T> T getObjectFromJsonByjackson(String jsonString, Class<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(jsonString, clazz);
	}

	public static String getJsonStrByObject(Object object) 
			throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(object);
	}
	
	public static <T> List<T> getListFromJson(String jsonString, Class<T> clazz) 
			throws JsonParseException, IOException {
//		JsonParser jp = mapper.getJsonFactory().createJsonParser(jsonString);
//		MappingIterator<T> iterator = mapper.readValues(jp, clazz);
//		List<T> resultList = new ArrayList<T>();
//		if(iterator.hasNext()) {
//			T entity = iterator.next();
//			resultList.add(entity);
//		}
//        return resultList;
		
		TypeReference<List<T>> tr = new TypeReference<List<T>>() {};
		return mapper.readValue(jsonString, tr);
		
//		CollectionLikeType type = new CollectionLikeType(List.class,)
		
//		return null;
	}
	
	public static void main(String[] args) {
		List<TestPojo> list = new ArrayList<TestPojo>();  
        for(int i = 0; i < 10; i++) {  
            TestPojo pojo1 = new TestPojo();  
            pojo1.setName("name"+i);  
            pojo1.setSex("sex"+i);
            pojo1.setAge(i);
            list.add(pojo1);  
        } 
        
        StringWriter sw = new StringWriter();  
        try {
			mapper.writeValue(sw, list);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        try {
			List<TestPojo> aaa = getListFromJson(sw.toString(),TestPojo.class);
			System.out.println(getJsonStrByObject(aaa));
			
			List<TestPojo> beanList = mapper.readValue(sw.toString(), new TypeReference<List<TestPojo>>() {}); 
			System.out.println(getJsonStrByObject(beanList));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
