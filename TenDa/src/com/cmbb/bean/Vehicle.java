package com.cmbb.bean;
/**
 * ������Ϣ
 * @author Administrator
 *
 */
public class Vehicle {
	private String licenseplate;//���ƺ�
	private String motorcadeNum;//��������
	private String trademark;//������
	private String type;//��������
	private String weightlimit;//��������
	private String usagetime;//����ʹ��ʱ��
	private String drivingexperience;//��������
	private String licenceNumber;//��ʻ֤��
	private String licenceStyle;//��ʻ����
	private String transpotStyle;//��������
	private String remark;//��ע
	
	public Vehicle() {
		super();
	}
	
	



	public Vehicle(String licenseplate, String motorcadeNum, String trademark,
			String type, String weightlimit, String usagetime,
			String drivingexperience, String licenceNumber,
			String licenceStyle, String transpotStyle, String remark) {
		super();
		this.licenseplate = licenseplate;
		this.motorcadeNum = motorcadeNum;
		this.trademark = trademark;
		this.type = type;
		this.weightlimit = weightlimit;
		this.usagetime = usagetime;
		this.drivingexperience = drivingexperience;
		this.licenceNumber = licenceNumber;
		this.licenceStyle = licenceStyle;
		this.transpotStyle = transpotStyle;
		this.remark = remark;
	}





	public String getLicenseplate() {
		return licenseplate;
	}
	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}
	public String getMotorcadeNum() {
		return motorcadeNum;
	}
	public void setMotorcadeNum(String motorcadeNum) {
		this.motorcadeNum = motorcadeNum;
	}
	public String getTrademark() {
		return trademark;
	}
	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWeightlimit() {
		return weightlimit;
	}
	public void setWeightlimit(String weightlimit) {
		this.weightlimit = weightlimit;
	}
	public String getUsagetime() {
		return usagetime;
	}
	public void setUsagetime(String usagetime) {
		this.usagetime = usagetime;
	}
	public String getDrivingexperience() {
		return drivingexperience;
	}
	public void setDrivingexperience(String drivingexperience) {
		this.drivingexperience = drivingexperience;
	}
	public String getLicenceStyle() {
		return licenceStyle;
	}
	public void setLicenceStyle(String licenceStyle) {
		this.licenceStyle = licenceStyle;
	}
	public String getTranspotStyle() {
		return transpotStyle;
	}
	public void setTranspotStyle(String transpotStyle) {
		this.transpotStyle = transpotStyle;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getLicenceNumber() {
		return licenceNumber;
	}



	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	
	
}
