package sc.fiji.script;

import net.imagej.patcher.LegacyEnvironment;

/**
 * A simple test drive for the {@link Script_Launcher} plugin.
 * 
 * @author Johannes Schindelin
 */
public class LauncherTestDrive {
	public static void main(String[] args) throws ClassNotFoundException {
		final LegacyEnvironment ij1 = new LegacyEnvironment(null, false);
		ij1.addPluginClasspath(Thread.currentThread().getContextClassLoader());
		// show GUI
		ij1.main();
		// run script
		ij1.run("Script Launcher Test Drive", "");
	}
}
