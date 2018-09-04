package com.ict.erp.vo;

public class MemberInfo {
	private Long miNum;
	private String miId;
	private String miName;
	private String miPwd;
	private String diCode;
	private Long liLevel;
	private String miEmail;
	private String miDesc;
	private String miPhone;
	private String miZipcode;
	private String miAddress1;
	private String miAddress2;
	private String liName;
	private String diName;
	private PageInfo pi;
	
	public PageInfo getPi() {
		return pi;
	}
	public void setPi(PageInfo pi) {
		this.pi = pi;
	}
	
	public MemberInfo() {}
	
	public MemberInfo(Long miNum, String miId, String miName, String miPwd, String diCode, Long liLevel, String miEmail,
			String miDesc, String miPhone, String miZipcode, String miAddress1, String miAddress2) {
		super();
		this.miNum = miNum;
		this.miId = miId;
		this.miName = miName;
		this.miPwd = miPwd;
		this.diCode = diCode;
		this.liLevel = liLevel;
		this.miEmail = miEmail;
		this.miDesc = miDesc;
		this.miPhone = miPhone;
		this.miZipcode = miZipcode;
		this.miAddress1 = miAddress1;
		this.miAddress2 = miAddress2;
		
	}
	
	
	public String getLiName() {
		return liName;
	}

	public void setLiName(String liName) {
		this.liName = liName;
	}

	public String getDiName() {
		return diName;
	}

	public void setDiName(String diName) {
		this.diName = diName;
	}

	public Long getMiNum() {
		return miNum;
	}
	public void setMiNum(Long miNum) {
		this.miNum = miNum;
	}
	public String getMiId() {
		return miId;
	}
	public void setMiId(String miId) {
		this.miId = miId;
	}
	public String getMiName() {
		return miName;
	}
	public void setMiName(String miName) {
		this.miName = miName;
	}
	public String getMiPwd() {
		return miPwd;
	}
	public void setMiPwd(String miPwd) {
		this.miPwd = miPwd;
	}
	public String getDiCode() {
		return diCode;
	}
	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	public Long getLiLevel() {
		return liLevel;
	}
	public void setLiLevel(Long liLevel) {
		this.liLevel = liLevel;
	}
	public String getMiEmail() {
		return miEmail;
	}
	public void setMiEmail(String miEmail) {
		this.miEmail = miEmail;
	}
	public String getMiDesc() {
		return miDesc;
	}
	public void setMiDesc(String miDesc) {
		this.miDesc = miDesc;
	}
	public String getMiPhone() {
		return miPhone;
	}
	public void setMiPhone(String miPhone) {
		this.miPhone = miPhone;
	}
	public String getMiZipcode() {
		return miZipcode;
	}
	public void setMiZipcode(String miZipcode) {
		this.miZipcode = miZipcode;
	}
	public String getMiAddress1() {
		return miAddress1;
	}
	public void setMiAddress1(String miAddress1) {
		this.miAddress1 = miAddress1;
	}
	public String getMiAddress2() {
		return miAddress2;
	}
	public void setMiAddress2(String miAddress2) {
		this.miAddress2 = miAddress2;
	}
	@Override
	public String toString() {
		return "MemberInfo [miNum=" + miNum + ", miId=" + miId + ", miName=" + miName + ", miPwd=" + miPwd + ", diCode="
				+ diCode + ", liLevel=" + liLevel + ", miEmail=" + miEmail + ", miDesc=" + miDesc + ", miPhone="
				+ miPhone + ", miZipcode=" + miZipcode + ", miAddress1=" + miAddress1 + ", miAddress2=" + miAddress2
				+ "]";
	}
	
}