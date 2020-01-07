package a00123456.lab.data;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

public class DBBean {
	private String queryString = "empty";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet queryResults = null;
	private ResultSetMetaData meta = null;
	private Vector<Vector<String>> vRows = null;
	
	private DataSource dataSource;
	
	public DBBean( DataSource ds ) {
		this.dataSource = ds;
	}
	
	
	public DBBean() {
	}

	
	public void connect() throws SQLException {
		connection = dataSource.getConnection();
	}
	
	public void connect(String driver, String url, String user, String pass) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String qs) {

		queryString = qs;
	}

	public void generateResultSet() {
		vRows = new Vector<Vector<String>>();
		int numCols;

		try {
			statement = connection.createStatement();

			queryResults = statement.executeQuery(queryString);
			meta = queryResults.getMetaData();
			numCols = meta.getColumnCount();

			while (queryResults.next()) {
				Vector<String> vOneRow = new Vector<String>();
				for (int ndx = 1; ndx <= numCols; ndx++) {
					vOneRow.addElement(queryResults.getString(ndx));
				}
				vRows.addElement(vOneRow);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void setResultSet(ResultSet rs) {
		queryResults = rs;
	}

	public Vector<Vector<String>> getResults() {

		return vRows;
	}

	public Vector<String> getColumnNames() throws SQLException {

		Vector<String> columnNames = new Vector<String>();
		for (int i = 0; i < meta.getColumnCount(); i++) {
			columnNames.add(meta.getColumnName(i + 1));
		}

		return columnNames;
	}

	public void cleanUp() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
