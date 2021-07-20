package com.myboot01.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboot01.web.service.ReplyService;
import com.myboot01.web.vo.ReplyVO;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
    
	@ResponseBody
    @RequestMapping("/replyInsert")
	public String boardInsert(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	HttpSession session=request.getSession(false);
    	
    	if(session==null) {
    		
    		return "로그인을 해주세요.";
    		
    	}
    	
    	
    	else {	
    		
    	
         String rno=String.valueOf(Integer.parseInt(replyService.selectNextRno())+2);
         System.out.println(rno);
    	
    	String bno=request.getParameter("bno");
	    String content=request.getParameter("replyContent");
	   
    	String writer=(String)session.getAttribute("id");

	  
	    ReplyVO vo=new ReplyVO(bno,rno,content,writer,null,"0",0);
	    
	   
	    try {
	    	System.out.println(vo);
		   replyService.insertReply(vo);
		   
		   return "댓글이 등록되었습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			return "댓글 등록에 실패하였습니다.";
		}

	    
    	}
	
	    }
	
	
	
	@ResponseBody
    @RequestMapping("/deleteReply")
	public String deleteMember(HttpServletRequest request,HttpServletResponse response){
		 try {
			 String rno=request.getParameter("rno"); 
			replyService.deleteReply(rno);
			   return "댓글을 삭제하였습니다.";
			} catch (DataAccessException e) {
				e.printStackTrace();
				
				return "댓글 삭제에 실패하였습니다.";
			}
	}
	     
	@ResponseBody
    @RequestMapping("/updateReply")
	public String updateReply(HttpServletRequest request,HttpServletResponse response){
		 try {
			 
			    String rno=request.getParameter("rno");
			    
			 
			    String content=request.getParameter("replyContent");
			    System.out.println(content);
			   
			    
			    ReplyVO vo=new ReplyVO(null,rno,content,null,null,"0",0);

			    replyService.updateReply(vo);
			    return "댓글 수정완료";
			} catch (DataAccessException e) {
				e.printStackTrace();
				return "댓글 수정실패";
			}
	}
	
	@ResponseBody
    @RequestMapping("/selectAllreplyList")
	public String selectAllMemberList(HttpServletRequest request,HttpServletResponse response){
		 try {
			 String bno=request.getParameter("bno");
            
			  List<ReplyVO>list=replyService.selectAllReply(bno);
			  
			  JSONArray jsonArray=new JSONArray();
			  for(ReplyVO vo :list) {
				  JSONObject o=new JSONObject();
				  o.put("bno", vo.getBno());
				  o.put("rno", vo.getRno());
				  o.put("content", vo.getContent());
				  o.put("level", vo.getLevel());
				  System.out.println(vo.getLevel());
				  o.put("writer", vo.getWriter());
				  o.put("parentNo",vo.getParentNo());
				  o.put("writeDate", vo.getWriteDate().toString());
				  
				  jsonArray.add(o);
			  }
			  return jsonArray.toJSONString();
			 
			 
			   
			} catch (DataAccessException e) {
				
				e.printStackTrace();
				return "댓글 불러오기에 실패하였습니다.";
			}
	}
	
	
	
	
}
