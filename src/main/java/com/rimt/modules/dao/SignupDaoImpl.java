package com.rimt.modules.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rimt.dataaccess.entities.A;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.UserAccount;

@Repository
public class SignupDaoImpl implements SignupDao {
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	private CrudRepository crudRepository;

	public UserAccount saveAccountUser(UserAccount user) {
		return crudRepository.save(user);
	}

	public Organization saveOrganization(Organization org) {
		return crudRepository.save(org);
	}

	public void saveA(A a) {
		crudRepository.saveNonIdentify(a);
	}
	
	

}
