package com.backend.developertrialtask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.developertrialtask.model.Business;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Integer> {

}
