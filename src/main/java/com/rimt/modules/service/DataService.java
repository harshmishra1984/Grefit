package com.rimt.modules.service;

import java.util.List;

import javax.persistence.Entity;

import com.rimt.dataaccess.entities.Builders;
import com.rimt.dataaccess.entities.City;
import com.rimt.dataaccess.entities.Country;
import com.rimt.dataaccess.entities.IdentifiableEntity;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.Roles;
import com.rimt.dataaccess.entities.State;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.dataaccess.entities.UserExperties;
import com.rimt.form.OrganizationForm;

public interface DataService {
	
	public List<State> getAllStates();
	
	public List<City> getAllCities();
	
	public <T extends IdentifiableEntity> T getEntity(long id, Class<T> clazz);
	
	public <T extends IdentifiableEntity> T saveEntity(T entity);
	
	public Organization gerOrganization(Long id);
	
	public Roles getRole(Long id);
	
	public Builders getBuilders(Long id);
	
	public UserExperties getUserExperties(Long id);
	
	public City getCity(Long id);
	
	public Country getCountry(Long id);
	
	public State getState(Long id);
	
	public List<Builders> getAllBuilders();
	
	public List<UserExperties> getAllExperties();
	
	public void updateUserBuildersMapping(UserAccount user, List<Builders> builders) ;
	
	public void updateUserExpertiesMapping(UserAccount user, List<UserExperties> experties);
	

}
