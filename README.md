![Logo](https://www.isf.cs.tu-bs.de/cms/team/nieke/darwinspl_logo.png)

# DarwinSPL
DarwinSPL is a software project to model evolving context-sensitive software product lines.

It strongly depends on DeltaEcore (www.deltaecore.org) which is necessary to run DarwinSPL.

# Prerequisites:
- Eclipse (e.g. Eclipse for Java and DSL Developers) (Tested with Mars, Neon and Oxygen)

- EMF Validation Framework and Model Comparison (EMF Compare): Eclipse navigation bar -> Help -> Install new software -> Under "Work with", select your eclipse's update site, e.g., for neon : http://download.eclipse.org/releases/neon -> In the filter, search for "EMF Validation" and select all, and search for "Model Comparison" and select all. Then hit next and follow the instructions

- DeltaEcore Framework (installation: http://deltaecore.org/?page_id=68 ). Instead of using the Team Project Set, we recommend to use the following SVN repositories and import all of these projects. Only works until the "Framework Workspace" in the installation instructions of DeltaEcore. SVN repositories (https://scm.fusionforge.zih.tu-dresden.de/anonscm/svn/ect/trunk/Utilities/ , https://scm.fusionforge.zih.tu-dresden.de/anonscm/svn/deltaecore/trunk/Framework)

# Installation:

https://youtu.be/BcIHb8PzvjA
(together with required plug-ins and DeltaEcore. You will need an SVN Team Provider for Eclipse when following the tutorial, such as subversive. Subversive can be installed using the Eclipse Marketplace)

1. Add the DarwinSPL Git repository to eclipse (In the top bar in eclipse -> Windows -> Perspective -> Open Perspective -> Other -> Git -> Add an existing local Git repository (in your case, as you already cloned it) or Clone a Git repository.
2. Open the DarwinSPL Git Repo  in the Git perspective -> Working Tree -> Right-click on "Plug-Ins" -> Import Projects -> Select all, but "Plugins" itself.
3. Go to the Java Perspective (top right corner the icon with the "J")
4. Press Shift + Alt + G, Select all .genmodels (Ctrl + A), hit "next"
5. Only Select "Model" for each .genmodel, hit "finish"
6. Do not generate text resources of *.cs files. EMFText is not working correctly.

# ATTENTION: if you want to use the reconfiguration or analyses functionality, you need HyVarRec:  https://github.com/HyVar/hyvar-rec.

You can use our hosted HyVarRec service with the pre-defined URL. If you want to do this, you need to contact me for the authentication credentials. Otherwise, you can host it on your own machine following the installation instructions of HyVarRec.

In any case, you will need to do the following to use HyVarRec:

In de.darwinspl.reconfigurator.client, you have to ensure that the jetty client version in the build path matches _exactly_ the jetty version of your eclipse installation.
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

# Publications:
http://dl.acm.org/citation.cfm?id=3023962

# Demo videos:
https://www.youtube.com/playlist?list=PLJZIl9YOWBqWvSW-BPbFmcesHmdx7IfYC
(important: syntax for expressions has changed since 2018/09/26. Arithmetical Comparison now do not work anymore with features and have to be put in curly brackets "{...}")

If you encounter any other issues, please contact me:
nieke ((at)) isf.cs.tu-bs.de
