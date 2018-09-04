package com.ict.erp.dao;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.vo.TicketMovie;

public interface TicketMovieDAO extends CommonDAO{
	public List<TicketMovie> selectTicketMovieList(TicketMovie tm) throws SQLException;
	public TicketMovie selectTicketMovie(TicketMovie tm) throws SQLException;
	public int insertTicketMovie(TicketMovie tm) throws SQLException;
	public int updateTicketMovie(TicketMovie tm) throws SQLException;
	public int deleteTicketMovie(TicketMovie tm) throws SQLException;
}