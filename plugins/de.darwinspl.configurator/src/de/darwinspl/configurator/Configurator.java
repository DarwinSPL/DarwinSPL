package de.darwinspl.configurator;

import java.io.IOException;
import java.util.Scanner;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class Configurator extends AbstractHandler {

	
	private String dimacsPath;
	
	public Configurator(){
		
	}
	
	public Configurator(String dimacsPath){
		this.dimacsPath = dimacsPath;
	}
	
	public void run(){
		try {
			Process process = Runtime.getRuntime().exec("java -jar C:\\Users\\J\\Downloads\\satibea\\satibea.jar " + dimacsPath + " 10000");
			Scanner s = new Scanner(process.getInputStream()).useDelimiter("\\A");
			String result = s.hasNext() ? s.next() : "";
			System.out.println("Configurator: Result:");
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		System.out.println("Generating...");
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
