package com.myboot01.web.vo;

import java.util.Date;

public class BoardVO {
	private String bno;
	private String title;
	private String content;
	private String id;
	private Date writeDate;
	private String imageFileName;
	
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(String bno, String title, String content, String id, Date writeDate,String imageFileName) {
		super();
		setBno(bno);
		setTitle(title);
		setContent(content);
		setId(id);
		this.writeDate = writeDate;
		setImageFileName(imageFileName);
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		
		if(bno!=null)
			this.bno = bno;
			else
			{
				System.out.println("게시판 번호를 입력하세요");
			}
	}
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title!=null)
			this.title = title;
			else
			{
				System.out.println("제목을 입력하세요");
			}
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		if(content!=null)
			this.content = content;
			else
			{
				System.out.println("내용을 입력하세요");
			}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id!=null)
			this.id = id;
			else
			{
		System.out.println("아이디를 입력하세요");
			}
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", id=" + id + ", writeDate="
				+ writeDate + "]";
	}
	
	
 
}
