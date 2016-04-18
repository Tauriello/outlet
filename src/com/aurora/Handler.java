/* Use is subject to license terms. */

package com.aurora;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Map;

import com.aurora.runtime.Persistence;

/**
 * Methods that handle {@link #accept}, {@link #read}, {@link #write}
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Handler {
	private static ByteBuffer c;
	private Persistence d;

	static {
		c = ByteBuffer.allocate(8192);
	}

	public Handler() {
		return;
	}

	public void accept(ServerSocketChannel b, Selector c) throws IOException {
		SocketChannel d = b.accept();

		d.configureBlocking(false);
		d.register(c, SelectionKey.OP_READ);
		return;
	}

	public void read(SocketChannel b, SelectionKey f) throws IOException {

		c.clear();

		int e;
		try {
			e = b.read(c);
		} catch (IOException g) {
			f.cancel();
			b.close();
			return;
		}

		if (e == -1) {
			b.close();
			f.cancel();
			return;
		}
		
		d.queue(b, c);
		return;
	}
	
	public void write(SocketChannel b, SelectionKey d, Map<SocketChannel, List<ByteBuffer>> l) throws IOException {
		synchronized (l) {
			List<ByteBuffer> f = l.get(b);

			while (!f.isEmpty()) {
				ByteBuffer e = f.get(0);
				b.write(e);

				if (e.remaining() > 0) {
					break;
				}
				f.remove(0);
			}

			if (f.isEmpty()) {
				d.interestOps(SelectionKey.OP_READ);
			}
		}
		return;
	}

	public void setWorker(Persistence a) {
		d = a;
	}
}