package com.mrunmai.springbootmvc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrunmai.springbootmvc.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findByAname(String aname); // Query DSL(Domain Specific Language) means depending upon variables and
											// properties JPA will provide you the queries.
//	But method name should start with 'findBy' or 'getBy' after that there must be a variable/property name with first letter capital 

}
