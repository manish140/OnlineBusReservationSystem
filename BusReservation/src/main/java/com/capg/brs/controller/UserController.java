package com.capg.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.brs.entity.User;
import com.capg.brs.service.IUserService;

import idNotFoundException.IdNotFoundException;
@RestController
@RequestMapping("/Bus")
@CrossOrigin("http://localhost:4200")

public class UserController {
	@Autowired
	private IUserService service;
	
	@GetMapping("/userlogin/{userId}/{password}")
	public ResponseEntity<User> userLogin(@PathVariable("userId") int userId,@PathVariable("password") String password)
	{
		User login=service.userLogin(userId, password);
		if(login==null)
		{
			throw new IdNotFoundException("User does not exist");
		}
		else
		{
			return new ResponseEntity<User>(login, new HttpHeaders(), HttpStatus.OK);
		}
	}
}
