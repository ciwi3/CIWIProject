package com.ciwi.vo;

public class MovieGenreVO {
	private int movie_no;
	private String movie_genre;
	private ShowGenreVO sv = new ShowGenreVO();
	public ShowGenreVO getSv() {
		return sv;
	}

	public void setSv(ShowGenreVO sv) {
		this.sv = sv;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_genre() {
		return movie_genre;
	}

	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
}
