package com.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.Service.CountryService;
import com.springrest.Model.Country;

@RestController
public class Controller {

	@Autowired
	private CountryService service;
	
	@RequestMapping(value="/countries")
	public List<Country> getAllCountries() {
		return service.getCountries();
	}
	
	@RequestMapping(value="/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		return service.getCountry(code);
	}
	@RequestMapping(method=RequestMethod.POST,value="/countries")
	public void addCountry(@RequestBody Country country)
	{
		service.addCountry(country);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/countries/{code}")
	public void updateCountry(@RequestBody Country country, @PathVariable String code)
	{
		service.updateCountry(code,country);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/countries/{code}")
	public void deleteCountry(@PathVariable String code)
	{
		 service.deleteCountry(code);
	}
	
}
