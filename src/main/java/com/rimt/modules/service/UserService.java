package com.rimt.modules.service;


import com.rimt.core.AccountUserDetails;
import com.rimt.dataaccess.entities.UserAccount;

public interface UserService  extends GenericObjectService<UserAccount> {
	public UserAccount findUserBy(String email);
	
	public UserAccount findById(Long Id);
	
	public AccountUserDetails getUserdetails(String username);
}
