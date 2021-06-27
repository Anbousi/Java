package com.anbousi.queriesjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.queriesjoins.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	@Query(value="SELECT SELECT countries.name, languages.language, languages.percentage\r\n"
			+ "From countries\r\n"
			+ "JOIN languages\r\n"
			+ "ON countries.id = languages.country_id\r\n"
			+ "WHERE  languages.language = \"Slovene\"\r\n"
			+ "order by percentage DESC;", nativeQuery=true)
			List<Object[]> findAllSpeakSlovene();
			
	@Query(value="SELECT  countries.name, languages.language, languages.percentage\r\n"
			+ "FROM countries\r\n"
			+ "JOIN languages\r\n"
			+ "ON countries.id = languages.country_id\r\n"
			+ "GROUP BY languages.country_code\r\n"
			+ "order by languages.percentage DESC\r\n" , nativeQuery=true)
			List<Object[]> languagesGreater89();
}
