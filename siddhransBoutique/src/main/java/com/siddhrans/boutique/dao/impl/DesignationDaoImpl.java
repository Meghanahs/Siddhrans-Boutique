package com.siddhrans.boutique.dao.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.DesignationDao;
import com.siddhrans.boutique.model.Department;
import com.siddhrans.boutique.model.Designation;

@Repository("designationDao")
@Transactional
public class DesignationDaoImpl extends AbstractDao<Integer, Designation> implements DesignationDao {

	@Override
	public void saveDesignation(Designation designation) {
		// TODO Auto-generated method stub
        persist(designation);
	}

}
