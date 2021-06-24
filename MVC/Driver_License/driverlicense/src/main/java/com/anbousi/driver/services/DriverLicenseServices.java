package com.anbousi.driver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anbousi.driver.models.License;
import com.anbousi.driver.models.Person;

import com.anbousi.driver.repositories.DriverRepositories;
import com.anbousi.driver.repositories.LicenseRepositories;


@Service
public class DriverLicenseServices {
	
	private final DriverRepositories driverRepositories;
	private final LicenseRepositories licenseRepositories;


	
	public DriverLicenseServices(DriverRepositories driverRepositories, LicenseRepositories licenseRepositories) {
		this.driverRepositories = driverRepositories;
		this.licenseRepositories = licenseRepositories;
	}

	// creates a person
    public Person createPerson(Person p) {
        return this.driverRepositories.save(p);
    }
    
    // returns all the persons
    public List<Person> allPersons() {
        return this.driverRepositories.findAll();
    }

 // creates a license
	public License createLicense(License license) {
		return this.licenseRepositories.save(license);
	}
	
 // find all persons with license
	public List<Person> allPersonsWithNoLicenses() {
		return driverRepositories.findByLicenseIsNull();
	}
	
}
