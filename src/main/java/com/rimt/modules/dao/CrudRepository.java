package com.rimt.modules.dao;

import java.util.List;

import com.rimt.dataaccess.entities.IdentifiableEntity;

public interface CrudRepository {
	
	 	<T extends IdentifiableEntity> List<T> findAll(Class<T> clazz);

	    <T extends IdentifiableEntity> List<T> findAll(Long accountId, Class<T> clazz);

	    <T extends IdentifiableEntity> T findBy(Long id, Class<T> clazz);

	    <T extends IdentifiableEntity> T findBy(Long accountId, Long id, Class<T> clazz);

	    <T extends IdentifiableEntity> T save(T entity);
	    
	    <T> T saveNonIdentify(T entity);

	    <T extends IdentifiableEntity> void remove(T entity);
	    
	    public void insertBatchSQL(final String [] sql);
			

	   /* <T extends IdentifiableEntity> Page<T> findAll(PagingParameter pagingParameter, Class<T> clazz);

	    <T extends IdentifiableEntity> Page<T> findAll(Long accountId, PagingParameter pagingParameter, Class<T> clazz);

	    <T extends IdentifiableEntity> Page<T> findPage(PagingParameter pagingParameter, String queryString, Map<String, ?> values, Class<T> clazz);

	    <T extends Object> Page<T> simpleFindPage(PagingParameter pagingParameter, String queryString, Object[] queryArgs, Class<T> clazz);

	    <T extends Object> Page<T> simpleFindPage(PagingParameter pagingParameter, String queryString, Object[] queryArgs, String countString, Object[] countArgs, Class<T> clazz);*/

}
