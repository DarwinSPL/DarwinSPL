package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version;

import org.abego.treelayout.NodeExtentProvider;
import org.deltaecore.feature.graphical.base.util.DEGeometryUtil;

import eu.hyvar.feature.HyVersion;

public class HyVersionNodeExtentProvider implements NodeExtentProvider<HyVersion> {
	
		@Override
		public double getWidth(HyVersion version) {
			return DEGeometryUtil.calculateVersionWidth(version.getNumber());
		}
		
		@Override
		public double getHeight(HyVersion version) {
			return DEGeometryUtil.calculateVersionHeight(version.getNumber());
		}
	}
	