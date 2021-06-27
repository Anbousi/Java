package com.anbousi.queriesjoins.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.anbousi.queriesjoins.models.City;
import com.anbousi.queriesjoins.models.Countery;
import com.anbousi.queriesjoins.models.Language;
import com.anbousi.queriesjoins.services.ApiServices;

@RestController
public class ApiControllers {


		private ApiServices apiService;
		
		public ApiControllers(ApiServices apiService) {
			this.apiService = apiService;
		}

		@GetMapping("/")
		public List<Countery> index() {
			return apiService.getCountries();
		}
		
		@GetMapping("/slovene")
		public List<Object[]> countryByLanguage() {
			return apiService.getCountrySpeakSolvane();
		}
		
		
		@GetMapping("/cityCount")
		public List<Object[]> countryByCityCount() {
			return this.apiService.getAllCitiesForEachCountry();
		}
		
		@GetMapping("/mexico")
		public List<Object[]> mexicoCities() {
			return apiService.getMaxicoPopGreaterThan500();
		}
		
		@GetMapping("/languagues")
		public List<Object[]> countryLanguagues() {
			return apiService.getLanuagesCountry89();
		}
		
		@GetMapping("/argentina")
		public List<Object> ArgentinaCities() {
			return apiService.getArgentinaPopGreater500();
		}
		
		@GetMapping("/surface_below")
		public List<Object[]> serfaceAreaBelow501() {
			return apiService.getCountriesAreaBelow501();
		}
		
		@GetMapping("/surface_greater")
		public List<Object[]> serfaceAreagreater200() {
			return apiService.getCountriesSurfaceMore200();
		}
		
		@GetMapping("/population")
		public List<Object> pop500() {
			return apiService.getArgentinaPopGreater500();
		}
		

	}
