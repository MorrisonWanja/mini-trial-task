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
import com.backend.developertrialtask.service.ProductsService;

@RestController
public class ProductsController {
	
	 //autowire the businessService class  
		@Autowired  
		ProductsService productsService;  
		//Retrieve all the products detail from the database   
		@GetMapping("/products")  
		private List<Products> getAllProducts()   
		{  
		return productsService.getAllProducts();  
		}  
		//Retrieve the detail of a specific product  
		@GetMapping("/products/{productid}")  
		private Products getProducts(@PathVariable("productid") int productid)   
		{  
		return productsService.getProductById(productid);  
		}  
		//Delete a specified product  
		@DeleteMapping("/products/{productid}")  
		private void deleteProduct(@PathVariable("productid") int productid)   
		{  
	    productsService.delete(productid);  
		}  
		//Post the product detail in the database  
		@PostMapping("/products")  
		private int saveBusiness(@RequestBody Products product)   
		{  
		productsService.saveOrUpdate(product);  
		return product.getId();  
		}  
		//creating put mapping that updates the book detail   
		@PutMapping("/products/{productid}")  
		private Products update(@RequestBody Products product)   
		{  
		productsService.saveOrUpdate(product);  
		return product;  
		}  


}
