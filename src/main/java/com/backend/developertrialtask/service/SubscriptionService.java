package com.backend.developertrialtask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.developertrialtask.model.Subscriptions;
import com.backend.developertrialtask.repository.SubscriptionsRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionsRepository subscriptionsRepository;  
	//getting all Users records by using the method findaAll() of CrudRepository  
	public List<Subscriptions> getAllSubscriptions()   
	{  
	List<Subscriptions> subscriptions = new ArrayList<Subscriptions>();  
	subscriptionsRepository.findAll().forEach(subscription -> subscriptions.add(subscription));  
	return subscriptions;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Subscriptions getSubscriptionById(int id)   
	{  
	return subscriptionsRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Subscriptions subscriptions)   
	{  
	subscriptionsRepository.save(subscriptions);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
	subscriptionsRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Subscriptions subscriptions, int subscriptionid)   
	{  
	subscriptionsRepository.save(subscriptions);  
	} 


}
