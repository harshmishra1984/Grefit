package com.rimt.modules.dao;

import com.rimt.dataaccess.entities.A;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.UserAccount;

public interface SignupDao {
	
	public UserAccount saveAccountUser(final UserAccount user);
	
	public Organization saveOrganization(final Organization org);
	
	public void saveA(A a);

}
