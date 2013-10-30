package com.rimt.modules.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rimt.core.AccountUserDetails;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.modules.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;


	public List<UserAccount> findAllObjects() {
		
		return null;
	}

	public UserAccount findUserBy(String email) {
		return null;
	}

	public AccountUserDetails getUserdetails(String email) {
		AccountUserDetails accountUserDetails = null;
		UserAccount userAccount = userDao.findUserBy(email);
		if (userAccount !=null){
			accountUserDetails = new AccountUserDetails(userAccount);
		}
			
		return accountUserDetails;
	}

	public UserAccount findById(Long Id) {
		return userDao.findById(Id);
	}
	
}
