package eu.hyvar.feature.exporter.hfm_exporter.rest;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;


/**
 * This class controls all aspects of the application's execution
 */
public class WebServer implements IApplication {
	
	/* (non-Javadoc)
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext ctx) throws Exception {
		Server server = new Server(8080);

		ContextHandler context = new ContextHandler("/hyvar_to_deltaecore");
        context.setContextPath("/hyvar_to_deltaecore");
        // set maximal content size to 2MB
        context.setMaxFormContentSize(2000000);
        context.setHandler(new JsonHandler());
        
        server.setHandler(context);
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
