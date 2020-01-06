package edu.ssafy.boot.dto;

public class BoardVo {
	private int bid;
	private String btitle;
	private String bcontent;
	private int bcount;
	private String user_id;
	public BoardVo() {
		super();
	}
	public BoardVo(int bid, String btitle, String bcontent, int bcount, String user_id) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bcount = bcount;
		this.user_id = user_id;
	}
	
	
	public BoardVo(String btitle, String bcontent, String user_id) {
		this.btitle =btitle;
		this.bcontent = bcontent;
		this.user_id = user_id;
	}
	public BoardVo(int bid, String btitle, String bcontent, String user_id) {
		this.bid = bid;
		this.btitle = btitle; 
		this.bcontent = bcontent; 
		this.user_id = user_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	@Override
	public String toString() {
		return "BoardVo [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bcount=" + bcount + "]";
	}
	
}
