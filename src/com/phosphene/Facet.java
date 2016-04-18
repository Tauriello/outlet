/* Use is subject to license terms. */

package com.phosphene;

import com.phosphene.aspect.Decoder;
import com.phosphene.aspect.Encoder;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Facet<A> implements Decoder<A>, Encoder<A> {
	private Buffer a = Buffer.open();

	public Facet() {
		a.infer();
		return;
	}

	public <B> B y(B b) {
		return a.<B>get(b);
	}

	public <C> C z(C b) {
		return a.<C>set(b);
	}

	@Override
	public A decode(String b) {
		return a.<A>read(b);
	}

	@Override
	public String encode(A b) {
		return a.<A>write(b);
	}

	@Override
	public boolean willDecode(String a) {
		return !a.isEmpty();
	}

	@Override
	public void init() {
		return;
	}

	@Override
	public void destroy() {
		return;
	}
}