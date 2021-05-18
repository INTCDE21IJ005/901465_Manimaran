package com.cognizant.springlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.exception.CountryNotFoundException;
@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	@Autowired
	CountryService countryService;
	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");

		LOGGER.info("END");
		return context.getBean("in",Country.class);
	}
	
	ApplicationContext context1 = new ClassPathXmlApplicationContext("country.xml");
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		LOGGER.info("START");

		LOGGER.info("END");
		return (List<Country>)context1.getBean("countryList");
	}
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return countryService.getCountry(code);
	}
}
