/* Use is subject to license terms. */

package com.aurora.runtime;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

import com.aurora.transmit.One;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Persistence implements Runnable {
	private List<One> a = new LinkedList<One>();
	private SocketChannel g;
	private Acquisition c;

	public Persistence(Acquisition a) {
		return;
	}

	@Override
	public void run() {
		One b;

		try {
			while (!Thread.interrupted()) {
				synchronized (a) {
					while (a.isEmpty()) {
						a.wait();
					}
					b = a.remove(0);
				}

				ByteBuffer d = b.getB();
				String f = new String(d.array()).trim();

				if (g == null) {
					if (f.equals("write")) {
						System.out.println("write");
						g = b.getA();
					}
				} else {
					c.queue(g, d);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			a.clear();
		}
		return;
	}

	public void queue(SocketChannel c, ByteBuffer d) {
		synchronized (a) {
			a.add(new One(c, d));
			a.notify();
		}
		return;
	}
	public void set(Acquisition a) {
		c = a;
	}
}