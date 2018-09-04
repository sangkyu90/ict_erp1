package com.ict.erp.vo;

public class TestInfo {

	private int tiNum;
	private String tiId;
	private String tiName;
	private String tiText;
	public TestInfo() {
		
	}
	public TestInfo(int tiNum, String tiId, String tiName, String tiText) {
		super();
		this.tiNum = tiNum;
		this.tiId = tiId;
		this.tiName = tiName;
		this.tiText = tiText;
	}
	public int getTiNum() {
		return tiNum;
	}
	public void setTiNum(int tiNum) {
		this.tiNum = tiNum;
	}
	public String getTiId() {
		return tiId;
	}
	public void setTiId(String tiId) {
		this.tiId = tiId;
	}
	public String getTiName() {
		return tiName;
	}
	public void setTiName(String tiName) {
		this.tiName = tiName;
	}
	public String getTiText() {
		return tiText;
	}
	public void setTiText(String tiText) {
		this.tiText = tiText;
	}
	@Override
	public String toString() {
		return "TextInfo [tiNum=" + tiNum + ", tiId=" + tiId + ", tiName=" + tiName + ", tiText=" + tiText + "]";
	}
	
}
