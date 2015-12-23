package com.cmbb.bean;

public class Login {
	private String loginId;
	private String loginName;
	private String loginPsw;
	private String loginPower;
	
	public Login() {
		super();
	}
	public Login(String loginId, String loginName, String loginPsw,
			String loginPower) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.loginPsw = loginPsw;
		this.loginPower = loginPower;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPsw() {
		return loginPsw;
	}
	public void setLoginPsw(String loginPsw) {
		this.loginPsw = loginPsw;
	}
	public String getLoginPower() {
		return loginPower;
	}
	public void setLoginPower(String loginPower) {
		this.loginPower = loginPower;
	}
	
}
