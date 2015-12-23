package com.cmbb.bean;
/**
 * 车队管理
 * @author Administrator
 *
 */
public class Motorcade {
	private	String motorcadeNum;
	private	String motorcadeName;
	private	String chargeId;
	
	public Motorcade() {
		super();
	}

	public Motorcade(String motorcadeNum, String motorcadeName, String chargeId) {
		super();
		this.motorcadeNum = motorcadeNum;
		this.motorcadeName = motorcadeName;
		this.chargeId = chargeId;
	}

	public String getMotorcadeNum() {
		return motorcadeNum;
	}

	public void setMotorcadeNum(String motorcadeNum) {
		this.motorcadeNum = motorcadeNum;
	}

	public String getMotorcadeName() {
		return motorcadeName;
	}

	public void setMotorcadeName(String motorcadeName) {
		this.motorcadeName = motorcadeName;
	}

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	
	
	
}
