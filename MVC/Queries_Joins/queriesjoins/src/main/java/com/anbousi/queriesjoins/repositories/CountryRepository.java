package com.anbousi.queriesjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.queriesjoins.models.Countery;

@Repository
public interface CountryRepository extends CrudRepository<Countery, Long> {
	
	List<Countery> findAll();
	
	@Query(value="SELECT countries.name , countries.surface_area , countries.population\r\n"
			+ "From countries\r\n"
			+ "WHERE surface_area < 501 && population > 100000;", nativeQuery=true)
			List<Object[]> surfaceBelow501();
			
	@Query(value="SELECT countries.name , countries.government_form , countries.capital,life_expectancy\r\n"
			+ "From countries\r\n"
			+ "WHERE government_form ='Constitutional Monarchy' && capital > 200 && life_expectancy > 75;", nativeQuery=true)
			List<Object[]> surfaceGreater200();
			
	@Query(value="SELECT countries.name as 'Country_name' , cities.name as 'City_name' , cities.district , cities.population\r\n"
			+ "From countries\r\n"
			+ "JOIN cities ON countries.id =cities.countries_id\r\n"
			+ "WHERE cities.district =\"Buenos Aires\" and cities.population > 500000 ;", nativeQuery=true)
			List<Object> Argentina();
			
	@Query(value="SELECT countries.region , COUNT(countries.region) AS countries\r\n"
			+ "FROM countries\r\n"
			+ "GROUP BY countries.region\r\n"
			+ "ORDER BY COUNT(countries.region) DESC;", nativeQuery=true)
			List<Object[]> numOfCountries();
			
			
			
			
			
			
}
