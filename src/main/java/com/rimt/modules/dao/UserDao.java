package com.rimt.modules.dao;

import com.rimt.dataaccess.entities.UserAccount;

public interface UserDao {
	
	public UserAccount findUserBy(String email);
	public UserAccount findById(Long id);

}
