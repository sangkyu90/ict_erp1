
package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonDAOImpl{
	protected Connection con;
	protected Statement stmt = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	protected void close() throws SQLException {
		if(rs!=null) {
			rs.close();
		}
		if(ps!=null) {
			ps.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
	}
	public int totalCount(String tableName) throws SQLException {
		String sql = "select count(1) from " + tableName;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return 0;
	}

}