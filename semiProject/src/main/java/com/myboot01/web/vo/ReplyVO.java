package com.myboot01.web.vo;

import java.util.Date;

public class ReplyVO {
	private String bno;
	private String rno;
	private String content;
	private String writer;
	private Date writeDate;
	private String parentNo;
	private int level;
	
	
	
	public ReplyVO() {
		super();
	}
	public ReplyVO(String bno, String rno, String content, String writer, Date writeDate, String parentNo, int level) {
		super();
		setBno(bno);
		setRno(rno);
		setContent(content);
		setWriter(writer);
		this.writeDate = writeDate;
		setParentNo(parentNo);
		this.level = level;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "replyVO [bno=" + bno + ", rno=" + rno + ", content=" + content + ", writer=" + writer + ", writeDate="
				+ writeDate + ", parentNo=" + parentNo + ", level=" + level + "]";
	}
	
	
}
