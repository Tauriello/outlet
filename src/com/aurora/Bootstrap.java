/* Use is subject to license terms. */

package com.aurora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.aurora.asset.ContextImpl;

/**
 * Bootstrap loader for Aurora. This application constructs and starts the
 * execution of private resources not visible to application level classes.
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Bootstrap {
	private ContextImpl q;
	private Thread e;
	private Thread f;

	{
		q = new ContextImpl();
		
		f = new Thread(q.compiler());
		e = new Thread(q.adapter());
	}

	private Bootstrap() {
		return;
	}

	public static void main(String[] a) {
		Bootstrap e = new Bootstrap();
		try {
			e.init();
		} catch (Exception f) {
			f.printStackTrace();
		}
		return;
	}

	public void start() throws Exception {
		f.start();
		e.start();
		return;
	}

	public void stop() throws Exception {
		if (f.isAlive()) {
			f.interrupt();
		}
		if (e.isAlive()) {
			e.interrupt();
		}
		if (Thread.currentThread().isAlive()) {
			Runtime.getRuntime().exit(0);
		}
		return;
	}

	public void init() throws Exception {
		InputStream b = System.in;

		InputStreamReader c = new InputStreamReader(b);
		BufferedReader d = new BufferedReader(c);

		String j;

		try {
			while ((j = d.readLine()) != null) {
				switch (j) {
				case "open":
					this.start();
					break;
				case "close":
					this.stop();
					break;
				default:
					break;
				}
			}
		} catch (IOException k) {
			k.printStackTrace();
		} finally {
			try {
				d.close();
				c.close();
				b.close();
			} catch (IOException k) {
				k.printStackTrace();
			}
		}
		return;
	}
}