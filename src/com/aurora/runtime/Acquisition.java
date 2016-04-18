/* Use is subject to license terms. */

package com.aurora.runtime;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aurora.Handler;
import com.aurora.activity.ShiftState;
import com.aurora.asset.Context;
import com.aurora.asset.ContextImpl;
import com.aurora.transmit.Two;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Acquisition implements Runnable {
	private static SelectorProvider m;
	private static ServerSocketChannel a;
	private static Selector b;
	private static InetSocketAddress e;
	private static Context q;

	private static List<Two> k;
	private static Map<SocketChannel, List<ByteBuffer>> l;
	
	private static Handler h;
	
	static {
		h = new Handler();
		q = new ContextImpl();
		k = new LinkedList<Two>();
		l = new HashMap<SocketChannel, List<ByteBuffer>>();
		e = new InetSocketAddress(q.getAddress(), q.getPort());

		m = SelectorProvider.provider();
			
		try {
			a = m.openServerSocketChannel();
			b = m.openSelector();

			a.bind(e, 0);
			a.configureBlocking(false);
			a.register(b, SelectionKey.OP_ACCEPT);
		} catch (IOException c) {
			c.printStackTrace();
		}
	}

	public Acquisition(Persistence a) {
		return;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (k) {
					Iterator<Two> i = k.iterator();

					while (i.hasNext()) {
						Two j = i.next();

						switch (j.getA()) {
						case CHANGE:

							SelectionKey key = j.getC().keyFor(b);
							key.interestOps(j.getB());

							break;
						default:
							break;
						}
					}
					k.clear();
				}

				if (b.select() > 0) {
					continue;
				}

				Set<SelectionKey> c = b.selectedKeys();
				Iterator<SelectionKey> d = c.iterator();

				while (d.hasNext()) {
					SelectionKey e = d.next();

					if (!e.isValid()) {
						continue;
					}

					SelectableChannel f = e.channel();

					if (e.isAcceptable()) {
						h.accept((ServerSocketChannel) f, b);
					} else if (e.isReadable()) {
						h.read((SocketChannel) f, e);
					} else if (e.isWritable()) {
						h.write((SocketChannel) f, e, l);
					}
					d.remove();
				}
				c.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(b.isOpen()) {
					b.close();
				}
				if(a.isOpen()) {
					a.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return;
	}

	public void queue(SocketChannel a, ByteBuffer c) {
		synchronized (k) {
			k.add(new Two(ShiftState.CHANGE, SelectionKey.OP_WRITE, a));

			synchronized (l) {
				List<ByteBuffer> m = l.get(a);
				
				if (m == null) {
					m = new ArrayList<ByteBuffer>();
					l.put(a, m);
				}
				m.add(c);
			}
		}
		b.wakeup();
	}
	
	public void set(Persistence a) {
		h.setWorker(a);
	}
}