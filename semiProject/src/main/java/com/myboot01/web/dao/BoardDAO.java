package com.myboot01.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myboot01.web.vo.BoardVO;
import com.myboot01.web.vo.MemberVO;

@Mapper
@Repository("BoardDAO")
public interface BoardDAO {

	public void insertBoard(BoardVO boardVO) throws DataAccessException; 
	
	public String selectNextBno()throws DataAccessException;
	
	public void deleteBoard(String bno)throws DataAccessException;	
	
	public void updateBoard(BoardVO boardVO)throws DataAccessException;	
	public List<BoardVO> selectAllBoardList()throws DataAccessException;	
	                     
	public BoardVO selectBoard(String bno)throws DataAccessException;
	
	
	
	
}
