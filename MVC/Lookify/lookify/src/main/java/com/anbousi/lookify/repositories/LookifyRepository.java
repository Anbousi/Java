package com.anbousi.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anbousi.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtistLike(String artist);
	List<Lookify> findByArtistContaining(String artist);
	List<Lookify> findByOrderByRateDesc();
	
}
