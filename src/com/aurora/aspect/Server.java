/* Use is subject to license terms. */

package com.aurora.aspect;

import java.net.InetAddress;

import com.aurora.runtime.Acquisition;
import com.aurora.runtime.Persistence;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Server {
	public Acquisition adapter();

	public Persistence compiler();

	public Class<?>[] getLexicon();

	public void setLexicon(Class<?>[] b);

	public InetAddress getAddress();

	public void setAddress(InetAddress a);

	public int getPort();

	public void setPort(int a);
}
