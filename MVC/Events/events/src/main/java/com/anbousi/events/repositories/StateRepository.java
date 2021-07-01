package com.anbousi.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.events.models.State;


@Repository
public interface StateRepository extends CrudRepository<State, Long> {
	
	List <State> findAll();

}
