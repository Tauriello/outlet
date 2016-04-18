/* Use is subject to license terms. */

package com.aurora.aspect;

import com.aurora.retain.Collection;
import com.phosphene.Facet;

/**
 * Null
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public interface Deliver {
	public void service(Facet<?> a, Collection b);
}