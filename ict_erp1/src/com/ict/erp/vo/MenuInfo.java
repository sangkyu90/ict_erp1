package com.ict.erp.vo;

public class MenuInfo {
	
	private Long meiNum;
	private String meiName;
	private Long meiPrice;
	private String meiDesc;
	public MenuInfo() {}
	public MenuInfo(Long meiNum, String meiName, Long meiPrice, String meiDesc) {
		super();
		this.meiNum = meiNum;
		this.meiName = meiName;
		this.meiPrice = meiPrice;
		this.meiDesc = meiDesc;
	}
	@Override
	public String toString() {
		return "MemuInfo [meiNum=" + meiNum + ", meiName=" + meiName + ", meiPrice=" + meiPrice + ", meiDesc=" + meiDesc
				+ "]";
	}
	public Long getMeiNum() {
		return meiNum;
	}
	public void setMeiNum(Long meiNum) {
		this.meiNum = meiNum;
	}
	public String getMeiName() {
		return meiName;
	}
	public void setMeiName(String meiName) {
		this.meiName = meiName;
	}
	public Long getMeiPrice() {
		return meiPrice;
	}
	public void setMeiPrice(Long meiPrice) {
		this.meiPrice = meiPrice;
	}
	public String getMeiDesc() {
		return meiDesc;
	}
	public void setMeiDesc(String meiDesc) {
		this.meiDesc = meiDesc;
	}
	
}
