package com.siddhrans.boutique.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siddhrans.boutique.dao.AccessLevelDao;
import com.siddhrans.boutique.model.AccessLevels;
import com.siddhrans.boutique.service.AccessLevelsService;

public class AccessLevelsServiceImpl implements AccessLevelsService {

	@Autowired
	AccessLevelDao accessLevelDao;

	@Override
	public void saveAccessLevel(AccessLevels accessLevels) {
		accessLevelDao.saveAccessLevel(accessLevels);
	}

	@Override
	public List<AccessLevels> fetchAllAccessLevels() {
		return accessLevelDao.fetchAllAccessLevels();
	}

	@Override
	public AccessLevels fetchAccessLevelById(Integer id) {
		return accessLevelDao.fetchAccessLevelById(id);
	}

}
