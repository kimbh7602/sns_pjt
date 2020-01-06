package edu.ssafy.boot.dto;

public class UserVo {
	private String user_id;
	private String password;
	private String interest;
	public UserVo() {
		super();
	}
	public UserVo(String user_id, String password, String interest) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.interest = interest;
	}
	public UserVo(String user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "UserVo [user_id=" + user_id + ", password=" + password + ", interest=" + interest + "]";
	}
	
	
}
