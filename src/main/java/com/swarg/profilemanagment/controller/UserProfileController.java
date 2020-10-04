package com.swarg.profilemanagment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swarg.profilemanagment.converter.PersisteableUserProfileToUserProfile;
import com.swarg.profilemanagment.converter.UserProfileToReadableUserProfile;
import com.swarg.profilemanagment.data.domain.UserProfile;
import com.swarg.profilemanagment.data.service.UserProfileService;
import com.swarg.profilemanagment.dto.PersistableUserProfile;
import com.swarg.profilemanagment.dto.ReadableUserProfile;

@RestController
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	/*--------------------------create-----------------------------------*/

	@RequestMapping(path = "/userprofiles", method = RequestMethod.POST)
	ReadableUserProfile saveUserProfile(@RequestBody PersistableUserProfile persistableUserProfile) {
		System.out.println(persistableUserProfile);
		UserProfile userprofile = new PersisteableUserProfileToUserProfile().convert(persistableUserProfile);
		userprofile = userProfileService.save(userprofile);
		return new UserProfileToReadableUserProfile().convert(userprofile);

	}
	
	
	/*--------------------------update-----------------------------------*/

	@RequestMapping(path = "/userprofiles", method = RequestMethod.PUT)
	ReadableUserProfile updateUserProfile(@RequestBody PersistableUserProfile persistableUserProfile) {
		System.out.println(persistableUserProfile);
		UserProfile userprofile = new PersisteableUserProfileToUserProfile().convert(persistableUserProfile);
		userprofile = userProfileService.update(userprofile);
		return new UserProfileToReadableUserProfile().convert(userprofile);

	}
	

	/*--------------------------Retrieve--------------------------------*/

	@RequestMapping(path = "/userprofiles", method = RequestMethod.GET)
	List<ReadableUserProfile> getAllUsersProfile() {
		List<UserProfile> usrs = userProfileService.findAll();
		return usrs.stream().map(new UserProfileToReadableUserProfile()::convert).collect(Collectors.toList());
	}

	@RequestMapping(path = "/userprofiles/{id}", method = RequestMethod.GET)
	ReadableUserProfile getUsersProfile(@PathVariable(name = "id") Long id) {

		return new UserProfileToReadableUserProfile().convert(userProfileService.findUserProfileById(id));
	}

	@RequestMapping(path = "/userprofiles", params = { "email" }, method = RequestMethod.GET)
	ReadableUserProfile getUsersProfileByEmail(@RequestParam(name = "email") String email) {
		return new UserProfileToReadableUserProfile().convert(userProfileService.findUserProfileByEmail(email));
	}

	@RequestMapping(path = "/userprofiles", params = { "phoneno" }, method = RequestMethod.GET)
	ReadableUserProfile getUsersProfileByPhoneNo(@RequestParam(name = "phoneno") String phoneno) {
		return new UserProfileToReadableUserProfile().convert(userProfileService.findUserProfileByPhoneNo(phoneno));
	}
	
	/*--------------------------delete-----------------------------------*/

	@RequestMapping(path = "/userprofiles/{id}", method = RequestMethod.DELETE)
	ResponseEntity deleteUserProfile(@PathVariable(name = "id") Long id) {
		userProfileService.delete(id);
		return ResponseEntity.ok().build();

	}

}
