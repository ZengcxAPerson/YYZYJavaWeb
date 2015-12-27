package com.cmbb.service;

import java.util.List;

import com.cmbb.bean.PageBean;
import com.cmbb.dao.pageDAO;

import com.cmbb.bean.*;

public class PageNo {
	private int pageSize = 2 ; // ÿҳ��ʾ5������
	public PageBean hyllByPageNo(int currentPageNo) {
		PageBean page = null ;
		pageDAO pagedao = new pageDAO();
		//ȡ�û�Դ�ܼ�¼��
		int totalCount = pagedao.getCount();
		System.out.println(totalCount);
		int totalPageNo = 0 ;
		//������ҳ��
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
		
		//ȡ��ҳ���¼�ļ���
		List list = pagedao.showPageSize(currentPageNo, pageSize);
		page = new PageBean( currentPageNo, totalCount, totalPageNo, pageSize, list);
		return page;
	}
}
