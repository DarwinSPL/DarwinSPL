package eu.hyvar.evolution.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HyEvolutionResolverUtil {

	private static final String NULL_VALUE_STRING = "eternity";
	
	public static Date resolveDate(String dateString) {
		if(dateString == null || dateString.equals("")) {
			return null;
		}
		
		String[] splits = dateString.split(":");
		
		DateFormat formater = null;
		
		switch(splits.length) {
		case 1:
			formater = new SimpleDateFormat("yyyy/MM/dd");
			break;
		case 2:
			formater = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm");
			break;
		case 3:
			formater = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
			break;
		default:
			formater = new SimpleDateFormat("yyyy/MM/dd");
			break;
		}
		
		try {
			return formater.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String deresolveDate(Date date) {
		if(date != null) {
			DateFormat formater = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");
			return formater.format(date);
		}
		else {
			return NULL_VALUE_STRING;
		}
	}
}
