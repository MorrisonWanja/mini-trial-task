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

import com.backend.developertrialtask.model.Subscriptions;
import com.backend.developertrialtask.service.SubscriptionService;


@RestController
public class SubscriptionsController {
	
	 //autowire the businessService class  
		@Autowired  
		SubscriptionService subscriptionService;  
		//Retrieve all the businesses detail from the database   
		@GetMapping("/subscriptions")  
		private List<Subscriptions> getAllSubscriptions()   
		{  
		return subscriptionService.getAllSubscriptions();  
		}  
		//Retrieve the details of a specific business  
		@GetMapping("/subscriptions/{subscriptionid}")  
		private Subscriptions getSubscriptions(@PathVariable("subscriptionid") int subscriptionid)   
		{  
		return subscriptionService.getSubscriptionById(subscriptionid);  
		}  
		//Delete a specified business  
		@DeleteMapping("/subscriptions/{subscriptionid}")  
		private void deleteSubscription(@PathVariable("subscriptionid") int subscriptionid)   
		{  
		subscriptionService.delete(subscriptionid);  
		}  
		//Post the business detail in the database  
		@PostMapping("/subscriptions")  
		private int saveSubscriptions(@RequestBody Subscriptions subscriptions)   
		{  
		subscriptionService.saveOrUpdate(subscriptions);  
		return subscriptions.getId();  
		}  
		//Update the business detail   
		@PutMapping("/subscriptions/{subscriptionid}")  
		private Subscriptions update(@RequestBody Subscriptions subscriptions)   
		{  
		subscriptionService.saveOrUpdate(subscriptions);  
		return subscriptions;  
		}  

}
