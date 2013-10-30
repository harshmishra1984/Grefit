package com.rimt.modules.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rimt.dataaccess.entities.Builders;
import com.rimt.dataaccess.entities.City;
import com.rimt.dataaccess.entities.Country;
import com.rimt.dataaccess.entities.IdentifiableEntity;
import com.rimt.dataaccess.entities.Organization;
import com.rimt.dataaccess.entities.Roles;
import com.rimt.dataaccess.entities.State;
import com.rimt.dataaccess.entities.UserAccount;
import com.rimt.dataaccess.entities.UserBuildersMapping;
import com.rimt.dataaccess.entities.UserExperties;
import com.rimt.modules.dao.CrudRepository;

@Service
@Transactional
public class DataServiceImpl implements DataService {

	@Autowired
	private CrudRepository crudRepository;

	public List<State> getAllStates() {
		return crudRepository.findAll(State.class);
	}

	public Roles getRole(Long id) {
		return crudRepository.findBy(id, Roles.class);
	}

	public List<Builders> getAllBuilders() {
		return crudRepository.findAll(Builders.class);
	}

	public List<UserExperties> getAllExperties() {
		return crudRepository.findAll(UserExperties.class);
	}

	public Builders getBuilders(Long id) {
		return crudRepository.findBy(id, Builders.class);
	}

	public UserExperties getUserExperties(Long id) {
		return crudRepository.findBy(id, UserExperties.class);
	}

	public City getCity(Long id) {
		return crudRepository.findBy(id, City.class);
	}

	public List<City> getAllCities() {
		return crudRepository.findAll(City.class);
	}

	public Organization gerOrganization(Long id) {
		return crudRepository.findBy(id, Organization.class);
	}
	

	public void updateUserBuildersMapping(UserAccount user,
			List<Builders> builders) {
		String sql = "INSERT INTO user_account_builders_mapping " +
				"(user_id, builder_id) VALUES (%d, %d)";
		List<String> strList =  new ArrayList<String>();
		
		
		for (int i = 0; i<builders.size(); i++){
			strList.add(sql.format(sql, user.getId(), builders.get(i).getId()));
		}
		crudRepository.insertBatchSQL(strList.toArray(new String[strList.size()]));
		
	}
	
	

	public void updateUserExpertiesMapping(UserAccount user,
			List<UserExperties> experties) {
		String sql = "INSERT INTO appmail_list_subscriber " +
				"(user_id, experties_id) VALUES (%d, %d)";
		List<String> strList =  new ArrayList<String>();
		
		for (int i = 0; i<experties.size(); i++){
			strList.add(sql.format(sql, user.getId(), experties.get(i).getId()));
		}
		crudRepository.insertBatchSQL(strList.toArray(new String[strList.size()]));		
	}

	public Country getCountry(Long id) {
		return crudRepository.findBy(id, Country.class);
	
	}

	public State getState(Long id) {
		return crudRepository.findBy(id, State.class);
	}

	public <T extends IdentifiableEntity> T getEntity(long id, Class<T> clazz) {
		return crudRepository.findBy(id, clazz);
	}

	public <T extends IdentifiableEntity> T saveEntity(T entity) {
		return crudRepository.save(entity);
	}

}
