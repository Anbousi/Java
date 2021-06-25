package com.anbousi.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anbousi.dojoninjas.models.Dojo;
import com.anbousi.dojoninjas.models.Ninja;
import com.anbousi.dojoninjas.repositories.DojoRepositories;
import com.anbousi.dojoninjas.repositories.NinjasRepositories;

@Service
public class DojoNinjasServices {
private final DojoRepositories dojoRepositories;
private final NinjasRepositories ninjasRepositories;

public DojoNinjasServices(DojoRepositories dojoRepositories, NinjasRepositories ninjasRepositories) {
	this.dojoRepositories = dojoRepositories;
	this.ninjasRepositories = ninjasRepositories;
}

public List<Dojo> findAllDojos(){
	List<Dojo> dojos = dojoRepositories.findAll();
	return dojos;
}

public Dojo createDojo(Dojo dojo){
	return dojoRepositories.save(dojo);
}

public void deleteDojoById(Long id) {
	dojoRepositories.deleteById(id);
	
}

public List<Dojo> findAllDojosNinjas() {
	List<Dojo> dojos = dojoRepositories.findByNinjasIsNotNull();
	return dojos;
}

public Dojo findDojoById(Long id) {
	Optional<Dojo> optionalDojo = dojoRepositories.findById(id);
    if(optionalDojo.isPresent()) {
        return optionalDojo.get();
    } else {
        return null;
    }
}

//--------------------------------------------------------------------

public List<Ninja> findAllNinjas(){
	List<Ninja> ninjas = ninjasRepositories.findAll();
	return ninjas;
}

public Ninja createNinja(Ninja ninja){
	return ninjasRepositories.save(ninja);
}

public void deleteNinjaById(Long id) {
	ninjasRepositories.deleteById(id);
	
}





}
