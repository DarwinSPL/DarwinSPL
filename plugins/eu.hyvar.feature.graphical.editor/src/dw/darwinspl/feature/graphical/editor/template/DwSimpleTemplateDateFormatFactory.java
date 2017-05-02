package dw.darwinspl.feature.graphical.editor.template;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import freemarker.core.Environment;
import freemarker.core.TemplateDateFormat;
import freemarker.core.TemplateDateFormatFactory;
import freemarker.core.TemplateFormatUtil;
import freemarker.core.TemplateValueFormatException;
import freemarker.core.UnformattableValueException;
import freemarker.core.UnparsableValueException;
import freemarker.template.TemplateDateModel;
import freemarker.template.TemplateModelException;

public class DwSimpleTemplateDateFormatFactory extends TemplateDateFormatFactory {
	public static final DwSimpleTemplateDateFormatFactory INSTANCE
	= new DwSimpleTemplateDateFormatFactory();

	private DwSimpleTemplateDateFormatFactory() {
		// Defined to decrease visibility
	}

	@Override
	public TemplateDateFormat get(String arg0, int arg1, Locale arg2, TimeZone arg3, boolean arg4, Environment arg5)
			throws TemplateValueFormatException {
	        return HySimpleTemplateDateFormat.INSTANCE;
	}

    private static class HySimpleTemplateDateFormat extends TemplateDateFormat {

        private static final HySimpleTemplateDateFormat INSTANCE
                = new HySimpleTemplateDateFormat();

        private HySimpleTemplateDateFormat() { }

        @Override
        public String formatToPlainText(TemplateDateModel dateModel)
                throws UnformattableValueException, TemplateModelException {
        	Date date = TemplateFormatUtil.getNonNullDate(dateModel);
        	
        	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
            return DATE_FORMAT.format(date);
        }

        @Override
        public boolean isLocaleBound() {
            return false;
        }

        @Override
        public boolean isTimeZoneBound() {
            return false;
        }

        @Override
        public Date parse(String s, int dateType) throws UnparsableValueException {
            try {
                return new Date(Long.parseLong(s));
            } catch (NumberFormatException e) {
                throw new UnparsableValueException("Malformed long");
            }
        }

        @Override
        public String getDescription() {
            return "simple date";
        }

    }

}
