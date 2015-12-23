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
	  * 取出dao方法中取出库编号
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
	  * 取出dao方法中的入库编号StoreEntryNum
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
	  * 仓库管理分页service
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectPage(int nowdayPage)
	 {
		 int totalData = dao.getAllPage();//数据库表里共有多少数据
		 //多少页
		 int pageCount = 0;
		 //计算总页数
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
		 
		 //每一页该显示的数据
		 List list = dao.selectPageWareHouse(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * 仓库位置分页
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStockRegionPage(int nowdayPage)
	 {
		 int totalData = dao.getStockAllPage();//数据库表里共有多少数据
		 //多少页
		 int pageCount = 0;
		 //计算总页数
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
		 
		 //每一页该显示的数据
		 List list = dao.selectPageStock(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * 入库单分页
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStoreEntryPage(int nowdayPage)
	 {
		 int totalData = dao.getStoreEntryAllPage();//数据库表里共有多少数据
		 //多少页
		 int pageCount = 0;
		 //计算总页数
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
		 
		 //每一页该显示的数据
		 List list = dao.selectStoreEntryPage(nowdayPage, pageTotalCount);
		 GetPage getPage = new GetPage(totalData,pageTotalCount,pageCount,nowdayPage,list);
		 return getPage;
	 }
	 
	 
	 /**
	  * 出库单分页
	  * @param nowdayPage
	  * @return
	  */
	 public GetPage selectStoreOutPage(int nowdayPage)
	 {
		 int totalData = dao.getStoreOutAllPage();//数据库表里共有多少数据
		 //多少页
		 int pageCount = 0;
		 //计算总页数
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
		 
		 //每一页该显示的数据
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
