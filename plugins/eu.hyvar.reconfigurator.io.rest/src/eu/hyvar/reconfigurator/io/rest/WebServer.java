package eu.hyvar.reconfigurator.io.rest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;

/**
 * This class controls all aspects of the application's execution
 */
public class WebServer implements IApplication {
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext ctx) throws Exception {
		Server server = new Server(8080);

		HandlerCollection handlerCollection = new HandlerCollection();
		
		ContextHandler context = new ContextHandler("/fm_for_hyvarrec");
        context.setContextPath("/fm_for_hyvarrec");
        // set allowed message size to 2MB
        context.setMaxFormContentSize(2000000);
        context.setHandler(new JsonHandlerFMForHyVarRec());
        
        handlerCollection.addHandler(context);
        
        ContextHandler newConfigContext = new ContextHandler("/new_hyvarrec_config");
        newConfigContext.setContextPath("/new_hyvarrec_config");
        // set allowed message size to 2MB
        newConfigContext.setMaxFormContentSize(2000000);
        newConfigContext.setHandler(new JsonHandlerNewHyVarRecConfig());
        
        handlerCollection.addHandler(newConfigContext);
        
        server.setHandler(handlerCollection);
		server.start();
		
		
		server.join();
        return IApplication.EXIT_OK;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {

	}
}
