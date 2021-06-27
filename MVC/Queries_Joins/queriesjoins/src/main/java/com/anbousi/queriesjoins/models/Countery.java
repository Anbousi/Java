package com.anbousi.queriesjoins.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="countries")
public class Countery {
	@Id
	private Long id;
	@NotNull
	private String code;
	@NotNull
	private String name;
	@NotNull
	private String continent;
	@NotNull
	private String region;
	@NotNull
	private Float surfaceArea;
	@NotNull
	private Short indepYear;
	@NotNull
	private Integer population;
	@NotNull
	private Float lifeExpectancy;
	@NotNull
	private Float gnp;
	@NotNull
	private Float gnpOld;
	@NotNull
	private String localName;
	@NotNull
	private String governmentForm;
	@NotNull
	private String headOfState;
	@NotNull
	private Integer capital;
	@NotNull
	private String code2;
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Language> languages;
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<City> cities;
	public Countery() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Float getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(Float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public Short getIndepYear() {
		return indepYear;
	}
	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Float getLifeExpectancy() {
		return lifeExpectancy;
	}
	public void setLifeExpectancy(Float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	public Float getGnp() {
		return gnp;
	}
	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}
	public Float getGnpOld() {
		return gnpOld;
	}
	public void setGnpOld(Float gnpOld) {
		this.gnpOld = gnpOld;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGovernmentForm() {
		return governmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
}
