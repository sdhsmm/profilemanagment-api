package com.swarg.profilemanagment.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swarg.profilemanagment.data.model.UserProfile;


public interface UserProfileService {
	
	UserProfile findUserProfileByEmail(String email);
	
	UserProfile findUserProfileByPhoneNo(String phoneNo);
	
	UserProfile addUserProfile(UserProfile userProfile);

	List<UserProfile> findAll();

	UserProfile findUserProfileById(Long id);

}
