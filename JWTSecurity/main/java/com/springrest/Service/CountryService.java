package com.springrest.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.Model.Country;

@Service
public class CountryService {

	private List<Country> countries=new ArrayList<Country>();

	public CountryService() {
		System.out.println("service started");
		countries.add(new Country("in","India"));
		countries.add(new Country("au","Australia"));
		countries.add(new Country("uk","UnitedKingdom"));
		countries.add(new Country("us","USA"));
	}
	public List<Country> getCountries()
	{
		return countries;
	}

	public Country getCountry(String code)
	{
		return countries.stream().filter(t->t.getCode().equals(code)).findFirst().get();
	}

	public void addCountry(Country country) {
		countries.add(country);
		
	}

	public void updateCountry(String code,Country country) {
		// TODO Auto-generated method stub
		for(int i=0;i<countries.size();i++)
		{
			Country c=countries.get(i);
			if(c.getCode().contentEquals(code))
			{
				countries.set(i, country);
				return;
			}
		}
		
	}

	public void deleteCountry(String code) {
		countries.removeIf(t->t.getCode().equals(code));
		
	}

	
}
