package com.cmbb.bean;

import java.util.List;

public class GetPage {
	//定义一个数据总条数
		private int totalData;
	//定义一个每页数据条数
		private int pageTotalCount;
	//定义总页数
		private int pageCount;
	//定义当前页数	
		private int nowdayPage;
	//定义当前页的数据
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
