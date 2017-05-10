/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;


/**
 * The IgnoredWordsFilter can be customized to add additional words that must not
 * be marked as misspelled. To customize this class, set option
 * 'overrideIgnoredWordsFilter' to <code>false</code>.
 */
public class HymanifestIgnoredWordsFilter {
	
	/**
	 * Checks whether the given word must be ignored even it is misspelled.
	 */
	public boolean ignoreWord(String word) {
		// By default we ignore all keywords that are defined in the syntax
		return eu.hyvar.mspl.manifest.resource.hymanifest.grammar.HymanifestGrammarInformationProvider.INSTANCE.getKeywords().contains(word);
	}
	
}
