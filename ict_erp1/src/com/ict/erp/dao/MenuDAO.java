package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MenuInfo;

public interface MenuDAO extends CommonDAO{
   public List<MenuInfo> selectMenuList(MenuInfo menu) throws SQLException;
    public MenuInfo selectMenu(MenuInfo menu)throws SQLException;
    public int insertMenu(MenuInfo menu) throws SQLException;
    public int updateMenu(MenuInfo menu)throws SQLException;
    public int deleteMenu(MenuInfo menu)throws SQLException;
}