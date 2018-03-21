package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	
	private String country;
	
	private Map<String, String> favouriteLanguageOptions;
	
	private String favouriteLanguage;
	
	//private LinkedHashMap<String, String> countryOptions;
	
	public Student() {
		// populate country options: used ISO country code
		//countryOptions = new LinkedHashMap<>();
		
		//countryOptions.put("BR", "Brazil");
		//countryOptions.put("FR", "France");
		//countryOptions.put("DE", "Germany");
		//countryOptions.put("IN", "India");
		//countryOptions.put("US", "United States of America");
		
		//populate favourite language options
		favouriteLanguageOptions = new LinkedHashMap<>();
		
		favouriteLanguageOptions.put("Java", "Java");
		favouriteLanguageOptions.put("C#", "C#");
		favouriteLanguageOptions.put("PHP", "PHP");
		favouriteLanguageOptions.put("Ruby", "Ruby");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getFavouriteLanguageOptions() {
		return favouriteLanguageOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}
	
	

	
	

	//public LinkedHashMap<String, String> getCountryOptions() {
	//	return countryOptions;
	//}
	
	

}
