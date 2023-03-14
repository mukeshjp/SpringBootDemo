package com.boot.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.userrepository;

@RestController
public class DemoController {
	
	@Autowired 
	userrepository ur;
	
	@PostMapping("/hii")
	public String m1()
	{
		
		return "hello world";
	}
	@PostMapping("/saveuser")
	public int saveUser(@RequestBody User u)
	{
		ur.save(u);
		return u.getAge();
	}
	@GetMapping("/getuserdata")
	public User getUserData(@RequestParam int id)
	{
		java.util.Optional<User> u = ur.findById(id);
		
		return u.get();
		
	}
	@GetMapping("/getalluserdata")
	public List<User> getAllUserData()
	{
		List<User> u = ur.findAll();
		return u;
	}
	@DeleteMapping("/deleteuserdata")
	public String deleteUserData(@RequestParam int id)
	{
		ur.deleteById(id);
		return "deleted data successfully";
	}
	
	
	

}
