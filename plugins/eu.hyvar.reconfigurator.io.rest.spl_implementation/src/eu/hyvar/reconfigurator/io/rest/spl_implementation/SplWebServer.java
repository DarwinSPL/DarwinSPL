package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class SplWebServer implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		// TODO Auto-generated method stub
		Server server = new Server(8080);

		HandlerCollection handlerCollection = new HandlerCollection();
		ContextHandler handler;
		
		handler = new ContextHandler("/createJsonImplementationResolution");
		handler.setContextPath("/createJsonImplementationResolution");
		// set allowed message size to 2MB
		handler.setMaxFormContentSize(2000000);
		handler.setHandler(new CreateHandlerImplementationResolutionInput());
		handlerCollection.addHandler(handler);

		
		handler = new ContextHandler("/createJsonConfigurationResolution");
		handler.setContextPath("/createJsonConfigurationResolution");
		// set allowed message size to 2MB
		handler.setMaxFormContentSize(2000000);
		handler.setHandler(new CreateHandlerConfigurationResolutionInput());
		handlerCollection.addHandler(handler);

		
		handler = new ContextHandler("/implementationResolution");
		handler.setContextPath("/implementationResolution");
		// set allowed message size to 2MB
		handler.setMaxFormContentSize(2000000);
		handler.setHandler(new JsonHandlerSPLImplementationResolution());
		handlerCollection.addHandler(handler);
		
		
		handler = new ContextHandler("/configurationResolution");
		handler.setContextPath("/configurationResolution");
		// set allowed message size to 2MB
		handler.setMaxFormContentSize(2000000);
		handler.setHandler(new JsonHandlerSPLConfigurationResolution());
		handlerCollection.addHandler(handler);
		
		
		handler = new ContextHandler("/health");
		handler.setContextPath("/health");
		// set allowed message size to 2MB
		handler.setMaxFormContentSize(2000000);
		handler.setHandler(new HandlerHealth());
		handlerCollection.addHandler(handler);
		
		
		server.setHandler(handlerCollection);
		server.start();
		
		server.join();
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
