package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;


import com.ict.erp.vo.MenuInfo;

public interface MenuService {
	public List<MenuInfo> selectMenuList(MenuInfo menu) throws SQLException;

	public MenuInfo selectMenu(MenuInfo menu) throws SQLException;

	public int insertMenu(MenuInfo menu) throws SQLException;

	public int updateMenu(MenuInfo menu) throws SQLException;

	public int deleteMenu(MenuInfo menu) throws SQLException;
}
