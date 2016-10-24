package eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;

public class HyVersionUtil {
	
	public static HyVersion getRootVersion(HyFeature feature) {
		//Make sure that it is the initial version not just the one declared first in the model
		List<HyVersion> versions = feature.getVersions();
		
		for (HyVersion version : versions) {
			if (isRootVersion(version)) {
				return version;
			}
		}
		
		return null;
	}
	
	public static boolean isRootVersion(HyVersion version) {
		return version.getSupersededVersion() == null;
	}
	
	
	public static HyVersion getLastVersionOnMostRecentBranch(HyFeature feature) {
		List<HyVersion> versions = feature.getVersions();
		HyVersion lastVersion = null;
		
		for (HyVersion version : versions) {
			if (isLastVersionOnBranch(version)) {
				lastVersion = version;
			}
		}
		
		return lastVersion;
	}

	public static void wireAndAddVersionAsRoot(HyVersion version, HyFeature parentFeature) {
		if (version == null || parentFeature == null) {
			throw new InvalidParameterException();
		}
		
		//NOTE: Order mandatory for possible notifications.
		wireVersionAsRoot(version, parentFeature);
		addVersion(version, parentFeature);
	}
	
	public static void wireAndAddVersionAfter(HyVersion version, HyVersion addAfterVersion) {
		if (version == null || addAfterVersion == null) {
			throw new InvalidParameterException();
		}
		
		//NOTE: Order mandatory for possible notifications.
		wireVersionAfter(version, addAfterVersion);
		addVersionAfter(version, addAfterVersion);
	}
	
	public static void wireAndAddVersionAfterOnNewBranch(HyVersion version, HyVersion addAfterVersion) {
		if (version == null || addAfterVersion == null) {
			throw new InvalidParameterException();
		}
		
		//NOTE: Order mandatory for possible notifications.
		wireVersionAfterOnNewBranch(version, addAfterVersion);
		addVersionAfter(version, addAfterVersion);
	}
	
	public static void wireAndAddVersionBefore(HyVersion version, HyVersion addBeforeVersion) {
		if (version == null || addBeforeVersion == null) {
			throw new InvalidParameterException();
		}
		
		//NOTE: Order mandatory for possible notifications.
		wireVersionBefore(version, addBeforeVersion);
		addVersionBefore(version, addBeforeVersion);
	}
	
	
	public static void addVersionAfter(HyVersion version, HyVersion addAfterVersion) {
		if (version == null || addAfterVersion == null) {
			throw new InvalidParameterException();
		}
		
		HyFeature parentFeature = addAfterVersion.getFeature();
		List<HyVersion> versions = parentFeature.getVersions();
		int index = versions.indexOf(addAfterVersion) + 1;
		addVersion(version, parentFeature, index);
	}
	
	public static void addVersionBefore(HyVersion version, HyVersion addBeforeVersion) {
		if (version == null || addBeforeVersion == null) {
			throw new InvalidParameterException();
		}
		
		HyFeature parentFeature = addBeforeVersion.getFeature();
		List<HyVersion> versions = parentFeature.getVersions();
		int index = versions.indexOf(addBeforeVersion);
		addVersion(version, parentFeature, index);
	}
	
	public static void addVersion(HyVersion version, HyFeature parentFeature) {
		addVersion(version, parentFeature, -1);
	}
	
	public static void addVersion(HyVersion version, HyFeature parentFeature, int index) {
		List<HyVersion> versions = parentFeature.getVersions();
		
		if (index == -1) {
			versions.add(version);
		} else if (index < 0) {
			versions.add(0, version);
		} else if (index >= versions.size()) {
			versions.add(version);
		} else {
			versions.add(index, version);
		}
	}
	
	public static int removeVersion(HyVersion version) {
		HyFeature parentFeature = version.getFeature();
		
		if (parentFeature == null) {
			return -1;
		}
		
		List<HyVersion> versions = parentFeature.getVersions();
		int index = versions.indexOf(version);
		versions.remove(version);
		return index;
	}
	
	public static void wireVersionAsRoot(HyVersion version, HyFeature parentFeature) {
		if (version == null || parentFeature == null) {
			throw new InvalidParameterException();
		}
		
		HyVersion oldRootVersion = getRootVersion(parentFeature);
		
		if (oldRootVersion != null) {
			oldRootVersion.setSupersededVersion(version);
		}
	}
	
	public static void wireVersionAfter(HyVersion version, HyVersion insertAfterVersion) {
		if (version == null || insertAfterVersion == null) {
			throw new InvalidParameterException();
		}
		
		HyVersion predecessor = insertAfterVersion;
		List<HyVersion> successors = insertAfterVersion.getSupersedingVersions();
		
		rewireVersion(version, predecessor, successors);
	}
	
	public static void wireVersionAfterOnNewBranch(HyVersion version, HyVersion insertAfterVersion) {
		if (version == null || insertAfterVersion == null) {
			throw new InvalidParameterException();
		}
		
		HyVersion predecessor = insertAfterVersion;
		rewireVersion(version, predecessor, null);
	}
	
	public static void wireVersionBefore(HyVersion version, HyVersion insertBeforeVersion) {
		wireVersionBefore(version, insertBeforeVersion, false);
	}
	
	public static void wireVersionBefore(HyVersion version, HyVersion insertBeforeVersion, boolean insertBeforeBranching) {
		if (version == null || insertBeforeVersion == null) {
			throw new InvalidParameterException();
		}
		
		HyVersion predecessor = insertBeforeVersion.getSupersededVersion();
		
		if (predecessor == null) {
			HyFeature parentFeature = insertBeforeVersion.getFeature();
			wireVersionAsRoot(version, parentFeature);
		} else {
			List<HyVersion> successors = insertBeforeBranching ? predecessor.getSupersedingVersions() : Collections.singletonList(insertBeforeVersion);
			rewireVersion(version, predecessor, successors);
		}
	}
	
	public static void rewireVersion(HyVersion version, HyVersion newPredecessor, List<HyVersion> newSuccessors) {
		if (version == null) {
			return;
		}
		
		//Defensive copy as the list may change due to inverse references!
		List<HyVersion> newSuccessorsCopy = new ArrayList<HyVersion>();
		
		if (newSuccessors != null) {
			newSuccessorsCopy.addAll(newSuccessors);
		}
		
		version.setSupersededVersion(newPredecessor);
		
		for (HyVersion newSuccessor : newSuccessorsCopy) {
			newSuccessor.setSupersededVersion(version);
		}
	}
	
	public static void unwireAndRemoveVersion(HyVersion version) {
		HyVersionUtil.unwireVersion(version);
		HyVersionUtil.removeVersion(version);
	}
	
	public static void unwireVersion(HyVersion version) {
		List<HyVersion> successors = version.getSupersedingVersions();
		//Defensive copy as the list may change due to inverse references!
		List<HyVersion> oldSuccessors = new ArrayList<HyVersion>(successors);
		
		HyVersion oldPredecessor = version.getSupersededVersion();
		version.setSupersededVersion(null);
		
		for (HyVersion oldSuccessor : oldSuccessors) {
			oldSuccessor.setSupersededVersion(oldPredecessor);
		}
	}
	
	
	public static boolean isLastVersionOnBranch(HyVersion version) {
		List<HyVersion> successors = version.getSupersedingVersions();
		return successors.isEmpty();
	}
	
}
