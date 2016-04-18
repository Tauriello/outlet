/* Use is subject to license terms. */

package com.aurora.asset;

import java.net.InetAddress;

import com.aurora.identifier.Lifecycle;
import com.aurora.runtime.Acquisition;
import com.aurora.runtime.Persistence;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public abstract class Context {
	public Acquisition a;
	public Persistence b;
	public Lifecycle c;

	{
		a = new Acquisition(b);
		b = new Persistence(a);
		
		a.set(b);
		b.set(a);
	}

	public Context() {
		return;
	}

	public Acquisition adapter() {
		return a;
	}

	public Persistence compiler() {
		return b;
	}

	public Lifecycle getStatus() {
		return c;
	}

	public void setStatus(Lifecycle a) {
		c = a;
		return;
	}

	public abstract Class<?>[] getLexicon();

	public abstract void setLexicon(Class<?>[] b);

	public abstract InetAddress getAddress();

	public abstract void setAddress(InetAddress a);

	public abstract int getPort();

	public abstract void setPort(int a);
}