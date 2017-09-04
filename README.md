![Logo](https://michaelnieke.files.wordpress.com/2016/11/logo_original_rendered.png?w=300&h=94)

# DarwinSPL
DarwinSPL is a software project to model evolving context-sensitive software product lines.

It strongly depends on DeltaEcore (www.deltaecore.org) which is necessary to run DarwinSPL.

Prerequisites:
- Eclipse (e.g. Eclipse for Java and DSL Developers) (Tested with Mars, Neon and Oxygen)
- EMF Validation Framework (using your ecplise's update site - e.g. for neon: http://download.eclipse.org/releases/neon)
- EMF Comparison (using your ecplise's update site - e.g. for neon: http://download.eclipse.org/releases/neon)
- DeltaEcore (installation: http://deltaecore.org/?page_id=68 )

Installation:
- Create Model Code for each *.genmodel file.
- Do not generate text resources of *.cs files. EMFText is not working correctly.

ATTENTION (if you want to use the integrated webservers or the reconfiguration engine HyVarRec https://github.com/HyVar/hyvar-rec):

In de.darwinspl.reconfigurator.client and eu.hyvar.reconfigurator.input.rest.dummyclient, you have to ensure that the jetty client version in the build path matches _exactly_ the jetty version of your eclipse installation. If it is not matching, you have to add it to the "lib" folder, replace it in the build path of the project and replace it in the "Classpath" in the "Runtime" tab of the Manifest.MF. 
You can find your eclipse' Jetty version via Help -> About Eclipse -> Installation Details -> Plug-ins -> Seach for Jetty


See the Wiki for more detailed information (outdated):
https://github.com/DarwinSPL/DarwinSPL/wiki

Publications:
http://dl.acm.org/citation.cfm?id=3023962

Demo video:
https://www.youtube.com/watch?v=qE-ep0FoguI
