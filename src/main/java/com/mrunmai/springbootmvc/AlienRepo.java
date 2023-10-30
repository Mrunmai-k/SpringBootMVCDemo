package com.mrunmai.springbootmvc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrunmai.springbootmvc.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
}
