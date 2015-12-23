package com.cmbb.bean;

public class ShowEntry {
	private String StoreEntryNum;
	private String StoreEntryDate;
	private int GoodsEntryAmount;
	private String loginName;
	private String GoodsName;
	private String GoodsTypeNumber;

	public String getGoodsTypeNumber() {
		return GoodsTypeNumber;
	}
	public void setGoodsTypeNumber(String goodsTypeNumber) {
		GoodsTypeNumber = goodsTypeNumber;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getStoreEntryNum() {
		return StoreEntryNum;
	}
	public void setStoreEntryNum(String storeEntryNum) {
		StoreEntryNum = storeEntryNum;
	}
	public String getStoreEntryDate() {
		return StoreEntryDate;
	}
	public void setStoreEntryDate(String storeEntryDate) {
		StoreEntryDate = storeEntryDate;
	}
	public int getGoodsEntryAmount() {
		return GoodsEntryAmount;
	}
	public void setGoodsEntryAmount(int goodsEntryAmount) {
		GoodsEntryAmount = goodsEntryAmount;
	}

	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	
	
}
