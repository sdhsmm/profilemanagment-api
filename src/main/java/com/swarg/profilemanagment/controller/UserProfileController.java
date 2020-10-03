package com.swarg.profilemanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swarg.profilemanagment.data.model.UserProfile;
import com.swarg.profilemanagment.data.service.UserProfileService;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(path = "/userprofiles", method = RequestMethod.GET)
	List<UserProfile> getAllUsersProfile() {
		return userProfileService.findAll();
	}

	@RequestMapping(path = "/userprofiles/{id}", method = RequestMethod.GET)
	UserProfile getUsersProfile(@PathVariable(name = "id") Long id) {
		return userProfileService.findUserProfileById(id);
	}

	@RequestMapping(path = "/userprofiles", params = { "email" }, method = RequestMethod.GET)
	UserProfile getUsersProfileByEmail(@RequestParam(name = "email") String email) {
		return userProfileService.findUserProfileByEmail(email);
	}

	@RequestMapping(path = "/userprofiles", params = { "phoneno" }, method = RequestMethod.GET)
	UserProfile getUsersProfileByPhoneNo(@RequestParam(name = "phoneno") String phoneno) {
		return userProfileService.findUserProfileByPhoneNo(phoneno);
	}

}
