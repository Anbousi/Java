package com.anbousi.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.languages.models.Language;
@Repository
public interface LangRepositories extends CrudRepository<Language, Long> {

	List<Language> findAll();
			
		
	}



