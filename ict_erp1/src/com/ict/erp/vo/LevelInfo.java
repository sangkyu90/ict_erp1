package com.ict.erp.vo;

public class LevelInfo {
	private int liNum;
	private int liLevel;
	private String liName;
	private String liDesc;
	public LevelInfo(int liNum, int liLevel, String liName, String liDesc) {
		super();
		this.liNum = liNum;
		this.liLevel = liLevel;
		this.liName = liName;
		this.liDesc = liDesc;
	}
	public int getLiNum() {
		return liNum;
	}
	public void setLiNum(int liNum) {
		this.liNum = liNum;
	}
	public int getLiLevel() {
		return liLevel;
	}
	public void setLiLevel(int liLevel) {
		this.liLevel = liLevel;
	}
	public String getLiName() {
		return liName;
	}
	public void setLiName(String liName) {
		this.liName = liName;
	}
	public String getLiDesc() {
		return liDesc;
	}
	public void setLiDesc(String liDesc) {
		this.liDesc = liDesc;
	}
	@Override
	public String toString() {
		return "LevelInfo [liNum=" + liNum + ", liLevel=" + liLevel + ", liName=" + liName + ", liDesc=" + liDesc + "]";
	}
	
}