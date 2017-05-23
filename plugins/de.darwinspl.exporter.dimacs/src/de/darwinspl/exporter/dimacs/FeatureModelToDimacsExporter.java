package de.darwinspl.exporter.dimacs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.exporter.HyFeatureModelConsoleExporter;

public class FeatureModelToDimacsExporter {

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	
	public FeatureModelToDimacsExporter(HyFeatureModel featureModel, HyConstraintModel constraintModel) {
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		
		
		
	}
	
	public void export(String filename){
		
		if(filename == null) {
			System.err.println(this.getClass().getSimpleName() + ": filename null");
			return;
		}
		
		if(featureModel == null){
			System.err.println(this.getClass().getSimpleName() + ": featuremodel null");
			return;
		}
		
		List<HyFeature> features = featureModel.getFeatures();
		
		
		
		for(HyFeature feature : features) {
			System.out.println("feature: " + feature.getTypes());
			List<HyFeatureChild> children = feature.getParentOf();
			for(HyFeatureChild child : children) {
				System.out.println("child: " + child.getId());
			}
			
			
		}
			
		System.out.println("Exporting feature model to dimacs ...");
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header: p cnf (number of variables) (number of clauses)
			bufferedWriter.write("p cnf " + features.size());
			
			bufferedWriter.close();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter != null) bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if(fileWriter != null) fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
