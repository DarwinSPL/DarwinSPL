package eu.hyvar.reconfigurator.input.rest.dummyclient;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {

		List<Thread> threads = new ArrayList<Thread>(10);
		
//		for(int i=0;i<100;i++) {
			FmToHyVarRecQueryThread fmToHyVarRecQueryThread = new FmToHyVarRecQueryThread();
			threads.add(fmToHyVarRecQueryThread);
//		}
		
		for(Thread thread: threads) {
			thread.start();
		}
		
		for(Thread thread: threads) {
			thread.join();
		}
				

		return IApplication.EXIT_OK;
	}
	

	@Override
	public void stop() {
		// Nothing to do
	}

}
