package eu.hyvar.feature.graphical.editor.actions;

import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.gef.Request;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.template.HyFeatureModelOverviewGenerator;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class HyFeatureModelCreateOverviewAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";
	public static final String REQ_FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";
	
	protected Request request;
	
	
	public HyFeatureModelCreateOverviewAction() {
		super(FEATUREMODEL_CREATE_OVERVIEW,  "Create Overview");


		setEnabled(true);
	}
	
	
    @Override
	public void runWithEvent(Event event) {
        if(this.getActivePart() instanceof GraphicalFeatureModelEditor){
        	
    		HyFeatureModelOverviewGenerator generator = new HyFeatureModelOverviewGenerator();
    		
    		
    		try {
					generator.createOverviewFile(null, null);

    		} catch (TemplateNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (MalformedTemplateNameException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (TemplateException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();    		
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }

}