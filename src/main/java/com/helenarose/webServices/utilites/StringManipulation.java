package com.helenarose.webServices.utilites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;



public class StringManipulation {
	
	public static String capitalize(String str) {
		
		String strUpper = str.substring(0,1).toUpperCase();
		
		return strUpper;
		
	}
	
	public static <T>  T  lowerCase(T object) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String objectString = objectMapper.writeValueAsString(object);
		String[] splittedObject = objectString.split(" ");
		for(String i : splittedObject) {
			System.out.println(i);
		}
		
		
		return object;
		
	}

}
