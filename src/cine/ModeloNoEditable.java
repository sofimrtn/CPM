package cine;

import javax.swing.table.DefaultTableModel;

public class ModeloNoEditable extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloNoEditable(Object[] columnas, int rows) {
		super(columnas, rows);
	}
	
	@Override
	public boolean isCellEditable(int columna, int fila) {
		return false;
	}

}
