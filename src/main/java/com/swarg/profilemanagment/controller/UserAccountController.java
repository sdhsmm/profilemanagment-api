package com.swarg.profilemanagment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swarg.profilemanagment.converter.PersisteableUserProfileToUserProfile;
import com.swarg.profilemanagment.data.domain.UserProfile;
import com.swarg.profilemanagment.data.service.UserProfileService;
import com.swarg.profilemanagment.dto.PersistableUserProfile;

@RestController
public class UserAccountController {

	@Autowired
	UserProfileService userProfileService;
	
	

}
