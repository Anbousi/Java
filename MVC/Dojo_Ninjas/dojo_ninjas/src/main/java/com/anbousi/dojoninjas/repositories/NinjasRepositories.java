package com.anbousi.dojoninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.dojoninjas.models.Dojo;
import com.anbousi.dojoninjas.models.Ninja;

@Repository
public interface NinjasRepositories extends CrudRepository<Ninja, Long> {
List<Ninja> findAll();
Ninja save(Ninja ninja);
}
