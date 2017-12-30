package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.AccessLevelDao;
import com.siddhrans.boutique.model.AccessLevels;

@Repository("accessLevelsDao")
@Transactional
public class AccessLevelsDaoImpl extends AbstractDao<Integer, AccessLevels> implements AccessLevelDao {

	@Override
	public AccessLevels fetchAccessLevelById(Integer id) {
		return getByKey(id);
	}

	@Override
	public List<AccessLevels> fetchAllAccessLevels() {		
		return getAll(new AccessLevels());
	}
	
	public void saveAccessLevel(AccessLevels accessLevels) {
		persist(accessLevels);
	}
	
	

}
