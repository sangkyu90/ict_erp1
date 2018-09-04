package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.dao.impl.MusicDAOImpl;
import com.ict.erp.service.MusicService;
import com.ict.erp.vo.MusicChart;

public class MusicServiceImpl implements MusicService {
	private MusicDAO mdao = new MusicDAOImpl();
	@Override
	public List<MusicChart> selectMusicList(MusicChart menu) throws SQLException {
		try {
			mdao.setConnection(DBCon.getCon());
			return mdao.selectMusicList(menu);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public MusicChart selectMusic(MusicChart menu) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMusic(MusicChart menu) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMusic(MusicChart menu) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMusic(MusicChart menu) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}