package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.LevelDAO;
import com.ict.erp.dao.impl.LevelDAOImpl;
import com.ict.erp.service.LevelService;
import com.ict.erp.vo.LevelInfo;

public class LevelServiceImpl implements LevelService{
	private LevelDAO ldao = new LevelDAOImpl();
	@Override
	public List<LevelInfo> getLiList(LevelInfo li) throws SQLException {
		// TODO Auto-generated method stub
		return ldao.selectLiList(li);
	}

	public static void main(String[] args) {
		LevelService ls = new LevelServiceImpl();
		try {
			ls.getLiList(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> insertNUpdateLiList(Map<String, List<LevelInfo>> map) throws SQLException {
		ldao.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		
		int cnt = 0;
		try {
			cnt += ldao.insertLiList(map.get("iList"));
			cnt += ldao.updateLiList(map.get("uList"));
			DBCon.commit();
			rMap.put("cnt", cnt);
			rMap.put("msg", "정상적으로 저장되었습니다.");
		}catch(SQLException e) {
			DBCon.rollback();
			rMap.put("cnt", 0);
			rMap.put("msg", "저장이 실패하였습니다.");
			throw e;
		}finally {
			DBCon.close();
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLiList(int[] liNums) throws SQLException {
		ldao.setConnection(DBCon.getCon());
		Map<String,Object> rMap = new HashMap<String,Object>();
		try {
			int cnt = ldao.deleteLiList(liNums);
			DBCon.commit();
			rMap.put("cnt", cnt);
			rMap.put("msg", "정상적으로 삭제되었습니다.");
		}catch(SQLException e) {
			DBCon.rollback();
			rMap.put("cnt", 0);
			rMap.put("msg", "저장이 실패하였습니다.");
			throw e;
		}finally {
			DBCon.close();
		}
		return rMap;
	}
}