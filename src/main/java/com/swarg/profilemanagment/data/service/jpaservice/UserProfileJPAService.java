package com.swarg.profilemanagment.data.service.jpaservice;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swarg.profilemanagment.data.domain.UserProfile;
import com.swarg.profilemanagment.data.repo.UserProfileRepository;
import com.swarg.profilemanagment.data.service.UserProfileService;

@Service
public class UserProfileJPAService implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;

	@Override
	public UserProfile findUserProfileByEmail(String email) {
		// TODO Auto-generated method stub
		UserProfile user = userProfileRepository.findByEmail(email).orElse(null);
		return user;
	}

	@Override
	public UserProfile findUserProfileByPhoneNo(String phoneNo) {
		UserProfile user = userProfileRepository.findByPhoneNo(phoneNo).orElse(null);
		return user;
	
	}

	@Override
	public UserProfile addUserProfile(UserProfile userProfile) {
		UserProfile user = userProfileRepository.save(userProfile);
		return user;
	}

	@Override
	public List<UserProfile> findAll() {
		List<UserProfile> user = userProfileRepository.findAll();
		return user;
	}

	@Override
	public UserProfile findUserProfileById(Long id) {
		UserProfile user = userProfileRepository.findById(id).orElse(null);
		return user;
	}

	@Override
	public UserProfile save(UserProfile userprofile) {
		UserProfile user = userProfileRepository.save(userprofile);
		return user;
	}

	@Override
	public UserProfile update(UserProfile userprofile) {
		UserProfile user = userProfileRepository.save(userprofile);
		return user;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userProfileRepository.deleteById(id);
	}

}
