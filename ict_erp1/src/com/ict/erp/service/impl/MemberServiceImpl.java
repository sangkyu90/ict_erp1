package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.dao.impl.MemberDAOImpl;
import com.ict.erp.service.MemberService;
import com.ict.erp.service.MenuService;
import com.ict.erp.vo.MemberInfo;
import com.ict.erp.vo.MenuInfo;

public class MemberServiceImpl implements MemberService {
	private MemberDAO mdao = new MemberDAOImpl();
	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		// TODO Auto-generated method stub
		mdao.setConnection(DBCon.getCon());
		try {
			return mdao.selectMiList(mi);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	public static void main(String[] args) {
		MemberService ms = new MemberServiceImpl();
		try {
			if(ms.selectMiList(null).size()==0) {
				System.out.println("성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberInfo selectMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return null;
	}

}