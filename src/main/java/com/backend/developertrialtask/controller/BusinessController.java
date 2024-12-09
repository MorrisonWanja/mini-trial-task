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

import com.backend.developertrialtask.model.Business;
import com.backend.developertrialtask.service.BusinessService;

@RestController
public class BusinessController {
	
	 //autowire the businessService class  
	@Autowired  
	BusinessService businessService;  
	//Retrieve all the businesses detail from the database   
	@GetMapping("/business")  
	private List<Business> getAllBusinesses()   
	{  
	return businessService.getAllBusinesses();  
	}  
	//Retrieve the details of a specific business  
	@GetMapping("/business/{businessid}")  
	private Business getBusinesses(@PathVariable("businessid") int businessid)   
	{  
	return businessService.getBusinessById(businessid);  
	}  
	//Delete a specified business  
	@DeleteMapping("/business/{businessid}")  
	private void deleteBusiness(@PathVariable("businessid") int businessid)   
	{  
	businessService.delete(businessid);  
	}  
	//Post the business detail in the database  
	@PostMapping("/business")  
	private int saveBusiness(@RequestBody Business business)   
	{  
	businessService.saveOrUpdate(business);  
	return business.getId();  
	}  
	//Update the business detail   
	@PutMapping("/business/{businessid}")  
	private Business update(@RequestBody Business business)   
	{  
	businessService.saveOrUpdate(business);  
	return business;  
	}  

}
