package eu.hyvar.feature.graphical.editor.template.svg;

import java.util.Locale;

import freemarker.core.Environment;
import freemarker.core.InvalidFormatParametersException;
import freemarker.core.TemplateFormatUtil;
import freemarker.core.TemplateNumberFormat;
import freemarker.core.TemplateNumberFormatFactory;
import freemarker.core.UnformattableValueException;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.utility.NumberUtil;

public class DwHexTemplateNumberFormatFactory extends TemplateNumberFormatFactory{

    public static final DwHexTemplateNumberFormatFactory INSTANCE
            = new DwHexTemplateNumberFormatFactory();

    private DwHexTemplateNumberFormatFactory() {
        // Defined to decrease visibility
    }

    @Override
    public TemplateNumberFormat get(String params, Locale locale, Environment env)
            throws InvalidFormatParametersException {
        TemplateFormatUtil.checkHasNoParameters(params);
        return HexTemplateNumberFormat.INSTANCE;
    }

    private static class HexTemplateNumberFormat extends TemplateNumberFormat {

        private static final HexTemplateNumberFormat INSTANCE = new HexTemplateNumberFormat();

        private HexTemplateNumberFormat() { }

        @Override
        public String formatToPlainText(TemplateNumberModel numberModel)
                throws UnformattableValueException, TemplateModelException {
            Number n = TemplateFormatUtil.getNonNullNumber(numberModel);
            try {
                String number = Integer.toHexString(NumberUtil.toIntExact(n));
                if(number.length() == 1)
                	if(NumberUtil.toIntExact(n) <= 9)
                		number = "0"+number;
                	else
                		number = number + number;
                
                System.out.println(number + "   "+NumberUtil.toIntExact(n));
                return number;
            } catch (ArithmeticException e) {
                throw new UnformattableValueException(n + " doesn't fit into an int");
            }
        }

        @Override
        public boolean isLocaleBound() {
            return false;
        }

        @Override
        public String getDescription() {
            return "hexadecimal int";
        }

    }
}
