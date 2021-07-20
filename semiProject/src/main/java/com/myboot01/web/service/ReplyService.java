package com.myboot01.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myboot01.web.dao.ReplyDAO;
import com.myboot01.web.vo.ReplyVO;

@Service
public class ReplyService {

	@Autowired
	ReplyDAO replyDAO;
	
	public void insertReply(ReplyVO replyVO) throws DataAccessException{
		
		replyDAO.insertReply(replyVO);
	}
	
	public void deleteReply(String rno)throws DataAccessException{
		replyDAO.deleteReply(rno);
	}
	     
	
	public void updateReply(ReplyVO replyVO)throws DataAccessException{
		replyDAO.updateReply(replyVO);
	}
	
	public List<ReplyVO> selectAllReply(String bno)throws DataAccessException{
		return replyDAO.selectAllReply(bno);
	}
	
	public String selectNextRno()throws DataAccessException{
		return replyDAO.selectNextRno();
	}
	
	
}
