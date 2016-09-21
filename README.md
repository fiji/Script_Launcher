Script Launcher
===============

This simple ImageJ 1.x plugin allows running scripts packaged in a jar file
by adding a simple `plugins.config` file that calls
`sc.fiji.script.Script_Launcher("jar:<script-filename>")`

IMPORTANT NOTE
--------------

This approach was originally developed to maintain compatibility with
plain [ImageJ 1.x](http://imagej.net/ImageJ1).

However, if you are running [ImageJ2](http://imagej.net/ImageJ2), you can
simply place your scripts in the `scripts/` subtree inside your JAR file,
and they will be automatically discovered and added to the menus by the
[SciJava Common](http://imagej.net/SciJava_Common) script framework.

See [this forum post](http://forum.imagej.net/t/2050) for details.
