/* Use is subject to license terms. */

package com.tauriello;

import com.phosphene.Facet;
import com.phosphene.annotation.Order;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Declare extends Facet<Declare> {
	@Order(0) int a;
	@Order(1) int b;
	@Order(2) int c;
	@Order(3) int d;
	@Order(4) int e;
	@Order(5) int f;

	public Declare() {
		return;
	}

	public int getA() {
		return a = y(a);
	}

	public void setA(int b) {
		a = z(b);
		return;
	}

	public int getB() {
		return b = y(b);
	}

	public void setB(int a) {
		b = z(a);
		return;
	}

	public int getC() {
		return c = y(c);
	}

	public void setC(int b) {
		c = z(b);
		return;
	}

	public int getD() {
		return d = y(d);
	}

	public void setD(int b) {
		d = z(b);
		return;
	}

	public int getE() {
		return e = y(e);
	}

	public void setE(int b) {
		e = z(b);
		return;
	}

	public int getF() {
		return f = y(f);
	}

	public void setF(int b) {
		f = z(b);
		return;
	}
}