package com.ciwi.vo;
/*
 *    (	"RNO" NUMBER, 
	"CATEGORY_NO" NUMBER, 
	"CONTENT_NO" NUMBER, 
	"DATETIME" DATE, 
	"RATING" NUMBER, 
	"RLIKE" NUMBER, 
	"RDISLIKE" NUMBER, 
	"REVIEW" VARCHAR2(600 BYTE)
 * */

import java.sql.Date;

public class ReviewVO {
	private int rno;
	private int category_no;
	private int content_no;
	private String memid;
	private int memno;
	private Date datetime;
	private double rating;
	private int rlike;
	private int rdislike;
	private String rtext;
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getContent_no() {
		return content_no;
	}
	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getRlike() {
		return rlike;
	}
	public void setRlike(int rlike) {
		this.rlike = rlike;
	}
	public int getRdislike() {
		return rdislike;
	}
	public void setRdislike(int rdislike) {
		this.rdislike = rdislike;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
}
