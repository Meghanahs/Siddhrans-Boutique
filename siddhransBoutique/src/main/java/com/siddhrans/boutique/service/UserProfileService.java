package com.siddhrans.boutique.service;

import java.util.List;

import com.siddhrans.boutique.model.UserProfile;

public interface UserProfileService {
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}
