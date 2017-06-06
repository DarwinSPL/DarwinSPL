package de.darwinspl.feature.stage.editor.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.palette.PaletteRoot;

import de.darwinspl.feature.stage.base.editor.SmFeatureModelViewer;

public class SmStageModelEditor extends SmFeatureModelViewer {
	
	public SmStageModelEditor() {
	    setEditDomain(new DefaultEditDomain(this));
	  }
	   
	  @Override
	  protected PaletteRoot getPaletteRoot() {
	    // TODO Auto-generated method stub
	    return null;
	  }
	 
	  @Override
	  public void doSave(IProgressMonitor monitor) {
	    // TODO Auto-generated method stub
	  }
	

}
