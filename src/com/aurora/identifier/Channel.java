/* Use is subject to license terms. */

package com.aurora.identifier;

import com.aurora.activity.ChannelState;
import com.aurora.aspect.Situation;
import com.aurora.aspect.State;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public abstract class Channel implements Situation {
	private ChannelState a;
	
	public Channel() {
		return;
	}
	
	public State getState() {
		return a;
	}

	public void setState(State b) {
		a = (ChannelState) b;
	}
}