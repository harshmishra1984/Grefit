package com.rimt.dataaccess.entities;

import java.util.HashMap;
import java.util.Map;
public enum UserType {
	
	BROKER("Broker"), FreeLauncher("FreeLauncher");
	
	private String value ;
	
	private static Map<String, UserType> userTypeMap = new HashMap<String, UserType> ();
	
	static {
		for (UserType type: UserType.values()){
			userTypeMap.put(type.value, type);
		}
		
	}
	
	public String value(){
		return value;
	}
	
	public static UserType getValue(String type){
		return userTypeMap.get(type);
	}
	
	private UserType(String value){
		this.value = value; 
	}
	
	
	

}
