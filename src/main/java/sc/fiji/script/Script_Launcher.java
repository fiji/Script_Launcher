package sc.fiji.script;

import ij.IJ;
import ij.plugin.PlugIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.script.ScriptException;

import org.scijava.Context;
import org.scijava.plugin.Parameter;
import org.scijava.script.ScriptService;

/**
 * A very simple ImageJ 1.x plugin to run scripts using the SciJava framework.
 * 
 * @author Johannes Schindelin
 */
public class Script_Launcher implements PlugIn {

	@Parameter
	private ScriptService service;

	@Override
	public synchronized void run(String arg) {
		if (service == null) {
			final Context context = (Context)
					IJ.runPlugIn(Context.class.getName(), "");
			service = context.getService(ScriptService.class);
		}

		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			final InputStream in = arg.startsWith("jar:") ?
				loader.getResourceAsStream(arg.substring(4)) :
				new FileInputStream(arg);
				if (in == null) {
					IJ.error("Could not find script " + arg);
					return;
				}
				final Reader reader = new InputStreamReader(in);
				service.run(arg, reader, true);
		}
		catch (FileNotFoundException e) {
			IJ.error("Could not find file " + arg);
		}
		catch (IOException e) {
			IJ.error("There was an error reading " + arg);
			IJ.handleException(e);
		}
		catch (ScriptException e) {
			IJ.error("There was an error running " + arg);
			IJ.handleException(e);
		}
	}

}
