/* Use is subject to license terms. */

package com.aurora.asset;

import com.aurora.aspect.Application;
import com.tauriello.Declare;
import com.tauriello.Routine;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public 	class One implements Application {
	private String a;
	private Class<?> b;
	private Class<?> c;

	{
		a = "name";
		b = Routine.class;
		c = Declare.class;
	}

	public One() {
		return;
	}

	@Override
	public Class<?> getApplication() {
		return b;
	}

	@Override
	public void setApplication(Class<?> a) {
		b = a;
		return;
	}

	@Override
	public Class<?> getProtocol() {
		return c;
	}

	@Override
	public void setProtocol(Class<?> a) {
		c = a;
		return;
	}

	@Override
	public String getName() {
		return a;
	}

	@Override
	public void setName(String b) {
		a = b;
		return;
	}
}