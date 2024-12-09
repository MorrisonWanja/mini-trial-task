package com.backend.developertrialtask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.developertrialtask.model.Products;
import com.backend.developertrialtask.model.Users;
import com.backend.developertrialtask.service.ProductsService;
import com.backend.developertrialtask.service.UsersService;

@RestController
public class UsersController {
	
	      //autowire the businessService class  
			@Autowired  
			UsersService usersService;  
			//Retrieve all the products detail from the database   
			@GetMapping("/users")  
			private List<Users> getAllUsers()   
			{  
			return usersService.getAllUsers();  
			}  
			//Retrieve the detail of a specific product  
			@GetMapping("/users/{userid}")  
			private Users getUsers(@PathVariable("userid") int userid)   
			{  
			return usersService.getUserById(userid);  
			}  
			//Delete a specified product  
			@DeleteMapping("/users/{userid}")  
			private void deleteUser(@PathVariable("userid") int userid)   
			{  
		    usersService.delete(userid);  
			}  
			//Post the product detail in the database  
			@PostMapping("/users")  
			private int saveUsers(@RequestBody Users user)   
			{  
			usersService.saveOrUpdate(user);  
			return user.getId();  
			}  
			//creating put mapping that updates the book detail   
			@PutMapping("/users/{userid}")  
			private Users update(@RequestBody Users user)   
			{  
			usersService.saveOrUpdate(user);  
			return user;  
			}  

}
