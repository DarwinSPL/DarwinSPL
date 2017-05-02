package dw.darwinspl.feature.graphical.editor.template;

public class DwFeatureModelOverviewChangeDataObject {
	private String type;
	private String name;
//	private String oldValue;
//	private String newValue;
	private String action;
	
	public DwFeatureModelOverviewChangeDataObject(String type, String name, String action) {
		this.type = type;
		this.name = name;
//		this.oldValue = oldValue;
//		this.newValue = newValue;
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

//	public String getOldValue() {
//		return oldValue;
//	}
//
//	public String getNewValue() {
//		return newValue;
//	}
	
	public String getAction() {
		return action;
	}
}
