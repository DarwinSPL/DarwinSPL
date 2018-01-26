![Logo](https://michaelnieke.files.wordpress.com/2016/11/logo_original_rendered.png?w=300&h=94)

# DarwinSPL
DarwinSPL is a software project to model evolving context-sensitive software product lines.

It strongly depends on DeltaEcore (www.deltaecore.org) which is necessary to run DarwinSPL.

Prerequisites:
- Eclipse (e.g. Eclipse for Java and DSL Developers) (Tested with Mars, Neon and Oxygen)
- EMF Validation Framework (using your ecplise's update site - e.g. for neon: http://download.eclipse.org/releases/neon)
- Model Comparison (EMF Compare) (using your ecplise's update site - e.g. for neon: http://download.eclipse.org/releases/neon)
- DeltaEcore (installation: http://deltaecore.org/?page_id=68 )

Installation:
- Create Model Code for each *.genmodel file.
- Do not generate text resources of *.cs files. EMFText is not working correctly.

ATTENTION (if you want to use the integrated webservers or the reconfiguration engine HyVarRec https://github.com/HyVar/hyvar-rec):

In de.darwinspl.reconfigurator.client and eu.hyvar.reconfigurator.input.rest.dummyclient, you have to ensure that the jetty client version in the build path matches _exactly_ the jetty version of your eclipse installation.
You can check the required Jetty version if you look in your eclipse installation details:
Help -> About eclipse -> Installation Details -> Plug-ins -> search for Jetty
If it is not matching, you have to do the following:
- Right click on the project de.darwinspl.reconfigurator.client -> Build Path -> Configure Build Path -> Libraries:
   - Remove the wrong jetty jar
   - Add the correct jar via "Add JARs..." (can be downloaded from http://mvnrepository.com/artifact/org.eclipse.jetty/jetty-client and should be added to the "libs" folder of the project)
- Go to the manifest of the de.darwinspl.reconfigurator.client project:
   -> Runtime tab: replace the wrong jar in the classpath with the correct one
   -> Build tab: replace the wrong jar in the Runtime Information, Binary Build and Source Build with the correct one
- If you encounter any connection issues and exceptions with jetty, it is most likely that you are using the wrong version.

See the Wiki for more detailed information (outdated):
https://github.com/DarwinSPL/DarwinSPL/wiki

Publications:
http://dl.acm.org/citation.cfm?id=3023962

Demo video:
https://www.youtube.com/watch?v=qE-ep0FoguI

Troubleshooting:
https://github.com/DarwinSPL/DarwinSPL/wiki/Troubleshooting

If you encounter any other issues, please contact me:
nieke ((at)) isf.cs.tu-bs.de
