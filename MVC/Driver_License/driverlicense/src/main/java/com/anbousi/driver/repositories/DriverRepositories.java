package com.anbousi.driver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.driver.models.License;
import com.anbousi.driver.models.Person;

@Repository
public interface DriverRepositories extends CrudRepository<Person, Long> {
	
	List<Person> findAll();
	List<Person> findByLicenseIsNull();

}
