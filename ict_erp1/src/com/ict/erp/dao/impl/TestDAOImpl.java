package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TestDAO;
import com.ict.erp.vo.TestInfo;

public class TestDAOImpl implements TestDAO {

	@Override
	public List<TestInfo> selectList(TestInfo ti) throws SQLException {
		try {
			Connection con = DBCon.getCon();
			String sql = "select * from test_info ";
			if(ti!=null) {
				if(ti.getTiNum()!=0) {
					sql += " where tiNum=?";
				}else if(ti.getTiId()!=null) {
					sql += " where tiId like '%' || ? || '%'";
				}else if(ti.getTiName()!=null) {
					sql += " where tiName like '%' || ? || '%'";
				}else if(ti.getTiText()!=null) {
					sql += " where tiText like '%' || ? || '%'";
				}
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if(ti!=null) {
				if(ti.getTiNum()!=0) {
					ps.setInt(1, ti.getTiNum());
				}else if(ti.getTiId()!=null) {
					ps.setString(1, ti.getTiId());
				}else if(ti.getTiName()!=null) {
					ps.setString(1, ti.getTiName());
				}else if(ti.getTiText()!=null) {
					ps.setString(1, ti.getTiText());
				}
			}
			ResultSet rs = ps.executeQuery();
			List<TestInfo> tiList = new ArrayList<TestInfo>();
			while(rs.next()) {
				ti = new TestInfo(rs.getInt("tiNum"),rs.getString("tiId"), rs.getString("tiName"), rs.getString("tiText"));
				tiList.add(ti);
			}
			return tiList;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public TestInfo selectTestInfo(int tiNum) throws SQLException {
		try {
			Connection con = DBCon.getCon();
			String sql = "select * from test_info where tiNum=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, tiNum);
			ResultSet rs = ps.executeQuery();
			TestInfo ti = null;
			if(rs.next()) {
				ti = new TestInfo(rs.getInt("tiNum"),rs.getString("tiId"), rs.getString("tiName"), rs.getString("tiText"));
			}
			return ti;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
