/* Use is subject to license terms. */

package com.phosphene.aspect;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Decoder<A> {
	public void init();
	public boolean willDecode(String a);
	public A decode(String a);
	public void destroy();
}