# DarwinSPL
DarwinSPL is a software project to model evolving context-aware software product lines.

It strongly depends on DeltaEcore (www.deltaecore.org) which is necessary to run DarwinSPL.

Prerequisites:
- Eclipse (e.g. Eclipse for Java and DSL Developers); Probably not fully working with Neon. So Mars is recommended
- EMFText Nightly
- DeltaEcore

Installation:
- Create Model Code for each *.genmodel file.
- Generate TextResources of all *.cs file (currently not necessary or possible due to a EMFText bug)

ATTENTION:
In eu.hyvar.feature.graphical.configurator.editor and eu.hyvar.reconfigurator.input.rest.dummyclient, you have to ensure that the jetty client version in the build path matches _exactly_ the jetty version of your eclipse installation. If it is not matching, you have to add it to the "lib" folder, replace it in the build path of the project and replace it in the "Classpath" in the "Runtime" tab of the Manifest.MF. 


See the Wiki for more detailed information:
https://github.com/HyVar/DarwinSPL/wiki

Demo video:
https://www.youtube.com/watch?v=qE-ep0FoguI
