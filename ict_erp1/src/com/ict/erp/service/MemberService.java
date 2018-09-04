
package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.vo.MemberInfo;

public interface MemberService {
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException;

	public MemberInfo selectMi(MemberInfo mi) throws SQLException;

	public Map<String,Object> insertMi(MemberInfo mi) throws SQLException;

	public Map<String,Object> updateMi(MemberInfo mi) throws SQLException;

	public Map<String,Object> deleteMi(MemberInfo mi) throws SQLException;
}