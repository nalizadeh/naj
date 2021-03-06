/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

/**
 * @author  P203125
 */
public class JTreeTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private JTreeTable treetable;

	protected String[] columnNames;
	protected List<String> viewColumns = new ArrayList<String>();
	private Map<String, Integer> columnsMap = new LinkedHashMap<String, Integer>();

	private Map<Class<?>, JTreeTableRendererComponent> typeToRenderer;
	private Map<Object, JTreeTableRendererComponent> nameToRenderer;

	private Map<Class<?>, JTreeTableEditorComponent> typeToEditor;
	private Map<Object, JTreeTableEditorComponent> nameToEditor;

	/**
	 * @param  treetable
	 * @param  columnNames
	 * @param  viewColumns
	 */
	public JTreeTableModel(JTreeTable treetable, String[] columnNames, List<String> viewColumns) {

		this.treetable = treetable;
		this.columnNames = columnNames;

		typeToRenderer = new HashMap<Class<?>, JTreeTableRendererComponent>();
		nameToRenderer = new HashMap<Object, JTreeTableRendererComponent>();

		typeToEditor = new HashMap<Class<?>, JTreeTableEditorComponent>();
		nameToEditor = new HashMap<Object, JTreeTableEditorComponent>();

		setViewColumns(viewColumns, true);

		registerDefaultRenderers();
		registerDefaultEditors();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected void setViewColumns(List<String> columns, boolean initial) {
		if (initial) {
			viewColumns.clear();
			columnsMap.clear();
			for (int i = 0; i < columnNames.length; i++) {
				viewColumns.add(columnNames[i]);
				columnsMap.put(columnNames[i], i);
			}
			return;
		}

		List<String> cols = new ArrayList<String>();
		for (int i = 0; i < columnNames.length; i++) {
			if (columns.contains(columnNames[i])) {
				cols.add(columnNames[i]);
			}
		}

		if (!cols.isEmpty()) {
			viewColumns.clear();
			for (String col : cols) {
				viewColumns.add(col);
			}
			fireTableStructureChanged();
			treetable.tableUpdated();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected List<String> getViewColumns() {
		return viewColumns;
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	protected boolean isColumnVisible(int column) {
		return viewColumns.contains(columnNames[column]);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	private int translateColumn(int column) {
		return columnsMap.get(viewColumns.get(column));
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public int getColumnCount() {
		return viewColumns.size();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public int getRowCount() {
		return treetable.getTree().getRowCount();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public String getColumnName(int column) {
		return viewColumns.get(column);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public Class<? extends Object> getColumnClass(int column) {
		if (column == 0) {
			return treetable.getTree().getClass();
		}
		Object v = getValueAt(0, column);
		return v == null ? null : v.getClass();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public Object getValueAt(int row, int column) {
		JTreeTableNode node = treetable.getNodeAtRow(row);
		return node == null ? null : node.getValue(translateColumn(column));
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public void setValueAt(Object value, int row, int column) {
		JTreeTableNode node = treetable.getNodeAtRow(row);
		if (node != null) {
			column = translateColumn(column);
			Object oldValue = node.getValue(column);
			node.setValue(column, value);
			node.editorValueChanged(oldValue, value);
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column == 0) {
			return true;
		}
		JTreeTableNode node = treetable.getNodeAtRow(row);
		return node.isEditable(row, translateColumn(column));
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	public boolean isCellEnabled(int row, int column) {
		if (column == 0) {
			return true;
		}
		JTreeTableNode node = treetable.getNodeAtRow(row);
		return node.isEnabled(row, translateColumn(column));
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	protected JTreeTableRendererComponent getRendererAt(JTreeTableNode node, int row, int column) {
		column = translateColumn(column);
		JTreeTableRendererComponent renderer = node.getRenderer(row, column);
		if (renderer == null) {
			renderer = getRenderer(node.getNodeKey());
			if (renderer == null) {
				renderer = getRenderer(node.getType(row, column));
				if (renderer == null) {
					renderer = getRenderer(Object.class);
					if (renderer == null && node.isEditable(row, column)) {
						renderer = getEditorAt(node, row, column);
					}
				}
			}
		}
		return renderer;
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	protected JTreeTableEditorComponent getEditorAt(JTreeTableNode node, int row, int column) {
		column = translateColumn(column);
		JTreeTableEditorComponent editor = node.getEditor(row, column);
		if (editor != null) {
			editor = node.getEditorInstance(editor);
		} else {
			editor = getEditor(node.getNodeKey());
			if (editor == null) {
				editor = getEditor(node.getType(row, column));
				if (editor == null) {
					editor = getEditor(Object.class);
				}
			}
		}
		return editor;
	}

	public void registerRenderer(Class<?> type, JTreeTableRendererComponent renderer) {
		typeToRenderer.put(type, renderer);
	}

	public void registerRenderer(Object key, JTreeTableRendererComponent renderer) {
		nameToRenderer.put(key, renderer);
	}

	public void registerEditor(Class<?> type, JTreeTableEditorComponent editor) {
		typeToEditor.put(type, editor);
	}

	public void registerEditor(Object key, JTreeTableEditorComponent editor) {
		nameToEditor.put(key, editor);
	}

	public synchronized void registerEditor(Class<?> type, Class<?> editorClass) {
		try {
			registerEditor(type, (JTreeTableEditorComponent) editorClass.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void registerEditor(Object key, Class<?> editorClass) {
		try {
			registerEditor(key, (JTreeTableEditorComponent) editorClass.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void unregisterRenderer(Class<?> type) {
		typeToRenderer.remove(type);
	}

	public void unregisterRenderer(Object key) {
		nameToRenderer.remove(key);
	}

	public void unregisterEditor(Class<?> type) {
		typeToEditor.remove(type);
	}

	public void unregisterEditor(Object key) {
		nameToEditor.remove(key);
	}

	public JTreeTableRendererComponent getRenderer(Class<?> type) {
		return typeToRenderer.get(type);
	}

	public JTreeTableRendererComponent getRenderer(Object key) {
		return nameToRenderer.get(key);
	}

	public JTreeTableEditorComponent getEditor(Class<?> type) {
		return typeToEditor.get(type);
	}

	public JTreeTableEditorComponent getEditor(Object key) {
		return nameToEditor.get(key);
	}

	private void registerDefaultRenderers() {
		unregisterDefaultRenderers();
	}

	private void registerDefaultEditors() {
		unregisterDefaultEditors();
		registerEditor(String.class, JTreeTableTextEditorComponent.class);
		registerEditor(boolean.class, JTreeTableBooleanEditorComponent.class);
		registerEditor(Boolean.class, JTreeTableBooleanEditorComponent.class);
		registerEditor(short.class, JTreeTableNumberEditorComponent.ShortEditorComponent.class);
		registerEditor(Short.class, JTreeTableNumberEditorComponent.ShortEditorComponent.class);
		registerEditor(int.class, JTreeTableNumberEditorComponent.IntegerEditorComponent.class);
		registerEditor(Integer.class, JTreeTableNumberEditorComponent.IntegerEditorComponent.class);
		registerEditor(long.class, JTreeTableNumberEditorComponent.LongEditorComponent.class);
		registerEditor(Long.class, JTreeTableNumberEditorComponent.LongEditorComponent.class);
		registerEditor(double.class, JTreeTableNumberEditorComponent.DoubleEditorComponent.class);
		registerEditor(Double.class, JTreeTableNumberEditorComponent.DoubleEditorComponent.class);
		registerEditor(float.class, JTreeTableNumberEditorComponent.FloatEditorComponent.class);
		registerEditor(Float.class, JTreeTableNumberEditorComponent.FloatEditorComponent.class);
	}

	public void unregisterDefaultRenderers() {
		typeToRenderer.clear();
		nameToRenderer.clear();
	}

	public void unregisterDefaultEditors() {
		typeToEditor.clear();
		nameToEditor.clear();
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
