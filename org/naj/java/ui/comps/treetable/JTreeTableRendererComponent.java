/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.awt.Component;

/**
 * @author  P203125
 */
public interface JTreeTableRendererComponent {

	public Object getRendererValue();

	public void setRendererValue(Object value);

	public Component getRendererComponent(
		Component parent,
		Object    value,
		boolean   isSelected,
		boolean   isEnabled,
		Color	  fc,
		Color	  bc
	);
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
