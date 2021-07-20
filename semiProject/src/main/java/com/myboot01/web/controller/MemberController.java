package com.myboot01.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboot01.web.service.MemberService;
import com.myboot01.web.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;	
	
	@ResponseBody
    @RequestMapping("/memberInsert")
	public String memberInsert(HttpServletRequest request,HttpServletResponse response) {
		
	    String id=request.getParameter("id");
	    String pw=request.getParameter("pw");
	    String name=request.getParameter("name");
	    
	    MemberVO vo=new MemberVO(id,pw,name);
	    System.out.println(vo);
	    try {
		    memberService.insertMember(vo);
		    return "회원가입 되었습니다.";
		} catch (DataAccessException e) {
			return "회원가입에 실패하셨습니다.";
		}

	    
	   
	    }
	@ResponseBody
    @RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
    	session.invalidate();
    	return "정상적으로 로그아웃 되셨습니다.";
	}
	
	@ResponseBody
    @RequestMapping("/checkId")
	public String checkId(HttpServletRequest request,HttpServletResponse response){
		String id=request.getParameter("id");
		MemberVO vo=new MemberVO(id,null,null);
		 JSONObject json=new JSONObject();
		 json.put("ch",String.valueOf(memberService.checkid(vo)));
		 
		try {
		    return json.toJSONString();
		} catch (DataAccessException e) {
			return "중복확인에 실패하셨습니다.";
		}
	}
	
	
	
	@ResponseBody
    @RequestMapping("/loginById")
	public String loginById(HttpServletRequest request,HttpServletResponse responseO) {
    	
		 String id=request.getParameter("id");
		 String pw=request.getParameter("pw");
		 JSONObject json=new JSONObject();
		 MemberVO memberVO=new MemberVO(id,pw,null); 
		try {
    	
    		 
    		 memberVO =memberService.loginById(memberVO);
    		 if(memberVO!=null) {
    		 HttpSession session=request.getSession();
		     session.setAttribute("id",id);
    		 
    		 json.put("id",id);
    		}
    		 else {
    			 json.put("msg", "아이디 또는 비밀번호를 확인해주세요.");
    			 
    		 }
    		 
 		     return json.toJSONString();
 		} catch (DataAccessException e) {
 			e.printStackTrace();
 			json.put("msg", "로그인실패");
 			return json.toJSONString();
 		}
    } 
	@ResponseBody
    @RequestMapping("/deleteMember")
	public String deleteMember(HttpServletRequest request,HttpServletResponse response){
		 try {
			 String id=request.getParameter("id"); 
			 memberService.deleteMember(id);
			   return "회원삭제완료";
			} catch (DataAccessException e) {
				e.printStackTrace();
				return "회원삭제실패";
			}
	}
	     
	@ResponseBody
    @RequestMapping("/updateMember")
	public String updateMember(HttpServletRequest request,HttpServletResponse response){
		 try {
			    String id=request.getParameter("id");
			    String pw=request.getParameter("pw");
			    String name=request.getParameter("name");
			    String address=request.getParameter("address");
			    
			    MemberVO memberVO=new MemberVO(id,pw,name,address,0);

			 memberService.updateMember(memberVO);
			    return "회원정보 수정완료";
			} catch (DataAccessException e) {
				e.printStackTrace();
				return "회원정보 수정실패";
			}
	}
	
    @RequestMapping("/selectAllMemberList")
	public String selectAllMemberList(HttpServletRequest request,HttpServletResponse response){
		 try {
			 
			  List<MemberVO>list=memberService.selectAllMemberList();
			  return "ok.jsp";
			 
			 
			   
			} catch (DataAccessException e) {
				
				e.printStackTrace();
				return "fail.jsp";
			}
	}
	
	
	
	
}
