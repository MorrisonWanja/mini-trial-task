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

import com.backend.developertrialtask.model.Branches;
import com.backend.developertrialtask.service.BranchesService;

@RestController
public class BranchesController {
	
	//autowire the branchService class  
		@Autowired  
		BranchesService branchesService;  
		//creating a get mapping that retrieves all the business detail from the database   
		@GetMapping("/branches")  
		private List<Branches> getAllBranches()   
		{  
		return branchesService.getAllBranches();  
		}  
		//creating a get mapping that retrieves the detail of a specific branch  
		@GetMapping("/branches/{branchid}")  
		private Branches getBranches(@PathVariable("branchid") int branchid)   
		{  
		return branchesService.getBranchById(branchid);  
		}  
		//creating a delete mapping that deletes a specified branch  
		@DeleteMapping("/branches/{branchid}")  
		private void deleteBranch(@PathVariable("branchid") int branchid)   
		{  
		branchesService.delete(branchid);  
		}  
		//creating post mapping that post the book detail in the database  
		@PostMapping("/branches")  
		private int saveBranch(@RequestBody Branches branches)   
		{  
		branchesService.saveOrUpdate(branches);  
		return branches.getId();  
		}  
		//creating put mapping that updates the book detail   
		@PutMapping("/branches/{branchid}")  
		private Branches update(@RequestBody Branches branches)   
		{  
		branchesService.saveOrUpdate(branches);  
		return branches;  
		}  

}
