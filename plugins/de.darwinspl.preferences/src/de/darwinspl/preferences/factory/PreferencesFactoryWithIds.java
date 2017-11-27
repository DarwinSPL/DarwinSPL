package de.darwinspl.preferences.factory;

import de.darwinspl.preferences.DwPreference;
import de.darwinspl.preferences.impl.PreferencesFactoryImpl;

public class PreferencesFactoryWithIds extends PreferencesFactoryImpl {

	@Override
	public DwPreference createDwPreference() {
		DwPreference dwPreference = super.createDwPreference();
		dwPreference.createId();
		return dwPreference;
	}
	
}
