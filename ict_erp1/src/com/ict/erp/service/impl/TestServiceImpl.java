package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.dao.TestDAO;
import com.ict.erp.dao.impl.TestDAOImpl;
import com.ict.erp.service.TestService;
import com.ict.erp.vo.TestInfo;

public class TestServiceImpl implements TestService {
	private TestDAO tdao = new TestDAOImpl();
	@Override
	public List<TestInfo> getTestList(TestInfo ti) throws SQLException {
		// TODO Auto-generated method stub
		return tdao.selectList(ti);
	}
	
	@Override
	public TestInfo getTestInf(int tiNum) throws SQLException {
		// TODO Auto-generated method stub
		return tdao.selectTestInfo(tiNum);
	}

}
