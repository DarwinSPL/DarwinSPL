package eu.hyvar.feature.graphical.base.util;

import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;

public class HyEnumEditorUtil {
	public static int getPreviousEnumsHeight(HyFeatureModel featureModel, HyEnum enumeration, Date date){
		int index = featureModel.getEnums().indexOf(enumeration);
		
		int height = 0;
		for(int i = 0; i < index; i++){
			height += getEnumHeight(featureModel.getEnums().get(index), date);
		}
				
		return height;
	}
	
	public static int getEnumHeight(HyEnum enumeration, Date date){
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();

		if(HyEvolutionUtil.isValid(enumeration, date)){
			int childrenCount = HyEvolutionUtil.getValidTemporalElements(enumeration.getLiterals(), date).size();

			return (childrenCount+1)*theme.getFeatureNameAreaHeight() + (int)Math.floor(theme.getLineWidth() * 1.5)+80;
		}else{
			return 0;
		}
	}
}
