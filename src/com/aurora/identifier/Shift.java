/* Use is subject to license terms. */

package com.aurora.identifier;

import com.aurora.activity.ShiftState;
import com.aurora.aspect.Situation;
import com.aurora.aspect.State;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public abstract class Shift implements Situation {
	private ShiftState a;
	
	public Shift() {
		return;
	}
	
	public State getState() {
		return a;
	}

	public void setState(State b) {
		a = (ShiftState) b;
	}
}