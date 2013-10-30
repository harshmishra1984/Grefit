package com.rimt.dataaccess.entities;

import java.util.HashMap;
import java.util.Map;

public enum UnitType{
	
	YARD("yd"), SQRFT("sqft");
	
	private String value;
	
	private static Map<String, UnitType> valueMap = new HashMap<String, UnitType>();
	
	static {
		for(UnitType type : UnitType.values()){
			
			valueMap.put(type.value, type);
		}
	}
	
	public static String getUnitType(String value){
		return value;
	}

	private UnitType(String value){
		
		this.value = value;
		
	}
	
}