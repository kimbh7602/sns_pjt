package edu.ssafy.boot.dto;

public class ContentVo {
	private int content_id;
	private int share_cid;
	private String content_title;
	private String content_val;
	private String user_id;
	private String timestamp;
	
	public ContentVo() {
		super();
	}
	
	public ContentVo(int content_id, int share_cid, String content_title, String content_val, String user_id,
			String timestamp) {
		super();
		this.content_id = content_id;
		this.share_cid = share_cid;
		this.content_title = content_title;
		this.content_val = content_val;
		this.user_id = user_id;
		this.timestamp = timestamp;
	}
	
	public ContentVo(int content_id, String content_title, String content_val, String user_id,
			String timestamp) {
		super();
		this.content_id = content_id;
		this.content_title = content_title;
		this.content_val = content_val;
		this.user_id = user_id;
		this.timestamp = timestamp;
	}
	
	public int getContent_id() {
		return content_id;
	}
	public void setContent_id(int content_id) {
		this.content_id = content_id;
	}
	public int getShare_cid() {
		return share_cid;
	}
	public void setShare_cid(int share_cid) {
		this.share_cid = share_cid;
	}
	public String getContent_title() {
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public String getContent_val() {
		return content_val;
	}
	public void setContent_val(String content_val) {
		this.content_val = content_val;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ContentsVo [content_id=" + content_id + ", share_cid=" + share_cid + ", content_title=" + content_title
				+ ", content_val=" + content_val + ", user_id=" + user_id + ", timestamp=" + timestamp + "]";
	}
	
	
}
