package com.anbousi.driver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.driver.models.License;

@Repository
public interface LicenseRepositories extends CrudRepository<License, Long> {
	List<License> findAll();
}
