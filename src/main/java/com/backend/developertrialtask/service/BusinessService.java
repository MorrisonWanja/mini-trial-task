package com.backend.developertrialtask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.developertrialtask.model.Business;
import com.backend.developertrialtask.repository.BusinessRepository;

@Service
public class BusinessService {
	
	@Autowired
	private BusinessRepository businessRepository;  
	//getting all business record by using the method findaAll() of CrudRepository  
	public List<Business> getAllBusinesses()   
	{  
	List<Business> businesses = new ArrayList<Business>();  
	businessRepository.findAll().forEach(business1 -> businesses.add(business1));  
	return businesses;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Business getBusinessById(int id)   
	{  
	return businessRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Business business)   
	{  
	businessRepository.save(business);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
	businessRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Business business, int businessid)   
	{  
	businessRepository.save(business);  
	}  
	
	

}
