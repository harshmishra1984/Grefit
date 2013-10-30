package com.rimt.common;

import java.util.HashMap;
import java.util.Map;

public enum UserAccountStatus {
	
	 ACTIVE(100), SUSPENDED(200), DELETED(-100);

	    private static Map<Integer, UserAccountStatus> statusMap = new HashMap<Integer, UserAccountStatus>();
	    private int value;

	    static {
	        for (UserAccountStatus status : UserAccountStatus.values()) {
	            statusMap.put(status.value(), status);
	        }
	    }

	    public int value() {
	        return value;
	    }

	    public static UserAccountStatus valueOf(Integer status) {
	        return statusMap.get(status);
	    }

	    private UserAccountStatus(int value) {
	        this.value = value;
	    }

}
