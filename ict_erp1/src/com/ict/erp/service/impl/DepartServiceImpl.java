
package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.DepartDAO;
import com.ict.erp.dao.impl.DepartDAOImpl;
import com.ict.erp.service.DepartService;
import com.ict.erp.vo.DepartInfo;
import com.ict.erp.vo.PageInfo;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	@Override
	public List<DepartInfo> getDepartInfoList(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			PageInfo pi = di.getPi();
			pi.initPage(ddao.totalCount("depart_info"));
			return ddao.selectDepartInfoList(di);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}

	@Override
	public DepartInfo getDepartInfo(int diNum) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepartInfo(diNum);
		}catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String,Object>();
		try {
			int cnt = ddao.insertDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패하였습니다.");
			
			if(cnt==1) {
				rMap.put("msg","성공하였습니다.");
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String,Object>();
		try {
			int cnt = ddao.updateDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패하였습니다.");
			if(cnt==1) {
				rMap.put("msg","성공하였습니다.");
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteDepartInfo(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		Map<String, Object> rMap = new HashMap<String,Object>();
		try {
			int cnt = ddao.deleteDepartInfo(di);
			rMap.put("cnt", cnt);
			rMap.put("msg", "실패하였습니다.");
			if(cnt==1) {
				rMap.put("msg","성공하였습니다.");
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		return rMap;
	}

	@Override
	public List<DepartInfo> getDepartInfoNonePageList(DepartInfo di) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepartInfoNonePageList(di);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}