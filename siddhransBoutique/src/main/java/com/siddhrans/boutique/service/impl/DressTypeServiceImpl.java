package com.siddhrans.boutique.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhrans.boutique.dao.DressTypeDao;
import com.siddhrans.boutique.model.DressType;
import com.siddhrans.boutique.service.DressTypeService;

@Service("dressTypeService")
@Transactional
public class DressTypeServiceImpl implements DressTypeService {

	@Autowired
	DressTypeDao dressTypeDao; 
	
	@Override
	public void saveDressType(DressType dressType) {
		dressTypeDao.saveDressType(dressType);
	}

	@Override
	public DressType findById(int id) {
		return dressTypeDao.findById(id);
	}

	@Override
	public void updateDressType(DressType dressType) {
		dressTypeDao.updateDressType(dressType);
	}

	@Override
	public void deleteDressType(int id) {
		dressTypeDao.deleteDressType(id);
	}

	@Override
	public List<DressType> findAllDressTypes() {
		return dressTypeDao.findAllDressTypes();
	}

	@Override
	public boolean isDressTypeNameUnique(Integer id, String dressTypeName) {
		// TODO Auto-generated method stub
		return false;
	}

}
