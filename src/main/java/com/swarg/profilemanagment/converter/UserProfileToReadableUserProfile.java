package com.swarg.profilemanagment.converter;

import org.springframework.core.convert.converter.Converter;

import com.swarg.profilemanagment.data.domain.UserProfile;
import com.swarg.profilemanagment.dto.PersistableUserProfile;
import com.swarg.profilemanagment.dto.ReadableUserProfile;

public class UserProfileToReadableUserProfile implements Converter<UserProfile, ReadableUserProfile> {

	@Override
	public ReadableUserProfile convert(UserProfile source) {
		ReadableUserProfile rp = new ReadableUserProfile();
		rp.setId(source.getId());
		rp.setName(source.getName());
		rp.setEmail(source.getEmail());
		rp.setPhoneNo(source.getPhoneNo());
		rp.setAddress(source.getAddress());
		return rp;
	}

}
