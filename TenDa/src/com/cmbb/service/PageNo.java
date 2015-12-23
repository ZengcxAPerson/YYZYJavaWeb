package com.cmbb.service;

import java.util.List;

import com.cmbb.bean.PageBean;
import com.cmbb.dao.pageDAO;

import com.cmbb.bean.*;

public class PageNo {
	private int pageSize = 2 ; // 每页显示5条数据
	public PageBean hyllByPageNo(int currentPageNo) {
		PageBean page = null ;
		pageDAO pagedao = new pageDAO();
		//取得货源总记录数
		int totalCount = pagedao.getCount();
		System.out.println(totalCount);
		int totalPageNo = 0 ;
		//计算总页数
		if(totalCount%pageSize == 0) {
			totalPageNo = totalCount/pageSize ;
		}else {
			totalPageNo = totalCount/pageSize+1;
		}
		if(currentPageNo < 1) {
			currentPageNo = 1;
		}
		if(currentPageNo > totalPageNo) {
			currentPageNo = totalPageNo ;
		}
		
		//取出页码记录的集合
		List list = pagedao.showPageSize(currentPageNo, pageSize);
		page = new PageBean( currentPageNo, totalCount, totalPageNo, pageSize, list);
		return page;
	}
}
