package com.anbousi.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anbousi.languages.models.Language;
import com.anbousi.languages.repositories.LangRepositories;


@Service
public class LangServices {

	private final LangRepositories langRepo;

	public LangServices(LangRepositories langRepo) {
		this.langRepo = langRepo;
	}

	// returns all the languages
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}

    // creates a Language
    public Language createLanguage(Language lang) {
        return langRepo.save(lang);
    }
    
    
    // update a Language
    public Language updateLanguage(Long id , String name , String creator, double version) {
    	Language lang = findLanguageById(id);
    	lang.setName(name);
    	lang.setCreator(creator);
    	lang.setVersion(version);
        return langRepo.save(lang);
    }
    
    // delete a Language
    public void deleteLanguage(Long id) {
        langRepo.deleteById(id);
    }
    
    // find a Language
    public Language findLanguageById(Long id) {
    	Optional<Language> optionalLang = langRepo.findById(id);
    	if(optionalLang.isPresent()) {
    		return optionalLang.get();
    	} else {
    		return null;
    	}
    }
}   
    
