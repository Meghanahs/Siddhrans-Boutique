package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.DressType;

public interface DressTypeDao {
	
	DressType findById(int id);
	
	public void saveDressType(DressType dressType);
	
    void updateDressType(DressType dressType);
    
    void deleteDressType(int id);
 
    List<DressType> findAllDressTypes(); 
     
    boolean isDressTypeNameUnique(Integer id, String dressTypeName);
    
    Integer dressCount();
   
	
}
