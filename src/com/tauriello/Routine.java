 /* Use is subject to license terms. */

package com.tauriello;

import java.util.Iterator;

import com.aurora.aspect.Deliver;
import com.aurora.retain.Collection;
import com.aurora.retain.Session;
import com.phosphene.Facet;

/**
 * The
 *
 * @since 1.8.0_45
 * @version 1.0
 * @author Jacob Tauriello
 */
public class Routine implements Deliver {
	public Routine() {
		return;
	}

	@Override
	public void service(Facet<?> a, Collection b) {
		Iterator<Session> c = b.iterator();
		
		while (c.hasNext()) {
			Session d = c.next();
			d.send(a);
		}
	}
}