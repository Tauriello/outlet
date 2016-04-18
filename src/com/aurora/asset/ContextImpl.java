/* Use is subject to license terms. */

package com.aurora.asset;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aurora.aspect.Server;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class ContextImpl extends Context implements Server {
	private Class<?>[] a;
	private InetAddress b;
	private int c;

	{
		c = 8080;
		a = new Class<?>[] { One.class };
		
		try {
			b = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public ContextImpl() {
		return;
	}

	@Override
	public Class<?>[] getLexicon() {
		return a;
	}

	@Override
	public void setLexicon(Class<?>[] b) {
		a = b;
		return;
	}

	@Override
	public InetAddress getAddress() {
		return b;
	}

	@Override
	public void setAddress(InetAddress a) {
		b = a;
		return;
	}

	@Override
	public int getPort() {
		return c;
	}

	@Override
	public void setPort(int a) {
		c = a;
		return;
	}
}