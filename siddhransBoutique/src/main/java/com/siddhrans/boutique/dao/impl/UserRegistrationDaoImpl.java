package com.siddhrans.boutique.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.UserRegistrationDao;
import com.siddhrans.boutique.model.AccessLevels;
import com.siddhrans.boutique.model.User;

@Repository("userRegistrationDao")
@Transactional
public class UserRegistrationDaoImpl  extends AbstractDao<Integer, User> implements UserRegistrationDao {

	@Override
	public void saveUserDetails(User user) {
		user.setAccessLevels(new AccessLevels(2,"EMPLOYEE"));
		persist(user);
	}
}
