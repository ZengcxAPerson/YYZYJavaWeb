package com.cmbb.service;

import java.util.List;

import com.cmbb.bean.*;
import com.cmbb.bean.Login;
import com.cmbb.bean.ShowCk;
import com.cmbb.bean.ShowEntry;
import com.cmbb.bean.ShowGoodsComboBox;
import com.cmbb.bean.StoreOut;
import com.cmbb.dao.CkxxDao;

public class CkxxService {
	CkxxDao dao = new CkxxDao();
	
	
	public boolean Gologin(Login login)
	{
		boolean go = dao.login(login);
		return go;
	}
	
	
	public List<ShowCk> Ckxx()
	{
	 List<ShowCk> list =dao.selectDepot();
	 return list;
	}
	
	public boolean AddCk(WareHouse warehouse)
	{
		boolean add = dao.addCk(warehouse);
		return add;
	}
	public boolean delCk(String wareHouseNumber)
	{
		boolean del = dao.delCk(wareHouseNumber);
		return del;
	}
	 public boolean updateCk(WareHouse warehouse)
	 {
		 boolean update = dao.updateCk(warehouse);
		 return update;
	 }
	 
	 public List<StockRegion> showStock()
	 {
		 List<StockRegion> StockList = dao.selectStock();
		 return StockList;
	 }
	 
	 public boolean addGoodsPlace(StockRegion stock)
	 {
		 boolean addGP = dao.addGoodsPlace(stock);
		 return addGP;
				 
	 }
	 
	 public boolean delGoodsPlace(String StockRegionNumber)
	 {
		 boolean delGP = dao.delGoodsPlace(StockRegionNumber);
		 return delGP;
	 }

	 public boolean updateGoodsPlace(StockRegion stockRegion)
	 {
		 boolean updateGP = dao.updateGoodsPlace(stockRegion);
		 return updateGP;
	 }
	 
	 
	 public List<ShowEntry> showStoreEntry()
	 {
		 List<ShowEntry> showList = dao.selectStoreEntry();
		 return showList;
	 }
	 
	 
	 public boolean delStoreEntry(String storeEntryNum)
	 {
		 boolean delse = dao.delEntry(storeEntryNum);
		 return delse;
	 }
	 
	 public boolean updateEntry(StoreEntry storeEntry)
	 {
		 boolean updateE = dao.updateEntry(storeEntry);
		 return updateE;
	 }
	 
	 public boolean addEntry(StoreEntry storeEntry)
	 {
		 boolean addE = dao.addEntryStore(storeEntry);
		 return addE;
	 }
	 
	 public List<StoreOut> showOutStore()
	 {
		 List<StoreOut> showOut = dao.selectStoreOut();
		 return showOut;
	 }
	 
	 
	 public boolean delOut(String storeOutNum)
	 {
		 boolean delO=dao.delOut(storeOutNum);
		 return delO;
	 }
	 
	 /**
	  * ȡ��dao������ȡ������
	  * @return
	  */
	 public String getStoreOutNum()
	 {
		 String get = dao.getStoreOutNum();
		 return get;
	 }
	 
	 public boolean addStoreOut(StoreOut storeOut)
	 {
		 boolean addS = dao.addOutStore(storeOut);
		 return addS;
	 }
	 
	 
	 /**
	  * ȡ��dao�����е������StoreEntryNum
	  * @return
	  */
	 public String getStoreEntryNum()
	 {
		 String get = dao.getStoreEntryNum();
		 return get;
	 }
	 
	 public boolean updateStoreOut(StoreOut storeOut)
	 {
		 boolean updateSO = dao.updateOut(storeOut);
		 return updateSO;
	 }
	 
	 public List<Login> selectLogin()
	 {
		 List<Login> SL = dao.selectLoginName();
		 return SL;
	 }
	 
	 public List<ShowCk> selectWareHouseName()
	 {
		List<ShowCk> name = dao.selectWareHouseName();
		 return name;
	 }
	 
	 
	 int pageTotalCount = 2;
	 
	 
	 /**
	  * �ֿ�����ҳservice
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectPage(int nowdayPage)
	 {
		 int totalData = dao.getAllPage();//���ݿ���ﹲ�ж�������
		 //����ҳ
		 int pageCount = 0;
		 //������ҳ��
		 if(totalData%pageTotalCount==0)
		 {
			 pageCount = totalData/pageTotalCount;
		 }else{
			 pageCount = (totalData/pageTotalCount)+1;
		 }
		 
		 if(nowdayPage<1){
			 nowdayPage = 1;
			}
			
			if(nowdayPage>pageCount){
				nowdayPage = pageCount;
			}
		 
		 //ÿһҳ����ʾ������
		 List list = dao.selectPageWareHouse(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * �ֿ�λ�÷�ҳ
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStockRegionPage(int nowdayPage)
	 {
		 int totalData = dao.getStockAllPage();//���ݿ���ﹲ�ж�������
		 //����ҳ
		 int pageCount = 0;
		 //������ҳ��
		 if(totalData%pageTotalCount==0)
		 {
			 pageCount = totalData/pageTotalCount;
		 }else{
			 pageCount = (totalData/pageTotalCount)+1;
		 }
		 
		 if(nowdayPage<1){
			 nowdayPage = 1;
			}
			
			if(nowdayPage>pageCount){
				nowdayPage = pageCount;
			}
		 
		 //ÿһҳ����ʾ������
		 List list = dao.selectPageStock(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * ��ⵥ��ҳ
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStoreEntryPage(int nowdayPage)
	 {
		 int totalData = dao.getStoreEntryAllPage();//���ݿ���ﹲ�ж�������
		 //����ҳ
		 int pageCount = 0;
		 //������ҳ��
		 if(totalData%pageTotalCount==0)
		 {
			 pageCount = totalData/pageTotalCount;
		 }else{
			 pageCount = (totalData/pageTotalCount)+1;
		 }
		 
		 if(nowdayPage<1){
			 nowdayPage = 1;
			}
			
			if(nowdayPage>pageCount){
				nowdayPage = pageCount;
			}
		 
		 //ÿһҳ����ʾ������
		 List list = dao.selectStoreEntryPage(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * ���ⵥ��ҳ
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStoreOutPage(int nowdayPage)
	 {
		 int totalData = dao.getStoreOutAllPage();//���ݿ���ﹲ�ж�������
		 //����ҳ
		 int pageCount = 0;
		 //������ҳ��
		 if(totalData%pageTotalCount==0)
		 {
			 pageCount = totalData/pageTotalCount;
		 }else{
			 pageCount = (totalData/pageTotalCount)+1;
		 }
		 
		 if(nowdayPage<1){
			 nowdayPage = 1;
			}
			
			if(nowdayPage>pageCount){
				nowdayPage = pageCount;
			}
		 
		 //ÿһҳ����ʾ������
		 List list = dao.selectStoreOutPage(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 
	 
	 public List<ShowGoodsComboBox> selectGoodsName()
	 {
		 List<ShowGoodsComboBox> name = dao.selectGoodsName();
		 return name;
	 }
	 
	 
	 public List<ShowGoodsComboBox> selectGoodsTypeName()
	 {
		 List<ShowGoodsComboBox> name = dao.selectGoodsTypeName();
		 return name;
	 }
	 
	 
	 public List<StoreOut> selectVehicle()
	 {
		 List<StoreOut> name = dao.selectLisenceplate();
		 return name;
	 }
	 
	 public List<ShowGoodsComboBox> selectConsigneeName()
	 {
		 List<ShowGoodsComboBox> name = dao.selectConsigneeName();
		 return name;
	 }
	 
}
