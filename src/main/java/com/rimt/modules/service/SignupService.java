package com.rimt.modules.service;

import com.rimt.dataaccess.entities.A;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.UserAccount;

public interface SignupService {
	
	public UserAccount saveUser(UserAccount userAccount);
	
	public UserAccount updateUser(UserAccount userAccount);
	
	public Organization saveOrganization(Organization org);
	
	
	public A saveA(A a);
	
	
	

}
