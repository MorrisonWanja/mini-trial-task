package com.backend.developertrialtask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.developertrialtask.model.Products;
import com.backend.developertrialtask.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;  
	//getting all products records by using the method findaAll() of CrudRepository  
	public List<Products> getAllProducts()   
	{  
	List<Products> products = new ArrayList<Products>();  
	productsRepository.findAll().forEach(product -> products.add(product));  
	return products;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Products getProductById(int id)   
	{  
	return productsRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Products products)   
	{  
	productsRepository.save(products);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
	productsRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Products products, int productid)   
	{  
	productsRepository.save(products);  
	} 

}
