package com.ciwi.vo;

import java.util.*;

public class FestivalVO {
	private int fno;
	private String place;
	private String subject;
	private String poster;
	private String fdate;
	private String host;
	private String homepage;
	private String tel;
	private String showtime;
	private int flike;
	private int concert_genre;
	private int category_no;
	private int area_no;
	
	
	public int getConcert_genre() {
		return concert_genre;
	}
	public void setConcert_genre(int concert_genre) {
		this.concert_genre = concert_genre;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getArea_no() {
		return area_no;
	}
	public void setArea_no(int area_no) {
		this.area_no = area_no;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public int getFlike() {
		return flike;
	}
	public void setFlike(int flike) {
		this.flike = flike;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	
	
}