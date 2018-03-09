package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.DressType;

public interface DressTypeService {
	
	 public DressType findById(int id);	 
	 public void saveDressType(DressType dressType);		
	 void updateDressType(DressType dressType);
     void deleteDressType(int id);
     List<DressType> findAllDressTypes();      
     boolean isDressTypeNameUnique(Integer id, String dressTypeName); 
     Integer dressCount();
     
     
	

}
