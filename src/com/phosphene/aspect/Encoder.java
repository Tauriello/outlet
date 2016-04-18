/* Use is subject to license terms. */

package com.phosphene.aspect;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Encoder<A> {
	public void init();
	public String encode(A a);
	public void destroy();
}