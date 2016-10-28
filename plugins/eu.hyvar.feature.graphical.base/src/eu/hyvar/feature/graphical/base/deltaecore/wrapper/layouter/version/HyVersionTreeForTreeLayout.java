package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version;

import java.util.Date;
import java.util.List;

import org.abego.treelayout.util.AbstractTreeForTreeLayout;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyVersion;

public class HyVersionTreeForTreeLayout extends AbstractTreeForTreeLayout<HyVersion> {
	private Date date;
	
	public HyVersionTreeForTreeLayout(HyVersion initialVersion, Date date) {
		super(initialVersion);

		this.date = (date != null) ? date : new Date();
	}

	@Override
	public List<HyVersion> getChildrenList(HyVersion version) {
		System.out.println(version);
		List<HyVersion> children =  HyEvolutionUtil.getValidTemporalElements(version.getSupersedingVersions(), date);
		
		return children;
	}

	@Override
	public HyVersion getParent(HyVersion version) {
		return version.getSupersededVersion();
	}
}
