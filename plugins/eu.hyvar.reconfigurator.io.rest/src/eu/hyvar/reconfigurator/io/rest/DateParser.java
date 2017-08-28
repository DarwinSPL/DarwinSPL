package eu.hyvar.reconfigurator.io.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
	private static final SimpleDateFormat withoutSeconds = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm");
	private static final SimpleDateFormat withoutTime = new SimpleDateFormat("yyyy/MM/dd");
	
	public static Date getDate(String dateString) {
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {	
			try {
				return withoutSeconds.parse(dateString);
			}
			catch (ParseException e2) {	
				try {
					return withoutTime.parse(dateString);
				}
				catch (ParseException e3) {
					e.printStackTrace();
					e2.printStackTrace();
					e3.printStackTrace();
					return null;
				}
			}
		}
	}
	
}
