package com.siddhrans.boutique.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.UserRegistrationDao;
import com.siddhrans.boutique.model.User;
import com.siddhrans.boutique.service.UserRegistrationService;

@Service("userRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	UserRegistrationDao userRegistrationDao;

	@Override
	public void saveUserDetails(User user) {
		userRegistrationDao.saveUserDetails(user);
	}
}
