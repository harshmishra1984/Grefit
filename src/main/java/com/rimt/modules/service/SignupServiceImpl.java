package com.rimt.modules.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rimt.dataaccess.entities.A;
import com.rimt.dataaccess.entities.Builders;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.dataaccess.entities.UserBuildersMapping;
import com.rimt.dataaccess.entities.UserExperties;
import com.rimt.modules.dao.SignupDao;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {
	
	@Resource
	protected SignupDao signDao;

	public UserAccount saveUser(UserAccount user) {
		return signDao.saveAccountUser(user);
	}
	
	public UserAccount updateUser(UserAccount user) {
		return signDao.saveAccountUser(user);
	}

	public Organization saveOrganization(Organization org) {
		return signDao.saveOrganization(org);
		
	}

	public A saveA(A a) {
		signDao.saveA(a);
		return null;
	}

}
