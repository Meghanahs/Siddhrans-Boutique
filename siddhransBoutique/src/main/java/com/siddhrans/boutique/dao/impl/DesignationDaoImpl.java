package com.siddhrans.boutique.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.DesignationDao;
import com.siddhrans.boutique.model.Designation;

@Repository("designationDao")
@Transactional
public class DesignationDaoImpl extends AbstractDao<Integer, Designation> implements DesignationDao {

	@Override
	public void saveDesignation(Designation designation) {
        persist(designation);
	}
	@Override
	public List<Designation> findAllDesignations() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Designation> designations = (List<Designation>) criteria.list();
		for(Designation designation:designations)
		{
			Hibernate.initialize(designation.getDepartment());
		}
		return designations;
	}
	@Override
	public Designation findByID(Integer id) {
		Designation desg= getByKey(id);
		return desg;
	}
	@Override
	public void updateDesignation(Designation designation) {
	 update(designation);
	}
}
