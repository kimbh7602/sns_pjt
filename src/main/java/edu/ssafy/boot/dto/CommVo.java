package edu.ssafy.boot.dto;

public class CommVo {
	private int cid;
	private String ccontent;
	private String user_id;
	private int bid;
	public CommVo() {
		super();
	}
	
	public CommVo(String ccontent, String user_id, int bid) {
		super();
		this.ccontent = ccontent;
		this.user_id = user_id;
		this.bid = bid;
	}

	public CommVo(int cid, String ccontent, String user_id, int bid) {
		super();
		this.cid = cid;
		this.ccontent = ccontent;
		this.user_id = user_id;
		this.bid = bid;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
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
	@Override
	public String toString() {
		return "CommVo [cid=" + cid + ", ccontent=" + ccontent + ", user_id=" + user_id + ", bid=" + bid + "]";
	}
	
	
}
