package com.cmbb.bean;

import java.util.List;

public class GetPage {
	//����һ������������
		private int totalData;
	//����һ��ÿҳ��������
		private int pageTotalCount;
	//������ҳ��
		private int pageCount;
	//���嵱ǰҳ��	
		private int nowdayPage;
	//���嵱ǰҳ������
		private List list;
		
		
		
		
		
		
		
		public GetPage(int totalData, int pageTotalCount, int pageCount,
			int nowdayPage, List list) {
		super();
		this.totalData = totalData;
		this.pageTotalCount = pageTotalCount;
		this.pageCount = pageCount;
		this.nowdayPage = nowdayPage;
		this.list = list;
	}
		public int getNowdayPage() {
			return nowdayPage;
		}
		public void setNowdayPage(int nowdayPage) {
			this.nowdayPage = nowdayPage;
		}
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
		public int getTotalData() {
			return totalData;
		}
		public void setTotalData(int totalData) {
			this.totalData = totalData;
		}
		public int getPageTotalCount() {
			return pageTotalCount;
		}
		public void setPageTotalCount(int pageTotalCount) {
			this.pageTotalCount = pageTotalCount;
		}
		public int getPageCount() {
			return pageCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		
		
}
