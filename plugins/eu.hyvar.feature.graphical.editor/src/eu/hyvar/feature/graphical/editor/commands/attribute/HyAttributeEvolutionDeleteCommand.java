package eu.hyvar.feature.graphical.editor.commands.attribute;

import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeEvolutionDeleteCommand extends Command{
	private class AttributeTemporalDeleteNotification extends NotificationImpl{

		public AttributeTemporalDeleteNotification(int eventType, Object oldValue, Object newValue) {
			super(eventType, oldValue, newValue);
		}

	
	}
	private GraphicalEvolutionFeatureModelEditor editor;
	private HyFeatureAttribute attribute;
	
	public GraphicalEvolutionFeatureModelEditor getEditor() {
		return editor;
	}

	public void setEditor(GraphicalEvolutionFeatureModelEditor editor) {
		this.editor = editor;
	}

	public HyFeatureAttribute getAttribute() {
		return attribute;
	}

	public void setAttribute(HyFeatureAttribute attribute) {
		this.attribute = attribute;
	}
		
	public HyAttributeEvolutionDeleteCommand(GraphicalEvolutionFeatureModelEditor editor) {
		this.editor = editor;
	}

	
	@Override
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		attribute.setValidUntil(date);
		
		for(Adapter adapter : attribute.getFeature().eAdapters())
			adapter.notifyChanged(new AttributeTemporalDeleteNotification(0, date, date));
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
