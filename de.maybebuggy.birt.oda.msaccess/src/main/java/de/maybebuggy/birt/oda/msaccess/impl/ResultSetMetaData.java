/*
 *************************************************************************
 * Copyright (c) 2010 <<Your Company Name here>>
 *  
 *************************************************************************
 */

package de.maybebuggy.birt.oda.msaccess.impl;

import java.sql.SQLException;

import org.eclipse.datatools.connectivity.oda.IResultSetMetaData;
import org.eclipse.datatools.connectivity.oda.OdaException;

import com.healthmarketscience.jackcess.Column;
import com.healthmarketscience.jackcess.Table;

/**
 * Implementation class of IResultSetMetaData for an ODA runtime driver. <br>
 * For demo purpose, the auto-generated method stubs have hard-coded
 * implementation that returns a pre-defined set of meta-data and query results.
 * A custom ODA driver is expected to implement own data source specific
 * behavior in its place.
 */
public class ResultSetMetaData implements IResultSetMetaData {
	private Table table;

	public ResultSetMetaData(Table table) {
		this.table = table;
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnCount
	 * ()
	 */
	public int getColumnCount() throws OdaException {
		return table.getColumnCount();
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnName
	 * (int)
	 */
	public String getColumnName(int index) throws OdaException {
		return getColumn(index).getName();
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnLabel
	 * (int)
	 */
	public String getColumnLabel(int index) throws OdaException {
		return getColumnName(index); // default
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnType
	 * (int)
	 */
	public int getColumnType(int index) throws OdaException {
		try {
			return getColumn(index).getType().getSQLType();
		} catch (SQLException e) {
			throw new OdaException(e);
		}
	}

	public Column getColumn(int index) {
		return table.getColumns().get(index-1);
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnTypeName
	 * (int)
	 */
	public String getColumnTypeName(int index) throws OdaException {
		int nativeTypeCode = getColumnType(index);
		return Driver.getNativeDataTypeName(nativeTypeCode);
	}

	/**
	 * Return -1 for an unknown column display length 
	 * 
	 * @see org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getColumnDisplayLength(int)
	 */
	public int getColumnDisplayLength(int index) throws OdaException {
		return -1;
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getPrecision(int)
	 */
	public int getPrecision(int index) throws OdaException {
		return getColumn(index).getPrecision();
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#getScale(int)
	 */
	public int getScale(int index) throws OdaException {
		return getColumn(index).getScale();
	}

	/*
	 * @see
	 * org.eclipse.datatools.connectivity.oda.IResultSetMetaData#isNullable(int)
	 */
	public int isNullable(int index) throws OdaException {
		// TODO Auto-generated method stub
		return IResultSetMetaData.columnNullableUnknown;
	}

	public Table getTable() {
		return table;
	}

}
