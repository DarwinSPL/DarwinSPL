# DarwinSPL
DarwinSPL is a software project to model evolving context-aware software product lines.

It strongly depends on DeltaEcore (www.deltaecore.org) which is necessary to run DarwinSPL.

Prerequisites:
- EMFText Nightly
- DeltaEcore

Installation:
- Create Model and Edit Code for each *.genmodel file.
- in /eu.hyvar.feature/src-gen/eu/hyvar/feature/impl/HyFeatureImpl.java, add two imports manually: import eu.hyvar.evolution.HyEvolutionUtil;  import eu.hyvar.feature.HyFeatureTypeEnum; (P.S.: If anyone knows how to add imports in generated Code of Ecore: please contact me :) )
- Generate TextResources of all *.cs file (currently not necessary or possible due to a EMFText bug)



See the Wiki for more detailed information:
https://github.com/HyVar/DarwinSPL/wiki
