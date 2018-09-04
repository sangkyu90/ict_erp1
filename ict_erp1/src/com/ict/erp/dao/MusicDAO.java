package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.MusicChart;

public interface MusicDAO extends CommonDAO{
	public List<MusicChart> selectMusicList(MusicChart menu) throws SQLException;
	public MusicChart selectMusic(MusicChart menu) throws SQLException;
	public int insertMusic(MusicChart menu) throws SQLException;
	public int updateMusic(MusicChart menu) throws SQLException;
	public int deleteMusic(MusicChart menu) throws SQLException;

}