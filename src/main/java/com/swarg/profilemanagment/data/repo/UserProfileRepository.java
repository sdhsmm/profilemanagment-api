package com.swarg.profilemanagment.data.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swarg.profilemanagment.data.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	Optional<UserProfile> findByEmail(String email);

	Optional<UserProfile> findByPhoneNo(String phoneNo);

}
