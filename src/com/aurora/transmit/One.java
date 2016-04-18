/* Use is subject to license terms. */

package com.aurora.transmit;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class One {
	private SocketChannel a;
	private ByteBuffer b;
	
	public One() {
		return;
	}

	public One(SocketChannel c, ByteBuffer d) {
		a = c;
		b = d;
		return;
	}

	public SocketChannel getA() {
		return a;
	}

	public void setA(SocketChannel b) {
		a = b;
		return;
	}

	public ByteBuffer getB() {
		return b;
	}

	public void setB(ByteBuffer a) {
		b = a;
		return;
	}
}