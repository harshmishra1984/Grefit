package com.rimt.modules.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rimt.dataaccess.entities.IdentifiableEntity;

@Repository
public class CRUDRepositoryImpl implements CrudRepository {
	
	   	private static final Pattern REGEX_MAIN_QUERY = Pattern.compile("\\((.+)\\)\\s+main");

	    @PersistenceContext
	    protected EntityManager em;

	    @Resource
	    private JdbcTemplate jdbcTemplate;
	    
	    public <T extends IdentifiableEntity> List<T> findAll(Class<T> clazz) {
	        return em.createQuery("FROM " + clazz.getName(), clazz).getResultList();
	    }

	    public <T extends IdentifiableEntity> List<T> findAll(Long accountId, Class<T> clazz) {
	        return em.createQuery("FROM " + clazz.getName() + " WHERE account.id = :accountId", clazz)
	                .setParameter("accountId", accountId)
	                .getResultList();
	    }
	    
	    public <T extends IdentifiableEntity> List<T> findAllById(Long accountId, Class<T> clazz) {
	        return em.createQuery("FROM " + clazz.getName() + " WHERE account.id = :accountId", clazz)
	                .setParameter("accountId", accountId)
	                .getResultList();
	    }

	    public <T extends IdentifiableEntity> T findBy(Long id, Class<T> clazz) {
	        return em.find(clazz, id);
	    }

	    public <T extends IdentifiableEntity> T findBy(Long accountId, Long id, Class<T> clazz) {
	        Map<String, Object> properties = new HashMap<String, Object>();
	        properties.put("accountId", accountId);
	        return em.find(clazz, id, properties);
	    }

	    public <T extends IdentifiableEntity> T save(T entity) {
	        Session session = (Session) em.getDelegate();
	        session.saveOrUpdate(entity);
	        return entity;
	    }

	    public <T extends IdentifiableEntity> void remove(T entity) {
	        em.remove(entity);
	    }

	    public void insertBatchSQL(final String[] sql){
			 
	    	jdbcTemplate.batchUpdate(sql);
		 
		}

		public <T> T saveNonIdentify(T entity) {
			 Session session = (Session) em.getDelegate();
		     session.saveOrUpdate(entity);
		     return entity;
		}

	    }
