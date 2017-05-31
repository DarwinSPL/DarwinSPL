package de.darwinspl.feature.graphical.editor.commands.attribute;

import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeDeleteCommand extends Command{
	private class AttributeTemporalDeleteNotification extends NotificationImpl{

		public AttributeTemporalDeleteNotification(int eventType, Object oldValue, Object newValue) {
			super(eventType, oldValue, newValue);
		}

	
	}
	private DwGraphicalFeatureModelViewer editor;
	private HyFeatureAttribute attribute;
	


	public HyFeatureAttribute getAttribute() {
		return attribute;
	}

	public void setAttribute(HyFeatureAttribute attribute) {
		this.attribute = attribute;
	}
		
	public DwAttributeDeleteCommand(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}

	
	@Override
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		attribute.setValidUntil(date);
		
		// delete attribute permanently in case that valid since and valid until 
		// would be equal
		if(date.equals(attribute.getValidSince())){
			attribute.getFeature().getAttributes().remove(attribute);
		}
			
		//for(Adapter adapter : attribute.getFeature().eAdapters())
		//	adapter.notifyChanged(new AttributeTemporalDeleteNotification(0, date, date));
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
