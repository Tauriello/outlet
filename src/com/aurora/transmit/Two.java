/* Use is subject to license terms. */

package com.aurora.transmit;

import java.nio.channels.SocketChannel;

import com.aurora.activity.ShiftState;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Two {
	private int b;
	private ShiftState a;
	private SocketChannel c;
	
	public Two() {
		return;
	}
	
	public Two(ShiftState d, int e, SocketChannel f) {
		a = d;
		b = e;
		c = f;
		return;
	}

	public ShiftState getA() {
		return a;
	}

	public void setA(ShiftState b) {
		a = b;
		return;
	}

	public int getB() {
		return b;
	}

	public void setB(int a) {
		b = a;
		return;
	}
	
	public SocketChannel getC() {
		return c;
	}

	public void setC(SocketChannel a) {
		c = a;
		return;
	}
}