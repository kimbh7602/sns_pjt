package edu.ssafy.boot.dto;

public class ProductVo {
	private int pid;
	private String pname;
	private int pprice;
	private int ploads;
	public ProductVo() {
		super();
	}
	public ProductVo(int pid, String pname, int pprice, int ploads) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.ploads = ploads;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPloads() {
		return ploads;
	}
	public void setPloads(int ploads) {
		this.ploads = ploads;
	}
	@Override
	public String toString() {
		return "ProductVo [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", ploads=" + ploads + "]";
	}
	
	
}
