/* Use is subject to license terms. */

package com.aurora.identifier;

import com.aurora.activity.LifecycleState;
import com.aurora.aspect.Situation;
import com.aurora.aspect.State;

/**
 * The list of valid states for components.
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public abstract class Lifecycle implements Situation {	
	private LifecycleState a;
	
	public Lifecycle() {
		return;
	}
	
	public State getState() {
		return a;
	}

	public void setState(State b) {
		a = (LifecycleState) b;
	}
}