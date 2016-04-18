/* Use is subject to license terms. */

package com.aurora.activity;

import com.aurora.aspect.State;

/**
 * The list of valid states for components.
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public enum LifecycleState implements State {
	INITIALIZING, INITIALIZED, 
	STARTING, STARTED, 
	STOPING, STOPPED, 
	DESTROYING, DESTROYED, 
	FAILED, IDLE;
	
	private LifecycleState() {}
}