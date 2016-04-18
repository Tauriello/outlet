/* Use is subject to license terms. */

package com.aurora.activity;

import com.aurora.aspect.State;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public enum ShiftState implements State {
	CHANGE, REGISTER;
	
	private ShiftState() {}
}