package com.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.dto.LoginDto;
import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.rest.UserRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserRestControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	UserRepository userRepo;

	@InjectMocks
	UserRestController urc;

	@Test
	void testCreateUser() throws Exception {
		User user = new User(1001, "Akankshya", "Tripathy", "India", "Odisha", "Khordha", "akankshyat@gmail.com",
				"7893892988");
		when(userRepo.save(user)).thenReturn(user);

		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(user);

		mvc.perform(post("/user/users/create").contentType(MediaType.APPLICATION_JSON).content(value))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}

	@Test
	void testUpdateUser() throws Exception {
		User user = new User(1001, "Akankshya", "Tripathy", "India", "Odisha", "Khordha", "akankshyat@gmail.com",
				"7893892988");
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(user));

		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(user);
		
		mvc.perform(put("/user/users/update").contentType(MediaType.APPLICATION_JSON).content(value))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

	}
	
	@Test
	void test2UpdateUser() throws Exception {
		User user = new User(1001, "Akankshya", "Tripathy", "India", "Odisha", "Khordha", "akankshyat@gmail.com",
				"7893892988");
		Mockito.when(userRepo.findById(1002)).thenReturn(Optional.of(user));

		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(user);
		
		mvc.perform(put("/user/users/update").contentType(MediaType.APPLICATION_JSON).content(value))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());

	}
	
	@Test
	void testGetUserDetails() throws Exception {
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(new User(1, "Akankshya", "Tripathy", "India",
				"Odisha", "Khordha", "akankshyat@gmail.com", "7893892988")));
		
		
		mvc.perform(get("/user/user/1001").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		//.andExpect(jsonPath("$.[0].firstName").value("Akankshya"));
		
	}
	

	@Test
	void testGetAllUsers() throws Exception {
		List<User> user = new ArrayList<>();
		user.add(new User(1001, "Akankshya", "Tripathy", "India", "Odisha", "Khordha", "akankshyat@gmail.com",
				"7893892988"));
		Mockito.when(userRepo.findAll()).thenReturn(user);

		mvc.perform(get("/user/users").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.[0].firstName").value("Akankshya"));

	}

	@Test
	void testLoginDetails() throws Exception {
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(new User(1, "Akankshya", "Tripathy", "India",
				"Odisha", "Khordha", "akankshyat@gmail.com", "7893892988")));

		LoginDto login = new LoginDto(1001, "7893892988");
        String loginAsJsonStr = new ObjectMapper().writeValueAsString(login);
		
		mvc.perform(post("/user/login").accept(MediaType.APPLICATION_JSON).content(loginAsJsonStr).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));
		
		
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(new User(1, "Akankshya", "Tripathy", "India",
				"Odisha", "Khordha", "akankshyat@gmail.com", "7893892988")));

		LoginDto login1 = new LoginDto(1001, "1234567890");
        String loginAsJsonVar = new ObjectMapper().writeValueAsString(login1);
		
		mvc.perform(post("/user/login").accept(MediaType.APPLICATION_JSON).content(loginAsJsonVar).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));
		
		
		

	}

	@Test
	void testLogoutUser() throws Exception {
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(new User(1, "Akankshya", "Tripathy", "India",
				"Odisha", "Khordha", "akankshyat@gmail.com", "7893892988")));
		
		

		mvc.perform(post("/user/logout/{userId}", 1001).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));

	}
	
	@Test
	void test2LogoutUser() throws Exception {
		Mockito.when(userRepo.findById(1001)).thenReturn(Optional.of(new User(1, "Akankshya", "Tripathy", "India",
				"Odisha", "Khordha", "akankshyat@gmail.com", "7893892988")));
		

		mvc.perform(post("/user/logout/{userId}", 1002).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print());
		// .andExpect(jsonPath("$.firstName").value("Akankshya"));

	}
}
