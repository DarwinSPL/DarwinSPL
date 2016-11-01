package eu.hyvar.feature.graphical.base.util;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyEvolutionUtil;

public class HyEnumEditorUtil {
	public static int getEnumHeight(HyEnum enumeration, Date date){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		if(HyEvolutionUtil.isValid(enumeration, date)){
			int childrenCount = HyEvolutionUtil.getValidTemporalElements(enumeration.getLiterals(), date).size();

			return (childrenCount+1)*theme.getFeatureNameAreaHeight();
		}else{
			return 0;
		}
	}
}
