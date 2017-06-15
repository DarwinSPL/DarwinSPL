package eu.hyvar.reconfigurator.io.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
	
	public static Date getDate(String dateString) {
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {	
			e.printStackTrace();
			return null;
		}
	}
	
}
