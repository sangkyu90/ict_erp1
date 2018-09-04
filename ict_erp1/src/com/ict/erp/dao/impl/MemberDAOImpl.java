
package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MemberDAO;
import com.ict.erp.vo.MemberInfo;

public class MemberDAOImpl extends CommonDAOImpl implements MemberDAO {

	@Override
	public List<MemberInfo> selectMiList(MemberInfo mi) throws SQLException {
		String sql = "SELECT mi.*, di.diname, li.liname from "
				+ "MEMBER_INFO mi, DEPART_INFO di, LEVEL_INFO li "
				+ "where mi.dicode = di.dicode "
				+ "and mi.LILEVEL = li.LIlevel ";
		List<MemberInfo> miList = new ArrayList<MemberInfo>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberInfo mmi = new MemberInfo();
				mmi.setDiCode(rs.getString("diCode"));
				mmi.setLiLevel(rs.getLong("liLevel"));
				mmi.setMiAddress1(rs.getString("miAddress1"));
				mmi.setMiAddress2(rs.getString("miAddress2"));
				mmi.setMiDesc(rs.getString("miDesc"));
				mmi.setMiEmail(rs.getString("miEmail"));
				mmi.setMiId(rs.getString("miId"));
				mmi.setMiName(rs.getString("miName"));
				mmi.setMiNum(rs.getLong("miNum"));
				mmi.setMiPhone(rs.getString("miPhone"));
				mmi.setMiPwd(rs.getString("miPwd"));
				mmi.setMiZipcode(rs.getString("miZipcode"));
				mmi.setLiName(rs.getString("liName"));
				mmi.setDiName(rs.getString("diName"));
				miList.add(mmi); 
			}
			return miList;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAOImpl();
		mdao.setConnection(DBCon.getCon());
		try {
			if(mdao.selectMiList(null).size()==0) {
				System.out.println("성공");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMi(MemberInfo mi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberInfo getMemberInfo(int miNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}