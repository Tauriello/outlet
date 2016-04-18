/* Use is subject to license terms. */

package com.aurora.aspect;

import com.aurora.aspect.State;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Situation {
	public State getState();

	public void setState(State a);
}