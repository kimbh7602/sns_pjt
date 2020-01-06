package edu.ssafy.boot.dto;

import java.util.Date;
	

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RecipeBoardVo {
    
    @Id
    @GeneratedValue
    private int rbid;
    private String rbtitle;
    
    @Column(length = 100000000)
    private String rbcontent;
    private int rbcount; // 조회수
    private String user_id;
    private Date regDate;
    private Date updDate;
    
	public RecipeBoardVo() {
		super();
	}

	public RecipeBoardVo(int rbid, String rbtitle, String rbcontent, int rbcount, String user_id, Date regDate,
			Date updDate) {
		super();
		this.rbid = rbid;
		this.rbtitle = rbtitle;
		this.rbcontent = rbcontent;
		this.rbcount = rbcount;
		this.user_id = user_id;
		this.regDate = regDate;
		this.updDate = updDate;
	}


	public RecipeBoardVo(String rbtitle, String rbcontent, String user_id) {
		this.rbtitle= rbtitle; 
		this.rbcontent = rbcontent; 
		this.user_id = user_id;
	}

	public RecipeBoardVo(int rbid, String rbtitle, String rbcontent, String user_id) {
		this.rbid= rbid;
		this.rbtitle = rbtitle;
		this.rbcontent = rbcontent;
		this.user_id = user_id;
	}

	public RecipeBoardVo(String user_id, int rbid, String rbtitle, String rbcontent) {
		this.user_id = user_id; 
		this.rbid= rbid; 
		this.rbtitle = rbtitle; 
		this.rbcontent = rbcontent;
	}

	public int getRbid() {
		return rbid;
	}

	public void setRbid(int rbid) {
		this.rbid = rbid;
	}

	public String getRbtitle() {
		return rbtitle;
	}

	public void setRbtitle(String rbtitle) {
		this.rbtitle = rbtitle;
	}

	public String getRbcontent() {
		return rbcontent;
	}

	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}

	public int getRbcount() {
		return rbcount;
	}

	public void setRbcount(int rbcount) {
		this.rbcount = rbcount;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return "RecipeBoardVo [rbid=" + rbid + ", rbtitle=" + rbtitle + ", rbcontent=" + rbcontent + ", rbcount="
				+ rbcount + ", user_id=" + user_id + ", regDate=" + regDate + ", updDate=" + updDate + "]";
	}
    
	
}