package com.ict.erp.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MenuDAO;
import com.ict.erp.service.MenuService;
import com.ict.erp.service.impl.MenuServiceImpl;
import com.ict.erp.vo.MenuInfo;

public class MenuDAOImpl extends CommonDAOImpl implements MenuDAO {

	@Override
	public int totalCount(String tableName) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MenuInfo> selectMenuList(MenuInfo menu) throws SQLException {
		String sql = "select * from menu_info";
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuInfo mei = new MenuInfo(rs.getLong("meiNum"), rs.getString("meiName"), rs.getLong("meiPrice"),
						rs.getString("meiDesc"));
				menuList.add(mei);
			}
			return menuList;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	

	@Override
	public MenuInfo selectMenu(MenuInfo menu) throws SQLException {
		String sql = "select * from menu_info where meiNum=?";
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, menu.getMeiNum());
			rs = ps.executeQuery();
			while (rs.next()) {
				MenuInfo mei = new MenuInfo(rs.getLong("meiNum"), rs.getString("meiName"), rs.getLong("meiPrice"),
						rs.getString("meiDesc"));
				return mei;
			}
			return null;
		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int insertMenu(MenuInfo menu) throws SQLException {
		String sql = "insert into menu_info(meiNum, meiName ,meiPrice,meiDesc)";
		sql += " values(seq_meiNum.nextval,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu.getMeiName());
			ps.setLong(2, menu.getMeiPrice());
			ps.setString(3, menu.getMeiDesc());

			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int updateMenu(MenuInfo menu) throws SQLException {
		String sql = "update Menu_info set \r\n" + "MEINAME=?,\r\n" + "MEIPRICE=?,\r\n" + "MEIDESC=?"
				+ " where MEINUM=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu.getMeiName());
			ps.setLong(2, menu.getMeiPrice());
			ps.setString(3, menu.getMeiDesc());
			ps.setLong(4, menu.getMeiNum());
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}

	@Override
	public int deleteMenu(MenuInfo menu) throws SQLException {
		String sql = "delete from menu_info where meiNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, menu.getMeiNum());
			return ps.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} finally {
			close();
		}
	}
}
