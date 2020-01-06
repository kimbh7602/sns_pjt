package edu.ssafy.boot.dto;

public class NoticeVo {
	private int nid;
	private String ntitle;
	private String ncontent;
	private int ncount;
	public NoticeVo() {
		super();
	}
	public NoticeVo(int nid, String ntitle, String ncontent, int ncount) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;	
		this.ncount = ncount;
	}
	
	public NoticeVo(String ntitle, String ncontent) {
		this.ntitle= ntitle;
		this.ncontent = ncontent;
	}
	public NoticeVo(int nid, String ntitle, String ncontent) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public int getNcount() {
		return ncount;
	}
	public void setNcount(int ncount) {
		this.ncount = ncount;
	}
	@Override
	public String toString() {
		return "noticeVo [nid=" + nid + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ncount=" + ncount + "]";
	}
	
	
	
}
