package com.siddhrans.boutique.dao.impl;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import com.siddhrans.boutique.dao.AbstractDao;
import com.siddhrans.boutique.dao.DressTypeDao;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.model.Employee;


@Repository("dressTypeDao")
@Transactional
public class DressTypeDaoImpl extends AbstractDao<Integer, DressType> implements DressTypeDao {

	@Override
	public void saveDressType(DressType dressType) {
		dressType.setDressName(dressType.getDressName().toUpperCase());		
		persist(dressType);
	}
	
	@Override
	public DressType findById(int id) {
		DressType dressType = getByKey(id);
		/*if(user!=null){
			Hibernate.initialize(user.getUserProfile());
		}*/
		return dressType;
	}
	
	@Override
	public void updateDressType(DressType dressType) {
		update(dressType);	
		
	}

	@Override
	public void deleteDressType(int id) {
	      DressType dress=getByKey(id);
			delete(dress);
		}

	@Override
	public boolean isDressTypeNameUnique(Integer id, String dressTypeName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DressType> findAllDressTypes() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<DressType> dressTypes = (List<DressType>) criteria.list();
		/*for(DressType dressType:dressTypes)
		{
			Hibernate.initialize(dressType.getDesignations());
		}*/
		return dressTypes;
	}

	@Override
	public Integer dressCount() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<DressType> dressTypesCount = (List<DressType>) criteria.list();
		return dressTypesCount.size();
	}


	
}
