package com.cmbb.bean;

import java.util.List;

public class PageBean {
	private int currentPageNo;//��ǰҳ��
	private int totalCount;//�ܼ�¼����
	private int totalPageNo;//��ҳ��
	private int pageSize;//ÿҳҳ��ļ�¼��
	private List list;//��ǰҳ�еļ���
	public PageBean(int currentPageNo, int totalCount, int totalPageNo,
			int pageSize, List list) {
		super();
		this.currentPageNo = currentPageNo;
		this.totalCount = totalCount;
		this.totalPageNo = totalPageNo;
		this.pageSize = pageSize;
		this.list = list;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
