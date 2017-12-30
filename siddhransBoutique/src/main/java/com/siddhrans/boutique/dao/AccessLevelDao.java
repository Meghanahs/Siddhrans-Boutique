package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.AccessLevels;

public interface AccessLevelDao {
	
	public AccessLevels fetchAccessLevelById(Integer id);
	
	public List<AccessLevels> fetchAllAccessLevels();
	
	public void saveAccessLevel(AccessLevels accessLevels);
}
