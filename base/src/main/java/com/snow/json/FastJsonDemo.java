package com.snow.json;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
	
	public static String fromObjectToJson(Object object) {
		return JSON.toJSONString(object);
	}
	
	public static Object fromJsonToObject(String json) {
		return JSON.parse(json);
	}
	
	public static <T> T fromJsonToBean(String json,Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	public static <T> List<T> fromJsonToList(String json,Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}
	
}
