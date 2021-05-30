package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;
	
	
	@GetMapping("/")
	public List<MenuItem> getAllMenuItems(@RequestHeader(name = "Authorization") String token){
		
		if (menuItemService.validate(token)) {
			return menuItemService.getMenuItemListCustomer();
		} else {
			new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
			return null;
		}
	}
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@RequestHeader(name = "Authorization") String token,@PathVariable long id){
		if (menuItemService.validate(token)) {
			return menuItemService.getMenuItem(id);
		} else {
			new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
		}
		return null;
	}
	@PutMapping()
	public String modifyMenuItem(@RequestHeader(name = "Authorization") String token,@RequestBody MenuItem menuItem) {
		if (menuItemService.validate(token)) {
			return menuItemService.modifyMenuItem(menuItem);
		} else {
			new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
			
		}
		return null;
	}
}
