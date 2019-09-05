package com.ciwi.vo;

public class JjimVO {
	private int category_no;
	private int contents_no;
	private String id;
	private int flag;
	private CIWICategoryVO cvo = new CIWICategoryVO(); // category_no
	private ShowVO svo=new ShowVO(); // contents_no
	private MovieVO mvo=new MovieVO(); // contents_no
	private FestivalVO fvo=new FestivalVO(); // contents_no
	private MemberVO memvo=new MemberVO(); // id
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public CIWICategoryVO getCvo() {
		return cvo;
	}
	public void setCvo(CIWICategoryVO cvo) {
		this.cvo = cvo;
	}
	public ShowVO getSvo() {
		return svo;
	}
	public void setSvo(ShowVO svo) {
		this.svo = svo;
	}
	public MovieVO getMvo() {
		return mvo;
	}
	public void setMvo(MovieVO mvo) {
		this.mvo = mvo;
	}
	public FestivalVO getFvo() {
		return fvo;
	}
	public void setFvo(FestivalVO fvo) {
		this.fvo = fvo;
	}
	public MemberVO getMemvo() {
		return memvo;
	}
	public void setMemvo(MemberVO memvo) {
		this.memvo = memvo;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getContents_no() {
		return contents_no;
	}
	public void setContents_no(int contents_no) {
		this.contents_no = contents_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
