
package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.DepartInfo;

public interface DepartService {
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException;
	public List<DepartInfo> getDepartInfoNonePageList(DepartInfo di) throws SQLException;
	public DepartInfo getDepartInfo(int diNum) throws SQLException;
	public Map<String,Object> insertDepartInfo(DepartInfo di)throws SQLException;
	public Map<String,Object> updateDepartInfo(DepartInfo di)throws SQLException;
	public Map<String,Object> deleteDepartInfo(DepartInfo di)throws SQLException;
}