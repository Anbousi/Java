package com.anbousi.queriesjoins.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anbousi.queriesjoins.models.Countery;
import com.anbousi.queriesjoins.repositories.CityRepository;
import com.anbousi.queriesjoins.repositories.CountryRepository;
import com.anbousi.queriesjoins.repositories.LanguageRepository;

@Service
public class ApiServices {

		private CountryRepository countryRepository;
		private CityRepository cityRepository;
		private LanguageRepository languageRepository;
		

	

		public ApiServices(CountryRepository countryRepository, CityRepository cityRepository,
				LanguageRepository languageRepository) {
			this.countryRepository = countryRepository;
			this.cityRepository = cityRepository;
			this.languageRepository = languageRepository;
		}

		public List<Object[]> getCountrySpeakSolvane() {
			return languageRepository.findAllSpeakSlovene();
		}
		
		public List<Object[]> getAllCitiesForEachCountry() {
			return cityRepository.findAllCitiesForCountry();
		}
		
		
		public List<Object[]> getMaxicoPopGreaterThan500() {
			return cityRepository.maxicoGreater5();
		}
		
		
		public List<Object[]> getLanuagesCountry89() {
			return languageRepository.languagesGreater89();
		}
		
		
		public List<Object[]> getCountriesAreaBelow501() {
			return this.countryRepository.surfaceBelow501();
		}
		
		
		public List<Object[]> getCountriesSurfaceMore200() {
			return this.countryRepository.surfaceGreater200();
		}
		
		public List<Object> getArgentinaPopGreater500() {
			return this.countryRepository.Argentina();
		}
		
		public List<Object[]> getNumCountriesRegions() {
			return this.countryRepository.numOfCountries();
		}

		public List<Countery> getCountries() {
			
			return countryRepository.findAll();
		}

		
		
}

