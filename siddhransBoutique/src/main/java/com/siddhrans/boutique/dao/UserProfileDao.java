package com.siddhrans.boutique.dao;

import java.util.List;

import com.siddhrans.boutique.model.UserProfile;

public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}