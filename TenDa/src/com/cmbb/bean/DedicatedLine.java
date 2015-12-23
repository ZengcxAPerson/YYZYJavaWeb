package com.cmbb.bean;

/**
 * 车队信息
 * @author Administrator
 *
 */
public class DedicatedLine {
	private int dedicatedLineId;
	private String dedicatedLineStart;//起始地
	private String dedicatedLineDestination;//目的地
	private String dedicatedLineThrough;//经过路线
	private String dedicatedLineRemark;//车辆路线备注
	
	
	public DedicatedLine() {
		super();
	}
	public DedicatedLine(int dedicatedLineId, String dedicatedLineStart,
			String dedicatedLineDestination, String dedicatedLineThrough,
			String dedicatedLineRemark) {
		super();
		this.dedicatedLineId = dedicatedLineId;
		this.dedicatedLineStart = dedicatedLineStart;
		this.dedicatedLineDestination = dedicatedLineDestination;
		this.dedicatedLineThrough = dedicatedLineThrough;
		this.dedicatedLineRemark = dedicatedLineRemark;
	}
	public int getDedicatedLineId() {
		return dedicatedLineId;
	}
	public void setDedicatedLineId(int dedicatedLineId) {
		this.dedicatedLineId = dedicatedLineId;
	}
	public String getDedicatedLineStart() {
		return dedicatedLineStart;
	}
	public void setDedicatedLineStart(String dedicatedLineStart) {
		this.dedicatedLineStart = dedicatedLineStart;
	}
	public String getDedicatedLineDestination() {
		return dedicatedLineDestination;
	}
	public void setDedicatedLineDestination(String dedicatedLineDestination) {
		this.dedicatedLineDestination = dedicatedLineDestination;
	}
	public String getDedicatedLineThrough() {
		return dedicatedLineThrough;
	}
	public void setDedicatedLineThrough(String dedicatedLineThrough) {
		this.dedicatedLineThrough = dedicatedLineThrough;
	}
	public String getDedicatedLineRemark() {
		return dedicatedLineRemark;
	}
	public void setDedicatedLineRemark(String dedicatedLineRemark) {
		this.dedicatedLineRemark = dedicatedLineRemark;
	}
	
	
}
