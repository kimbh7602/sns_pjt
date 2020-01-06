package edu.ssafy.boot.dto;

public class FollowVo {
	private String follower_id;
	private String follow_id;
	public FollowVo() {
		super();
	}
	public FollowVo(String follower_id, String follow_id) {
		super();
		this.follower_id = follower_id;
		this.follow_id = follow_id;
	}
	public String getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(String follower_id) {
		this.follower_id = follower_id;
	}
	public String getFollow_id() {
		return follow_id;
	}
	public void setFollow_id(String follow_id) {
		this.follow_id = follow_id;
	}
	@Override
	public String toString() {
		return "FollowVo [follower_id=" + follower_id + ", follow_id=" + follow_id + "]";
	}
	
	
}
