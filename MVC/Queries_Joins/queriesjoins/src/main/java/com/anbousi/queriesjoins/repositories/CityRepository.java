package com.anbousi.queriesjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.queriesjoins.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	@Query(value="SELECT countries.name AS country, COUNT(cities.id) AS number_cities\r\n"
			+ "FROM countries\r\n"
			+ "JOIN cities ON countries.code = cities.country_code\r\n"
			+ "GROUP BY countries.code\r\n"
			+ "ORDER BY COUNT(cities.id) DESC", nativeQuery=true)
			List<Object[]> findAllCitiesForCountry();


	@Query(value="SELECT cities.name, population, country_id\r\n"
			+ "FROM cities\r\n"
			+ "where country_id=136 && population>500000\r\n"
			+ "order by population DESC;", nativeQuery=true)
			List<Object[]> maxicoGreater5();
			
}


