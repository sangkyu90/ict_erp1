package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.dao.MusicDAO;
import com.ict.erp.vo.MusicChart;

public class MusicDAOImpl extends CommonDAOImpl implements MusicDAO {
	private static String SELECT_MUSIC_LIST = "select * from music_chart ";
	@Override
	public List<MusicChart> selectMusicList(MusicChart menu) throws SQLException {
		try {
			ps = con.prepareStatement(SELECT_MUSIC_LIST);
			rs = ps.executeQuery();
			return IBean.convertList(rs, MusicChart.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
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