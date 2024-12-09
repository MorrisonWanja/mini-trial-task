package com.backend.developertrialtask.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.developertrialtask.model.Branches;
import com.backend.developertrialtask.repository.BranchesRepository;

@Service
public class BranchesService {
	
	@Autowired
	private BranchesRepository branchesRepository;  
	//getting all branches records by using the method findaAll() of CrudRepository  
	public List<Branches> getAllBranches()   
	{  
	List<Branches> branches = new ArrayList<Branches>();  
	branchesRepository.findAll().forEach(branch -> branches.add(branch));  
	return branches;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public Branches getBranchById(int id)   
	{  
	return branchesRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Branches branches)   
	{  
	branchesRepository.save(branches);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
	branchesRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(Branches branches, int branchid)   
	{  
	branchesRepository.save(branches);  
	} 
	

}
