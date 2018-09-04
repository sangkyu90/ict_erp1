
package com.ict.erp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.LevelInfo;

public interface LevelDAO {
	public void setConnection(Connection con);
	public List<LevelInfo> selectLiList(LevelInfo li)throws SQLException ;
	public int insertLiList(List<LevelInfo> liList) throws SQLException;
	public int deleteLiList(int[] liNums) throws SQLException;
	public int updateLiList(List<LevelInfo> liList) throws SQLException;
}