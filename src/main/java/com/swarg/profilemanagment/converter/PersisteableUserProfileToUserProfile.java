package com.swarg.profilemanagment.converter;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;

import com.swarg.profilemanagment.data.domain.UserProfile;
import com.swarg.profilemanagment.dto.PersistableUserProfile;

public class PersisteableUserProfileToUserProfile implements  Converter<PersistableUserProfile, UserProfile>{

	@Override
	public UserProfile convert(PersistableUserProfile source) {
		
		UserProfile p = new UserProfile();
		if(source.getId() != null) {
			p.setId(source.getId());
		}
		p.setEmail(source.getEmail());
		p.setPhoneNo(source.getPhoneNo());
		p.setName(source.getName());
		p.setAddress(source.getAddress());
		
		return p;
	}

}
