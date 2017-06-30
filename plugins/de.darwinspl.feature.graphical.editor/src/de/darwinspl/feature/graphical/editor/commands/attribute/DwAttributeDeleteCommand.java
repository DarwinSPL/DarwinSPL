package de.darwinspl.feature.graphical.editor.commands.attribute;

import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeDeleteCommand extends Command{
	private class AttributeTemporalDeleteNotification extends NotificationImpl{

		public AttributeTemporalDeleteNotification(int eventType, Object oldValue, Object newValue) {
			super(eventType, oldValue, newValue);
		}
	}
	
	
	private DwGraphicalFeatureModelViewer editor;
	private HyFeatureAttribute attribute;
	private HyFeatureAttribute oldAttribute;
	private Date changeDate;


	public HyFeatureAttribute getAttribute() {
		return attribute;
	}

	public void setAttribute(HyFeatureAttribute attribute) {
		this.attribute = attribute;
	}
		
	public DwAttributeDeleteCommand(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}

	/**
	 * Undo renaming the feature.
	 */
	@Override
	public void undo() {
		if(changeDate.equals(attribute.getValidSince()) || changeDate.equals(new Date(Long.MIN_VALUE))){
			for(HyFeature feature : editor.getModelWrapped().getModel().getFeatures()){
				if(feature.getId().equals(oldAttribute.getFeature().getId())){
					oldAttribute.setFeature(feature);
					feature.getAttributes().add(oldAttribute);
					
					attribute = oldAttribute;
				}
			}
		}else{
			attribute.setValidUntil(oldAttribute.getValidUntil());				
		}
	}

	@Override
	public void redo() {
		Date date = editor.getCurrentSelectedDate();
		changeDate = date;

		oldAttribute = DwEcoreUtil.copy(attribute);
		
		// delete attribute permanently in case that valid since and valid until 
		// would be equal or date is equal to min date
		if(date.equals(attribute.getValidSince()) || date.equals(new Date(Long.MIN_VALUE))){
			attribute.getFeature().getAttributes().remove(attribute);
		}else{
			attribute.setValidUntil(date);
			for(Adapter adapter : attribute.getFeature().eAdapters())
				adapter.notifyChanged(new AttributeTemporalDeleteNotification(0, date, date));					
		}
	
		//for(Adapter adapter : attribute.getFeature().eAdapters())
		//	adapter.notifyChanged(new AttributeTemporalDeleteNotification(0, date, date));
		
		editor.getModelWrapped().rearrangeFeatures();
		//editor.refreshView();
	}
	
	@Override
	public void execute(){
		redo();
	}
}
