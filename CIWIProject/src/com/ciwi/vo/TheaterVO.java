package com.ciwi.vo;

public class TheaterVO {
	private int theater_no;
	private String theater_name;
	private int theater_total_seat;
	private String theater_loc;
	private String date_no;
	
	
	public String getDate_no() {
		return date_no;
	}
	public void setDate_no(String date_no) {
		this.date_no = date_no;
	}
	public int getTheater_no() {
		return theater_no;
	}
	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}
	public String getTheater_name() {
		return theater_name;
	}
	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}
	public int getTheater_total_seat() {
		return theater_total_seat;
	}
	public void setTheater_total_seat(int theater_total_seat) {
		this.theater_total_seat = theater_total_seat;
	}
	public String getTheater_loc() {
		return theater_loc;
	}
	public void setTheater_loc(String theater_loc) {
		this.theater_loc = theater_loc;
	}
}
