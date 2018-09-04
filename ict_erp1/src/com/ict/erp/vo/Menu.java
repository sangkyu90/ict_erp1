package com.ict.erp.vo;

public class Menu {
	private String miUrl;
	private String miId;
	private String miLabel;
	@Override
	public String toString() {
		return "Menu [miUrl=" + miUrl + ", miId=" + miId + ", miLabel=" + miLabel + "]";
	}
	public String getMiUrl() {
		return miUrl;
	}
	public void setMiUrl(String miUrl) {
		this.miUrl = miUrl;
	}
	public String getMiId() {
		return miId;
	}
	public void setMiId(String miId) {
		this.miId = miId;
	}
	public String getMiLabel() {
		return miLabel;
	}
	public void setMiLabel(String miLabel) {
		this.miLabel = miLabel;
	}
	public Menu(String miUrl, String miId, String miLabel) {
		this.miUrl = miUrl;
		this.miId = miId;
		this.miLabel = miLabel;
	}
	
}
