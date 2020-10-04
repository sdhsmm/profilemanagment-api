package com.swarg.profilemanagment.data.service;

import java.util.List;

import com.swarg.profilemanagment.data.domain.UserProfile;


public interface UserProfileService {
	
	UserProfile findUserProfileByEmail(String email);
	
	UserProfile findUserProfileByPhoneNo(String phoneNo);
	
	UserProfile addUserProfile(UserProfile userProfile);

	List<UserProfile> findAll();

	UserProfile findUserProfileById(Long id);

	UserProfile save(UserProfile userprofile);

	UserProfile update(UserProfile userprofile);

	void delete(Long id);

}
