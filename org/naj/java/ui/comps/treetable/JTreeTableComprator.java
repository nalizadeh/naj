/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.util.Comparator;

/**
 * @author  P203125
 *
 * @param   <T>
 */
public class JTreeTableComprator<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
		if (o1 == null && o2 == null) {
			return 0;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}
		if (o1 != null && o2 == null) {
			return 1;
		}
		return o1.toString().compareTo(o2.toString());
	}

	public boolean equals(Object obj) {
		return obj == null ? false : toString().equals(obj.toString());
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
