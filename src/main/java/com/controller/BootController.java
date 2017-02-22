package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.MaxSatisfactionCalculator;

/**
 * RestController class responsible for exposing MicroService web api
 */
@RestController
@RequestMapping(value = "/optimaleat")
public class BootController {

	/**
	 * Method to check if micro service is up and running.
	 * 
	 * @return HttpStatus
	 */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public HttpStatus checkStatus() {
		return HttpStatus.OK;
	}

	/**
	 * Method to find path between 2 nodes
	 * 
	 * @param start_end
	 * @return
	 */
	@RequestMapping(value = "/satisfy", method = RequestMethod.POST)
	public String findPath(@RequestBody String input) {
		// System.out.println(input);
		return "" + MaxSatisfactionCalculator.calculatorMain(input);
	}
}
