package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.LoginDto;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepo;

	// ------------------------------create user-----------------------------------------------------------------------------
	@PostMapping(path = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);

	}

	//---------------------------------- update user-------------------------------------------------------------------------
	@PutMapping(path = "/users/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);

	}

	// ----------------------------retrieve user details of all users----------------------------------------------------
	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}
	
	//------------------------------get details of only one user-------------------------------------------------------------
	@GetMapping(path = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUserDetails(@PathVariable int userId) {
		return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);

	}
	
	//-------------------------------user login-------------------------------------------------------------------------
	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginDetails(@RequestBody LoginDto login) {
		return new ResponseEntity<>(userService.login(login), HttpStatus.OK);
	}

	//----------------------------------------user logout---------------------------------------------------------------------
	@PostMapping(path = "/logout/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> logoutUser(@PathVariable int userId) {
		return new ResponseEntity<>(userService.logoutUser(userId), HttpStatus.OK);
	}

}
