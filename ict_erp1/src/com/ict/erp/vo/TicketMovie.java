
package com.ict.erp.vo;

public class TicketMovie {
	private Integer tmNum;
	private String tmName;
	private Integer tmPrice;
	private String tmStartdat;
	private String tmEnddat;
	private String tmCredat;
	private String tmDesc;
	private Integer tmCnt;
	private String tmImg;
	public TicketMovie() {}
	
	public TicketMovie(Integer tmNum, String tmName, Integer tmPrice, String tmStartdat, String tmEnddat,
			String tmCredat, String tmDesc, Integer tmCnt, String tmImg) {
		super();
		this.tmNum = tmNum;
		this.tmName = tmName;
		this.tmPrice = tmPrice;
		this.tmStartdat = tmStartdat;
		this.tmEnddat = tmEnddat;
		this.tmCredat = tmCredat;
		this.tmDesc = tmDesc;
		this.tmCnt = tmCnt;
		this.tmImg = tmImg;
	}

	public String getTmStartdat() {
		return tmStartdat;
	}

	public void setTmStartdat(String tmStartdat) {
		this.tmStartdat = tmStartdat;
	}

	public String getTmEnddat() {
		return tmEnddat;
	}

	public void setTmEnddat(String tmEnddat) {
		this.tmEnddat = tmEnddat;
	}

	public Integer getTmNum() {
		return tmNum;
	}
	public void setTmNum(Integer tmNum) {
		this.tmNum = tmNum;
	}
	public String getTmName() {
		return tmName;
	}
	public void setTmName(String tmName) {
		this.tmName = tmName;
	}
	public Integer getTmPrice() {
		return tmPrice;
	}
	public void setTmPrice(Integer tmPrice) {
		this.tmPrice = tmPrice;
	}
	public String getTmCredat() {
		return tmCredat;
	}
	public void setTmCredat(String tmCredat) {
		this.tmCredat = tmCredat;
	}
	public String getTmDesc() {
		return tmDesc;
	}
	public void setTmDesc(String tmDesc) {
		this.tmDesc = tmDesc;
	}
	public Integer getTmCnt() {
		return tmCnt;
	}
	public void setTmCnt(Integer tmCnt) {
		this.tmCnt = tmCnt;
	}
	public String getTmImg() {
		return tmImg;
	}
	public void setTmImg(String tmImg) {
		this.tmImg = tmImg;
	}

	@Override
	public String toString() {
		return "TicketMovie [tmNum=" + tmNum + ", tmName=" + tmName + ", tmPrice=" + tmPrice + ", tmStartdat="
				+ tmStartdat + ", tmEnddat=" + tmEnddat + ", tmCredat=" + tmCredat + ", tmDesc=" + tmDesc + ", tmCnt="
				+ tmCnt + ", tmImg=" + tmImg + "]";
	}
	
}