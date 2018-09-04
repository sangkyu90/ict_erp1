package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.LevelInfo;

public interface LevelService {
	public List<LevelInfo> getLiList(LevelInfo li)throws SQLException ;
	public Map<String,Object> insertNUpdateLiList(Map<String,List<LevelInfo>> liList) throws SQLException;
	public Map<String,Object> deleteLiList(int[] liNums) throws SQLException;
}
