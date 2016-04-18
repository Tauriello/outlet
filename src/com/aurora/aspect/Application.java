/* Use is subject to license terms. */

package com.aurora.aspect;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Application {
	public Class<?> getApplication();

	public void setApplication(Class<?> a);

	public Class<?> getProtocol();

	public void setProtocol(Class<?> a);

	public String getName();

	public void setName(String b);
}
