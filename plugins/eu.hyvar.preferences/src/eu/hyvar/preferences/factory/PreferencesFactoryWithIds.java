package eu.hyvar.preferences.factory;

import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.impl.PreferencesFactoryImpl;

public class PreferencesFactoryWithIds extends PreferencesFactoryImpl {

	@Override
	public HyPreference createHyPreference() {
		HyPreference hyPreference = super.createHyPreference();
		hyPreference.createId();
		return hyPreference;
	}
	
}
