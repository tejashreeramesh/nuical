/**
 * 
 */
package com.nous.app.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nous.app.config.PropertiesConfig;
import com.nous.app.services.CalendarService;
import com.nous.app.services.dto.HolidayBean;

/**
 * @author mohanavelp
 *
 */
@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PropertiesConfig config;
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value = "/wish/{name}", method = RequestMethod.GET)
	public String wishMyName(@PathVariable("name") String name) {
		System.out.println("Secondary properties file from config: " + config.getSecondaryFilePath());
		LOGGER.debug("Logged in with " + name);
		return "All the best " + name;
	}

	@RequestMapping(value = "/admin/{name}", method = RequestMethod.GET)
	@RolesAllowed("ADMIN")
	public String wishAdmmin(@PathVariable("name") String name) {
		LOGGER.debug("Logged in with " + name);
		return "Hello Admin " + name;
	}
	
	@RequestMapping(value = "/restricted", method = RequestMethod.GET)
	public String restrictedContent() {
		return "Only users with view authority is permitted.";
	}
	
	@RequestMapping(value = "/allHolidays", method = RequestMethod.GET)
	@RolesAllowed("USER")
	public List<HolidayBean> fetchAllHolidays() {
		return calendarService.fetchHolidays();
	}
}
