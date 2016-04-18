/* Use is subject to license terms. */

package com.phosphene;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Buffer {
	private static Buffer a;
	
	private Buffer() {
		return;
	}
	
	protected static Buffer open() {
		if(a == null) {
			a = new Buffer();
		}
		return a;
	}
	
	public void infer() {
		return;
	}

	@SuppressWarnings("unchecked")
	protected <A> A read(String a) {
		return (A) this;
	}

	protected <B> String write(B a) {
		return "";
	}

	public <C> C get(C b) {
		return b;
	}

	public <D> D set(D b) {
		return b;
	}
}