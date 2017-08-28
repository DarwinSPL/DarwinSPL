package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HandlerHealth extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Send the output message
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("It works.");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}

}
