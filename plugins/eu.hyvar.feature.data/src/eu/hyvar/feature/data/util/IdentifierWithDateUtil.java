package eu.hyvar.feature.data.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdentifierWithDateUtil {
	
	public static final String DATE_SEPARATOR_TOKEN = "@";
	public static final String DATE_TIME_SEPARATOR_TOKEN = "T";
	public static final String TIME_SEPARATORS = ":";
	
	/**
	 * Splits an identifier String at the date separator token. Format: <IDENTIFIER>@<DATE> . Identifier should not contain Date separator string. No guarantees what happens if format not kept.  
	 * @param identifierWithDate
	 * @return First index of array is identifier without date. If date available, second index is date string
	 */
	public static String[] splitByDateToken(String identifierWithDate) {
		String[] splittedString;
		
		if(identifierWithDate.contains(DATE_SEPARATOR_TOKEN)) {
			splittedString = identifierWithDate.split(DATE_SEPARATOR_TOKEN);
		}
		else {
			splittedString = new String[1];
			splittedString[0] = identifierWithDate;
		}
		
		return splittedString;
	}
	
	/**
	 * Following schemas according to input: yyyy/MM/ddTHH:mm:ss , yyyy/MM/ddTHH:mm , yyyy/MM/dd
	 * @param dateString
	 * @return respective Date
	 */
	public static Date dateStringToDate(String dateString) {
		
		if(dateString == null) {
			return null;
		}
		
		Date date = null;
		
		
		SimpleDateFormat dateFormat;
		
		if(dateString.contains(DATE_TIME_SEPARATOR_TOKEN)) {
			// also with seconds
			if(dateString.split(TIME_SEPARATORS).length>2) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm:ss");				
			}
			else {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd'T'HH:mm");		
			}
		}
		else {
			dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		}
		
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Could not parse date at IdentifierWithDateUtil.dateStringToDate()");
			e.printStackTrace();
		}
		
		return date;
	}

	/**
	 * 
	 * @param identifierWithDate
	 * @return Date may be null if not specified
	 */
	public static Tuple<String, Date> getIdentifierAndDate(String identifierWithDate) {
		String plainIdentifier;
		Date date = null;
		
		if(identifierWithDate.contains(DATE_SEPARATOR_TOKEN)) {
			String[] split = splitByDateToken(identifierWithDate);
			plainIdentifier = split[0];
			String dateString = split[1];
			date = dateStringToDate(dateString);
		} 
		else {
			plainIdentifier = identifierWithDate;
		}
		
		Tuple<String, Date> identifierAndDate = new Tuple<String, Date>(plainIdentifier, date);
		return identifierAndDate;
	}
	
}
