package com.myboot01.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myboot01.web.dao.BoardDAO;
import com.myboot01.web.vo.BoardVO;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	public void insertBoard(BoardVO boardVO) throws DataAccessException{
		
		boardDAO.insertBoard(boardVO);
	}
	
	public void deleteBoard(String bno)throws DataAccessException{
		boardDAO.deleteBoard(bno);
	}
	     
	
	public void updateBoard(BoardVO boardVO)throws DataAccessException{
		boardDAO.updateBoard(boardVO);
	}
	
	public List<BoardVO> selectAllBoardList()throws DataAccessException{
		return boardDAO.selectAllBoardList();
	}
	
	public String selectNextBno()throws DataAccessException{
		return boardDAO.selectNextBno();
	}
	public BoardVO selectBoard(String bno)throws DataAccessException{
		return boardDAO.selectBoard(bno);
	}
	
}
