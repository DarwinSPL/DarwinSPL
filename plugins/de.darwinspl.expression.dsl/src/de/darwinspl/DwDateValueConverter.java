package de.darwinspl;

import java.util.Date;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.nodemodel.INode;

public class DwDateValueConverter extends AbstractDeclarativeValueConverterService {
	
	@ValueConverter(rule = "Validity")
	 public IValueConverter<Date> Validity() {
		return new AbstractNullSafeConverter<Date>() {

			@Override
			protected String internalToString(Date value) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected Date internalToValue(String string, INode node) throws ValueConverterException {
				// TODO Auto-generated method stub
				return null;
			}
			
		};
	}
	
}
