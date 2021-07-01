package com.anbousi.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.events.models.UserEvent;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long> {
	
	UserEvent findByEventId(Long id);

}
