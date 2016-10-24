package eu.hyvar.feature.constraint.util.exporter;

import java.util.Date;

import eu.hyvar.feature.constraint.HyConstraintModel;

public interface HyConstraintModelExporter<T> {
	public abstract T exportConstraintModel(HyConstraintModel constraintModel, Date date);
}
