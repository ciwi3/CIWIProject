package com.ciwi.vo;

import java.util.Date;

public class NoticeBoardVO {

	private int no;
	private String id;
	private String subject;
	private String content;
	private Date regdate;
	private int hit;
	private String dbday;
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

}
