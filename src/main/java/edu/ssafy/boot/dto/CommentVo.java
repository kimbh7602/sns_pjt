package edu.ssafy.boot.dto;

public class CommentVo {
	private int comment_id;
	private int content_id;
	private String user_id;
	private String target_id;
	private String comment_val;
	
	public CommentVo() {
		super();
	}

	public CommentVo(int comment_id, int content_id, String user_id, String target_id, String comment_val) {
		super();
		this.comment_id = comment_id;
		this.content_id = content_id;
		this.user_id = user_id;
		this.target_id = target_id;
		this.comment_val = comment_val;
	}

	public CommentVo(int comment_id, int content_id, String user_id, String comment_val) {
		super();
		this.comment_id = comment_id;
		this.content_id = content_id;
		this.user_id = user_id;
		this.comment_val = comment_val;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getContent_id() {
		return content_id;
	}

	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public String getComment_val() {
		return comment_val;
	}

	public void setComment_val(String comment_val) {
		this.comment_val = comment_val;
	}

	@Override
	public String toString() {
		return "CommentsVo [comment_id=" + comment_id + ", content_id=" + content_id + ", user_id=" + user_id
				+ ", target_id=" + target_id + ", comment_val=" + comment_val + "]";
	}
	
	
}
