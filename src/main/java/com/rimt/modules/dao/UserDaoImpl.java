package com.rimt.modules.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rimt.common.UserAccountStatus;
import com.rimt.dataaccess.entities.UserAccount;

@Repository
public class UserDaoImpl  implements UserDao {
	
	
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	private CrudRepository crudRepository;
	
	

	public UserAccount findUserBy(final String email) {
		
		   List<UserAccount> resultList = em.createQuery("FROM UserAccount WHERE email = :email and status not in (:status)", UserAccount.class)
	                .setParameter("email", email !=null ?  email.trim() : "blank@gmail.com")
	                .setParameter("status", UserAccountStatus.DELETED)
	                .getResultList();

	        return resultList.size() > 0 ? resultList.get(0) : null;
	}

	public UserAccount findById(Long id) {
		List<UserAccount> resultList = em.createQuery("FROM UserAccount WHERE id = :id", UserAccount.class)
                .setParameter("id", id)
                .getResultList();

        return resultList.size() > 0 ? resultList.get(0) : null;
	}


}
