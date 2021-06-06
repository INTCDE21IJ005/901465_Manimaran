package com.cognizant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

@Service
public class MenuItemService {
	@Autowired
	MenuItemRepository repository;
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return repository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		 return repository.findByActiveTrueAndDateOfLaunchBefore(new Date());
	}

	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		Optional<MenuItem> m = repository.findById(menuItemId);
		if(m.isPresent())
			return m.get();
		return null;
	}
	@Transactional
	public String modifyMenuItem(MenuItem menuItem) {
		Optional<MenuItem> m = repository.findById(menuItem.getId());
		if(m.isPresent()) {
			repository.save(menuItem);
			return "SuccessFully Updated";
		}
		return "MenuItem not present.";
	}
	

	public boolean validate(String token) {
		 final String uri = "http://localhost:8081/auth/validate";
		 
		    //TODO: Autowire the RestTemplate in all the examples
		    RestTemplate restTemplate = new RestTemplate();
		 
		    //boolean result = restTemplate.getForObject(uri, boolean.class);
		    HttpHeaders headers = new HttpHeaders();
		    headers.set("Authorization",token);
		 
		    HttpEntity<String> entity = new HttpEntity<String>(headers);
		     
		    ResponseEntity<Boolean> result= restTemplate.exchange(uri, HttpMethod.GET, entity, boolean.class);
		     
		    
			return result.getBody();
	}
}