package com.ict.erp.vo;

public class DepartInfo {
	private int diNum;
	private String diCode;
	private String diName;
	private String diDsc;
	private PageInfo pi;
	
	public PageInfo getPi() {
		return pi;
	}
	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	public DepartInfo() {}
	public DepartInfo(int diNum, String diCode, String diName, String diDsc) {
		super();
		this.diNum = diNum;
		this.diCode = diCode;
		this.diName = diName;
		this.diDsc = diDsc;
	}
	public int getDiNum() {
		return diNum;
	}
	public void setDiNum(int diNum) {
		this.diNum = diNum;
	}
	public String getDiCode() {
		return diCode;
	}
	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	public String getDiName() {
		return diName;
	}
	public void setDiName(String diName) {
		this.diName = diName;
	}
	public String getDiDsc() {
		return diDsc;
	}
	public void setDiDsc(String diDsc) {
		this.diDsc = diDsc;
	}
	@Override
	public String toString() {
		return "DepartInfo [diNum=" + diNum + ", diCode=" + diCode + ", diName=" + diName + ", diDsc=" + diDsc + "]";
	}
	
}