package com.anbousi.lookify.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.anbousi.lookify.models.Lookify;
import com.anbousi.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;

	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
//	Create a Song
	public Lookify createLookify(Lookify lookify) {
		return lookifyRepository.save(lookify);
	}

//	Find All Songs
	public List<Lookify> allLookifies() {
		return lookifyRepository.findAll();
	}

	
	// find a Song
    public Lookify findLookifyById(Long id) {
    	Lookify optionalLookify = lookifyRepository.findById(id).orElse(null);

    		return optionalLookify;
    }

//    Delete a Song
	public void deleteLookifyById(Long id) {
		this.lookifyRepository.deleteById(id);
	}
	

	
//  Search a Song by Artist name
	public List<Lookify> searchSongByArtist(String artist) {
		
		return this.lookifyRepository.findByArtistContaining(artist);
	}
	
	
	
//	Top 10 Songs by Rating
public List<Lookify> topTenByRate() {
	return this.lookifyRepository.findByOrderByRateDesc();
}
	
	
}
