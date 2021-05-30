package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Authorization Service FeignClient and for Connect with it
 */

@FeignClient(name = "authorization-service", url = "http://localhost:8081")
public interface AuthorisationClient {

	/**
	 * validate method of Authorization Service
	 * @param token
	 * @return
	 */
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
}