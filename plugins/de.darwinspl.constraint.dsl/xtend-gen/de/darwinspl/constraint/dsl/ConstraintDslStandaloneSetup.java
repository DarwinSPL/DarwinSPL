/**
 * generated by Xtext 2.12.0
 */
package de.darwinspl.constraint.dsl;

import de.darwinspl.constraint.dsl.ConstraintDslStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class ConstraintDslStandaloneSetup extends ConstraintDslStandaloneSetupGenerated {
  public static void doSetup() {
    new ConstraintDslStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
