package com.anbousi.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.dojoninjas.models.Dojo;

@Repository
public interface DojoRepositories extends CrudRepository<Dojo, Long> {
List<Dojo> findAll();
Dojo save(Dojo dojo);
List<Dojo> findByNinjasIsNotNull();
}
