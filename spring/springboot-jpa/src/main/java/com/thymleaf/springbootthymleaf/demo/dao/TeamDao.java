package com.thymleaf.springbootthymleaf.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thymleaf.springbootthymleaf.demo.domain.Team;

public interface TeamDao extends CrudRepository<Team, Long> {

	List<Team> findAll();
	
	Team findByName (String name);
}
