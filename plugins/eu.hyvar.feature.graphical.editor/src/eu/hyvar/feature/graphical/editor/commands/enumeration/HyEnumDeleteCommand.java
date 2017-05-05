package eu.hyvar.feature.graphical.editor.commands.enumeration;

import java.util.Date;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyEnumDeleteCommand extends Command{
	private class EnumTemporalDeleteNotification extends NotificationImpl{

		public EnumTemporalDeleteNotification(int eventType, Object oldValue, Object newValue) {
			super(eventType, oldValue, newValue);
		}

	
	}
	private DwGraphicalFeatureModelViewer editor;
	private HyEnum enumeration;
	
	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}

	public void setEditor(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}

	public HyEnum getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(HyEnum enumeration) {
		this.enumeration = enumeration;
	}
		
	public HyEnumDeleteCommand(DwGraphicalFeatureModelViewer editor) {
		this.editor = editor;
	}

	
	@Override
	public void execute(){
		Date date = editor.getCurrentSelectedDate();
		enumeration.setValidUntil(date);
		
		for(Adapter adapter : enumeration.eAdapters())
			adapter.notifyChanged(new EnumTemporalDeleteNotification(0, date, date));
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
