package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.LoginDto;
import com.demo.entity.User;
import com.demo.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	//-------------------------------user login-------------------------------------------------------------------------
	public String login(LoginDto login) {
		Optional<User> userOpt = userRepo.findById(login.getUserId());
		if (userOpt.isPresent()) {
			User user = userOpt.get();
			if (user.getMobileNumber().equals(login.getMobileNumber())) { 
				userRepo.save(user);
				return "Login successful!!" + " " + user.getUserId() + " " + user.getFirstName()
								+ " " + user.getLastName() + " " + user.getState() + " " + user.getCountry() + " "
								+ user.getDistrict() + " " + user.getEmail() + " " + user.getMobileNumber();
			}
		}
		return "Login failed! Please enter correct userId and password..";
		
	}

	//----------------------------------------user logout---------------------------------------------------------------------
	public String logoutUser(int userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		if (userOpt.isPresent()) {
			User user = userOpt.get();
				userRepo.save(user);
				return "User " + user.getFirstName() + " has successfully logged out !!!";
		} else {
			return "Invalid User: User doesnot exists !!!";
		}
		
	}
	

	// ------------------------------create user-----------------------------------------------------------------------------
	public String addUser(User user) {
		userRepo.save(user);
		return " New User with " + user.getUserId() + " has been successfully created in the database !! ";
		
	}

	//---------------------------------- update user-------------------------------------------------------------------------
	public String updateUser(User user) {
		Optional<User> userOpt = userRepo.findById(user.getUserId());
		if (userOpt.isPresent()) {
			userRepo.save(user);
			return "User: " + user.getUserId() + " updated in the database !! ";
		} else {
			return "Invalid User: User doesnot exists in the database!!!";
		}

	}
	
	//------------------------------get details of only one user-------------------------------------------------------------
	public String getUserDetails(int userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		if(userOpt.isPresent()) {
			return "User details: " + userOpt.get().getUserId() + " " + userOpt.get().getFirstName() +
					" " + userOpt.get().getLastName() + " " + userOpt.get().getCountry() + " " + userOpt.get().getState() +
					" " + userOpt.get().getDistrict() + " " + userOpt.get().getEmail() + " " + userOpt.get().getMobileNumber();
		} else {
			return "User details not found!!";
		}
	}

	// ----------------------------retrieve user details of all users--------------------------------------------------------
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
