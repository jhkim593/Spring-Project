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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboot01.web.service.BoardService;
import com.myboot01.web.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
    
	@ResponseBody
    @RequestMapping("/boardInsert")
	public String boardInsert(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	HttpSession session=request.getSession(false);
    	
    	if(session==null) {
    		
    		return "로그인을 해주세요.";
    		
    	}
    	else {
    		
	    String title=request.getParameter("title");
	    String content=request.getParameter("content");
   
    	String id=(String)session.getAttribute("id");

	   String bno=String.valueOf(Integer.parseInt(boardService.selectNextBno())+1);
	    BoardVO vo=new BoardVO(bno,title,content,id,null,"1");
	    try {
	    	
		    boardService.insertBoard(vo);
		   return "게시글이 등록 되었습니다";
		} catch (DataAccessException e) {
			return "게시글 등록에 실패하였습니다.";
		}

	    
    	}
	
	    }
	
	@ResponseBody
    @RequestMapping("/selectBoard")
	public String selectBoard(HttpServletRequest request,HttpServletResponse response) {
		
	    String bno=request.getParameter("bno");
	    
	   
	    try {
	    	
	    	BoardVO vo=boardService.selectBoard(bno);
	    	
		    JSONObject json=new JSONObject();
//		    model.addAttribute("boardVO",vo);
		    json.put("bno", vo.getBno());
		    json.put("content", vo.getContent());
		    json.put("id",vo.getId());
		    json.put("title", vo.getTitle());
		    json.put("imageFileName", vo.getImageFileName());
		    return json.toJSONString();
		} catch (DataAccessException e) {
			return "게시글 불러오기에 실패하였습니다.";
		}

	    
	   
	    }
	
	@ResponseBody
    @RequestMapping("/deleteBoard")
	public String deleteMember(HttpServletRequest request,HttpServletResponse response){
		 try {
			 String bno=request.getParameter("bno"); 
			 boardService.deleteBoard(bno);
			   return "게시글을 삭제하였습니다.";
			} catch (DataAccessException e) {
				e.printStackTrace();
				return "게시글 삭제에 실패하였습니다.";
			}
	}
	     
	@ResponseBody
    @RequestMapping("/updateBoard")
	public String updateMember(HttpServletRequest request,HttpServletResponse response){
		 try {
			 System.out.println("보드업데이터왓어");
			    String bno=request.getParameter("bno");
			    String title=request.getParameter("title");
			    String content=request.getParameter("content");
			    String imageFileName=request.getParameter("imageFileName");
			   
			    
			    BoardVO vo=new BoardVO(bno,title,content,null,null,null);

			    boardService.updateBoard(vo);
			    return "게시글 수정완료";
			} catch (DataAccessException e) {
				e.printStackTrace();
				return "게시글 수정실패";
			}
	}
	
	@ResponseBody
    @RequestMapping("/selectAllBoardList")
	public String selectAllMemberList(HttpServletRequest request,HttpServletResponse response){
		 try {
			 
			  List<BoardVO>list=boardService.selectAllBoardList();
			  JSONArray jsonArray=new JSONArray();
			  for(BoardVO vo :list) {
				  JSONObject o=new JSONObject();
				  o.put("bno", vo.getBno());
				  o.put("content", vo.getContent());
				  o.put("title", vo.getTitle());
				  o.put("writeDate", vo.getWriteDate().toString());
				  jsonArray.add(o);
			  }
			  return jsonArray.toJSONString();
			 
			 
			   
			} catch (DataAccessException e) {
				
				e.printStackTrace();
				return "게시물 불러오기에 실패하였습니다.";
			}
	}
	
	
	
	
}
