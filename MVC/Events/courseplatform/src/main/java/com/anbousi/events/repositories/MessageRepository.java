package com.anbousi.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.events.models.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
