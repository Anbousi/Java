package com.anbousi.driver.services;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

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
		try {
		List<License> licenses = licenseRepositories.findByOrderByIdDesc();
		License l1 = licenses.get(0);
		String count2 = l1.getNumber();
		int count1  = Integer.parseInt(count2);
    	count1++;
//    	System.out.println(count1);
    	License.setCount(count1);
		
    	License.setCount(count1);
		DecimalFormat nf = new DecimalFormat("00000000");
//		System.out.println(License.getCount()+ "Database");
		license.setNumber(nf.format(License.getCount()));
		return this.licenseRepositories.save(license);
		}
		catch(Exception e){
			license.setNumber("00000001");
			return this.licenseRepositories.save(license);
		}
		
	}
	
 // find all persons with license
	public List<Person> allPersonsWithNoLicenses() {
		return driverRepositories.findByLicenseIsNull();
	}
	
// find person by id
public Person findPerson(Long id) {
    Optional<Person> optionalPerson = driverRepositories.findById(id);
    if(optionalPerson.isPresent()) {
        return optionalPerson.get();
    } else {
        return null;
    }
}

public List<Person> findAllPersons() {
	List<Person> persons = driverRepositories.findAll();
	return persons;
}
	
}
