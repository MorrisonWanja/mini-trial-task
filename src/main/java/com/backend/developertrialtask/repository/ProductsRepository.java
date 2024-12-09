package com.backend.developertrialtask.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.developertrialtask.model.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer> {

}
