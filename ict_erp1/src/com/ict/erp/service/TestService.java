package com.ict.erp.service;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TestInfo;

public interface TestService {

	public List<TestInfo> getTestList(TestInfo ti) throws SQLException;
	public TestInfo getTestInf(int tiNum) throws SQLException;
}
	