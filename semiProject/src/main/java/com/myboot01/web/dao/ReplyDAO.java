package com.myboot01.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myboot01.web.vo.ReplyVO;

@Mapper
@Repository("ReplyDAO")
public interface ReplyDAO {

	public void insertReply(ReplyVO replyVO) throws DataAccessException; 
	
	public String selectNextRno()throws DataAccessException;
	
	public void deleteReply(String rno)throws DataAccessException;	
	
	public void updateReply(ReplyVO replyVO)throws DataAccessException;	
	public List<ReplyVO> selectAllReply(String bno)throws DataAccessException;	
	                     
	
	
}
