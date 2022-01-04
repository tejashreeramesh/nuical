/**
 * 
 */
package com.nous.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nous.app.dao.CalendarDAO;
import com.nous.app.services.dto.HolidayBean;

/**
 * @author mohanavelp
 *
 */
@Service
public class CalendarService {

	@Autowired
	CalendarDAO calendarDAO;
	
	public List<HolidayBean> fetchHolidays() {
		List<HolidayBean> holidays = calendarDAO.fetchHolidays();
		return holidays;
	}
	
}
