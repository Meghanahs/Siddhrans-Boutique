package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.AccessLevels;


public interface AccessLevelsService {
	public void saveAccessLevel(AccessLevels accessLevels);
	public List<AccessLevels> fetchAllAccessLevels();
	public AccessLevels fetchAccessLevelById(Integer id);
}
