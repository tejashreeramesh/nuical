/**
 * 
 */
package com.nous.app.services;

import java.util.List;

import com.nous.app.model.Calendar;


public interface CalendarService {

	public List<Calendar> getHolidays();

	public String saveHoliday(Calendar calendar);
	
	public String updateHoliday(Calendar calendar);

	public List<Calendar> findByName(String name);

	public String deleteHoliday(String name);

	public boolean isHolidayExists(String name);

	public List<Calendar> getByName(String name);

}
