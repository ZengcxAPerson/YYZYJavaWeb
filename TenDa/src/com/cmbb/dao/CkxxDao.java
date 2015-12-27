package com.cmbb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.bean.*;
import com.cmbb.util.*;
/**
 * ��ѯ�ֿ����������ʾ
 * @author Administrator
 *
 */
public class CkxxDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	
	
	
	/**
	 * ��½����ѯLogin��
	 * @param login
	 * @return
	 */
	public boolean login(Login login)
	{
		con = DBUtil.getConnection();
		String sql = "select Count(*) from Login where loginName = ? and LoginPsw = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, login.getLoginName());
			pst.setString(2, login.getLoginPsw());
			rst=pst.executeQuery();
			while(rst.next())
			{
				int num = rst.getInt(1);
				if(num>0)
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
	/**
	 *��ҳǰ����ѯ�ֿ������ʾҳ��
	 * @return
	 */
	public List<ShowCk> selectDepot(){
  		List<ShowCk> depotList = new ArrayList<ShowCk>();
		con = DBUtil.getConnection();
  	
  		String sql = "select w.WareHouseNumber , w.WareHouseName ,l.loginName  ,w.WareHouseAdd  from WareHouse w,Login l where l.loginId = w.ChargeId";
  		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while(rst.next()){	
				ShowCk show = new ShowCk();
				show.setWareHouseNumber(rst.getString("WareHouseNumber"));
				show.setWareHouseName(rst.getString("WareHouseName"));
				show.setLoginName(rst.getString("LoginName"));
				show.setWareHouseAdd(rst.getString("WareHouseAdd"));
				depotList.add(show);
	  		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll(con, pst, rst);
		}
  		return depotList;	
	}
	
	
	/**
	 * ���ҷ�ҳ
	 * @param pageCount
	 * @param pageTotalCount
	 * @return
	 */
	public List<ShowCk> selectPageWareHouse(int nowdayPage,int pageTotalCount){
		List<ShowCk> showCk = new ArrayList<ShowCk>();
		con = DBUtil.getConnection();
		int ontop = pageTotalCount*(nowdayPage-1);
  		String sql = "	select top "+pageTotalCount+" " +
  				"w.WareHouseNumber , w.WareHouseName ,l.loginName  ,w.WareHouseAdd" +
  				" from WareHouse w,Login l " +
  				"where l.loginId = w.ChargeId and WareHouseNumber not in" +
  				"(select top "+ontop+" WareHouseNumber from WareHouse)";
  		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while(rst.next()){	
				ShowCk show = new ShowCk();
				show.setWareHouseNumber(rst.getString("WareHouseNumber"));
				show.setWareHouseName(rst.getString("WareHouseName"));
				show.setLoginName(rst.getString("LoginName"));
				show.setWareHouseAdd(rst.getString("WareHouseAdd"));
				showCk.add(show);
	  		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll(con, pst, rst);
		}
  		return showCk;	
	}
	
	/**
	 * ���Ҳֿ�������е���������
	 * @return
	 */
	public int getAllPage()
	{
		int num = 0;
		con = DBUtil.getConnection();
		String sql = "select count(*) from WareHouse";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				num = rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return num;
	}
	
	
	
	/**
	 * ��Ӳֿ�
	 * @param warehouse
	 * @return
	 */
	public boolean addCk(WareHouse warehouse)
	{
		con = DBUtil.getConnection();
		String sql = "insert into WareHouse values(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, warehouse.getWareHouseNumber());
			pst.setString(2, warehouse.getWareHouseName());
			pst.setString(3, warehouse.getChargeId());
			pst.setString(4, warehouse.getWareHouseAdd());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
	
	/**
	 * ɾ���ֿ������ʾҳ�������
	 * @param wareHouseNumber
	 * @return
	 */
	public boolean delCk(String wareHouseNumber)
	{
		con = DBUtil.getConnection();
		String sql = "delete WareHouse where WareHouseNumber = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, wareHouseNumber);
			int a = pst.executeUpdate();
			if(a>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	/**
	 * �޸Ĳֿ������ʾҳ�������
	 * @param warehouse
	 * @return
	 */
	public boolean updateCk(WareHouse warehouse)
	{
		con = DBUtil.getConnection();
		String sql = "update WareHouse  set  WareHouseAdd=?,WareHouseName=?,ChargeId=? where WareHouseNumber=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, warehouse.getWareHouseAdd());
			pst.setString(2, warehouse.getWareHouseName());
			pst.setString(3, warehouse.getChargeId());
			pst.setString(4, warehouse.getWareHouseNumber());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	
	/**
	 * ��ѯ����λ�ù���ҳ����ʾ����
	 * @return
	 */
	public List<StockRegion> selectStock()
	{
		con = DBUtil.getConnection();
		String sql = "select * from StockRegion ";
		List<StockRegion> stockList = new ArrayList<StockRegion>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				StockRegion stock = new StockRegion();
				stock.setStockRegionId(rst.getInt("StockRegionId"));
				stock.setStockRegionName(rst.getString("StockRegionName"));
				stock.setStockRegionNumber(rst.getString("StockRegionNumber"));
				stockList.add(stock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return stockList;
	}
	
	/**
	 * ��ҳ��ʾ��ѯ����λ�ù���ҳ����ʾ����
	 * @param nowdayPage
	 * @param pageTotalCount
	 * @return
	 */
	public List<StockRegion> selectPageStock(int nowdayPage,int pageTotalCount){
		con = DBUtil.getConnection();
		int ontop = pageTotalCount*(nowdayPage-1);
  		String sql = "	select top "+pageTotalCount+" " +
  				"* from StockRegion where StockRegionNumber not in" +
  				"(select top "+ontop+" StockRegionNumber from StockRegion)";
  		List<StockRegion> stockList = new ArrayList<StockRegion>();
  		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			
			while(rst.next()){	
				StockRegion stock = new StockRegion();
				stock.setStockRegionId(rst.getInt("StockRegionId"));
				stock.setStockRegionName(rst.getString("StockRegionName"));
				stock.setStockRegionNumber(rst.getString("StockRegionNumber"));
				stockList.add(stock);
	  		}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeAll(con, pst, rst);
		}
  		return stockList;	
	}
	
	/**
	 * ���Ҳֿ�λ�����е���������
	 * @return
	 */
	public int getStockAllPage()
	{
		int num = 0;
		con = DBUtil.getConnection();
		String sql = "select count(*) from StockRegion";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				num = rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return num;
	}
	
	
	
	
	
	/**
	 * ��ӻ������ڲֿ�λ��
	 * @param stock
	 * @return
	 */
	public boolean addGoodsPlace(StockRegion stock)
	{
		con = DBUtil.getConnection();
		String sql = "insert into StockRegion values(?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, stock.getStockRegionNumber());
			pst.setString(2, stock.getStockRegionName());
			pst.setString(3, stock.getStockNumber());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
	
	/**
	 * ɾ����������λ�ñ��������
	 * @param StockRegionNumber
	 * @return
	 */
	public boolean delGoodsPlace(String StockRegionNumber)
	{
		con = DBUtil.getConnection();
		String sql = "delete StockRegion where StockRegionNumber=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, StockRegionNumber);
			int a = pst.executeUpdate();
			if(a>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	
	/**
	 * �޸Ļ������ڲֿ�Ϊλ��
	 * @param stockRegion
	 * @return
	 */
	public boolean updateGoodsPlace(StockRegion stockRegion)
	{
		con = DBUtil.getConnection();
		String sql = "update StockRegion  set StockRegionName=? where StockRegionNumber=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, stockRegion.getStockRegionName());
			pst.setString(2, stockRegion.getStockRegionNumber());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	
	/**
	 * ��ѯ��ⵥ�����
	 * @return
	 */
	public List<ShowEntry> selectStoreEntry()
	{
		con = DBUtil.getConnection();
		String sql = "select s.StoreEntryNum,s.StoreEntryDate, l.loginName,g.GoodsName,s.GoodsEntryAmount from StoreEntry s,Goods g,Login l where s.ChargeId = l.loginId and s.GoodsId = g.GoodsNumber";
		List<ShowEntry> storeList = new ArrayList<ShowEntry>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowEntry showEntry = new ShowEntry();
				showEntry.setStoreEntryNum(rst.getString("StoreEntryNum"));
				showEntry.setStoreEntryDate(rst.getString("StoreEntryDate"));
				showEntry.setLoginName(rst.getString("loginName"));
				showEntry.setGoodsName(rst.getString("GoodsName"));
				showEntry.setGoodsEntryAmount(rst.getInt("GoodsEntryAmount"));
				storeList.add(showEntry);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return storeList;
	}
	
	
	/**
	 * ��ѯ��ҳ�˵���ⵥ
	 * @param nowdayPage
	 * @param pageTotalCount
	 * @return
	 */
	public List<ShowEntry> selectStoreEntryPage(int nowdayPage,int pageTotalCount)
	{
		con = DBUtil.getConnection();
		int ontop = pageTotalCount*(nowdayPage-1);
		String sql = "	select top "+pageTotalCount+" " +
  				"s.StoreEntryNum,s.StoreEntryDate, l.loginName,g.GoodsName," +
  				"s.GoodsEntryAmount from StoreEntry s,Goods g,Login l" +
  				" where s.ChargeId = l.loginId and s.GoodsId = g.GoodsNumber" +
  				" and StoreEntryNum not in" +
  				"(select top "+ontop+" StoreEntryNum from StoreEntry)";
		List<ShowEntry> storeList = new ArrayList<ShowEntry>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowEntry showEntry = new ShowEntry();
				showEntry.setStoreEntryNum(rst.getString("StoreEntryNum"));
				showEntry.setStoreEntryDate(rst.getString("StoreEntryDate"));
				showEntry.setLoginName(rst.getString("loginName"));
				showEntry.setGoodsName(rst.getString("GoodsName"));
				showEntry.setGoodsEntryAmount(rst.getInt("GoodsEntryAmount"));
				storeList.add(showEntry);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return storeList;
	}
	
	/**
	 * ��ѯ��ⵥ���е���������
	 * @return
	 */
	
	public int getStoreEntryAllPage()
	{
		int num = 0;
		con = DBUtil.getConnection();
		String sql = "select count(*) from StoreEntry";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				num = rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return num;
	}
	
	
	
	
	
	/**
	 * ɾ����ⵥ
	 * @param storeEntryNum
	 * @return
	 */
	public boolean delEntry(String storeEntryNum)
	{
		con = DBUtil.getConnection();
		String sql = "delete StoreEntry where StoreEntryNum=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeEntryNum);
			int a = pst.executeUpdate();
			if(a>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	/**
	 * �޸�������Ϣ
	 * @param stockRegion
	 * @return
	 */
	public boolean updateEntry(StoreEntry storeEntry)
	{
		con = DBUtil.getConnection();
		String sql = "update StoreEntry  set StoreEntryDate=?,ChargeId=?,GoodsId=?,GoodsEntryAmount=?,GoodsTypeId=?,GoodsRemark=? where StoreEntryNum=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeEntry.getStoreEntryDate());
			pst.setString(2, storeEntry.getChargeId());
			pst.setString(3, storeEntry.getGoodsId());
			pst.setInt(4, storeEntry.getGoodsEntryAmount());
			pst.setString(5, storeEntry.getGoodsTypeId());
			pst.setString(6, storeEntry.getGoodsRemark());
			pst.setString(7, storeEntry.getStoreEntryNum());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	
	/**
	 * �����ⵥ
	 * @param storeEntry
	 * @return
	 */
	public boolean addEntryStore(StoreEntry storeEntry)
	{
		con = DBUtil.getConnection();
		String sql = "insert into StoreEntry values(?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeEntry.getStoreEntryNum());
			pst.setString(2, storeEntry.getStoreEntryDate());
			pst.setString(3, storeEntry.getChargeId());
			pst.setString(4, storeEntry.getGoodsId());
			pst.setInt(5, storeEntry.getGoodsEntryAmount());
			pst.setString(6, storeEntry.getGoodsTypeId());
			pst.setString(7, storeEntry.getGoodsRemark());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
	
	
	/**
	 * ��ѯ���ⵥ
	 * @return
	 */
	public List<StoreOut> selectStoreOut()
	{
		con = DBUtil.getConnection();
		String sql = "select s.StoreOutNum ,s.StoreOutDate ,l.loginName ,g.GoodsName ,s.GoodsAmount ,c.ConsigneeName ,gt.GoodsTypeName  from" +
				" StoreOut s,Consignee c,Login l,Goods g,GoodsType gt " +
				"where s.ConsigneeId = c.ConsigneeNumber and s.ChargeId = l.loginId and s.GoodsId = g.GoodsNumber and s.GoodsTypeId = gt.GoodsTypeNumber";
		List<StoreOut> outList = new ArrayList<StoreOut>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				StoreOut storeout = new StoreOut();
				storeout.setStoreOutNum(rst.getString("StoreOutNum"));
				storeout.setStoreOutDate(rst.getString("StoreOutDate"));
				storeout.setConsigneeName(rst.getString("ConsigneeName"));
				storeout.setLoginName(rst.getString("LoginName"));
				storeout.setGoodsAmount(rst.getInt("GoodsAmount"));
				storeout.setGoodsName(rst.getString("GoodsName"));
				storeout.setGoodsTypeName(rst.getString("GoodsTypeName"));
				outList.add(storeout);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return outList;
	}
	
	
	
	
	/**
	 * ��ѯ��ʾ��ҳ�ĳ��ⵥ
	 * @param nowdayPage
	 * @param pageTotalCount
	 * @return
	 */
	public List<StoreOut> selectStoreOutPage(int nowdayPage,int pageTotalCount)
	{
		con = DBUtil.getConnection();
		int ontop = pageTotalCount*(nowdayPage-1);
		String sql = "select top "+pageTotalCount+" s.StoreOutNum ,s.StoreOutDate ,l.loginName ," +
				" g.GoodsName ,s.GoodsAmount ,c.ConsigneeName ,gt.GoodsTypeName  from" +
				" StoreOut s,Consignee c,Login l,Goods g,GoodsType gt " +
				" where s.ConsigneeId = c.ConsigneeNumber and s.ChargeId = l.loginId " +
				" and s.GoodsId = g.GoodsNumber and s.GoodsTypeId = gt.GoodsTypeNumber" +
				" and StoreOutNum not in" +
  				"(select top "+ontop+" StoreOutNum from StoreOut)";
		List<StoreOut> outList = new ArrayList<StoreOut>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				StoreOut storeout = new StoreOut();
				storeout.setStoreOutNum(rst.getString("StoreOutNum"));
				storeout.setStoreOutDate(rst.getString("StoreOutDate"));
				storeout.setConsigneeName(rst.getString("ConsigneeName"));
				storeout.setLoginName(rst.getString("LoginName"));
				storeout.setGoodsAmount(rst.getInt("GoodsAmount"));
				storeout.setGoodsName(rst.getString("GoodsName"));
				storeout.setGoodsTypeName(rst.getString("GoodsTypeName"));
				outList.add(storeout);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return outList;
	}
	
	
	/**
	 * ��ѯ���еĳ��ⵥ����������
	 * @return
	 */
	public int getStoreOutAllPage()
	{
		int num = 0;
		con = DBUtil.getConnection();
		String sql = "select count(*) from StoreOut";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				num = rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return num;
	}
	
	
	/**
	 * ɾ�����ⵥ
	 * @param storeEntryNum
	 * @return
	 */
	public boolean delOut(String storeOutNum)
	{
		con = DBUtil.getConnection();
		String sql = "delete StoreOut where StoreOutNum=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeOutNum);
			int a = pst.executeUpdate();
			if(a>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	/**
	 * ��ӳ��ⵥ
	 * @param storeEntry
	 * @return
	 */
	public boolean addOutStore(StoreOut storeOut)
	{
		con = DBUtil.getConnection();
		String sql = "insert into StoreOut values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeOut.getStoreOutNum());
			pst.setString(2, storeOut.getStoreOutDate());
			pst.setString(3, storeOut.getLicenseplate());
			pst.setString(4, storeOut.getChargeId());
			pst.setString(5, storeOut.getGoodsId());
			pst.setInt(6, storeOut.getGoodsAmount());
			pst.setString(7, storeOut.getConsigneeId());
			pst.setString(8, storeOut.getGoodsTypeId());
			pst.setString(9, storeOut.getGoodsRemark());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
	
	/**
	 * ȡ����ӳ��ⵥʱ��ĳ�����StoreOutNum
	 * @return
	 */
	public String getStoreOutNum()
	{
		String num = null;
		con = DBUtil.getConnection();
		String sql = "select MAX(storeOutNum) from StoreOut";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			if(rst.next())
			{
				num =String.valueOf(rst.getString(1));
				int num1 =Integer.valueOf(num.substring(5))+1;
				num = "SKO-00" + String.valueOf(num1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return num;
	}
	
	
	/**
	 * ȡ����ⵥʱ��������StoreEntryNum
	 * @return
	 */
	public String getStoreEntryNum()
	{
		String num = null;
		con = DBUtil.getConnection();
		String sql = "select MAX(storeEntryNum) from StoreEntry";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			if(rst.next())
			{
				num =String.valueOf(rst.getString(1));
				int num1 =Integer.valueOf(num.substring(5))+1;
				num = "SKl-00" + String.valueOf(num1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return num;
	}
	
	/**
	 * �޸ĳ��ⵥ
	 * @param storeOut
	 * @return
	 */
	public boolean updateOut(StoreOut storeOut)
	{
		con = DBUtil.getConnection();
		String sql = "update StoreOut  set StoreOutDate=?,Licenseplate=?,ChargeId=?," +
				"GoodsId=?,GoodsAmount=?,ConsigneeId=?,GoodsTypeId=?,GoodsRemark=? where StoreOutNum = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, storeOut.getStoreOutDate());
			pst.setString(2, storeOut.getLicenseplate());
			pst.setString(3, storeOut.getChargeId());
			pst.setString(4, storeOut.getGoodsId());
			pst.setInt(5, storeOut.getGoodsAmount());
			pst.setString(6, storeOut.getConsigneeId());
			pst.setString(7, storeOut.getGoodsTypeId());
			pst.setString(8, storeOut.getGoodsRemark());
			pst.setString(9, storeOut.getStoreOutNum());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return false;
	}
	
	/**
	 * ��ȡLogin���ֵ����JSPҳ����������ȡ���ݿ��ֵ
	 * @return
	 */
	public List<Login> selectLoginName()
	{
		con = DBUtil.getConnection();
		String sql = " select loginName,loginId from Login";
		List<Login> LoginList = new ArrayList<Login>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				Login login = new Login();
				login.setLoginId(rst.getString("LoginId"));
				login.setLoginName(rst.getString("LoginName"));
				LoginList.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return LoginList;
	}
	
	/**
	 * ��ѯ���ݿ��ȡ�ֿ�λ������
	 * @return
	 */
	public List<ShowCk> selectWareHouseName()
	{
		List<ShowCk> WareHouseName = new ArrayList<ShowCk>();
		con = DBUtil.getConnection();
		String sql = " select WareHouseName,WareHouseNumber from WareHouse";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowCk show = new ShowCk();
				show.setWareHouseName(rst.getString("WareHouseName"));
				show.setWareHouseNumber(rst.getString("WareHouseNumber"));
				WareHouseName.add(show);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return WareHouseName;
	}
	
	/**
	 * ����Goods��õ�GoodsName
	 * @return
	 */
	public List<ShowGoodsComboBox> selectGoodsName()
	{
		con = DBUtil.getConnection();
		String sql = " select GoodsName,GoodsNumber from Goods";
		List<ShowGoodsComboBox> list = new ArrayList<ShowGoodsComboBox>();
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowGoodsComboBox show = new ShowGoodsComboBox();
				show.setGoodsName(rst.getString("GoodsName"));
				show.setGoodsNumber(rst.getString("GoodsNumber"));
				list.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return list;
	}
	
	/**
	 * ����GoodsType��õ�GoodsTypeName
	 * @return
	 */
	public List<ShowGoodsComboBox> selectGoodsTypeName()
	{
		con = DBUtil.getConnection();
		List<ShowGoodsComboBox> list = new ArrayList<ShowGoodsComboBox>();
		String sql = " select GoodsTypeName,GoodsTypeNumber from GoodsType";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowGoodsComboBox show = new ShowGoodsComboBox();
				show.setGoodsTypeName(rst.getString("GoodsTypeName"));
				show.setGoodsTypeNumber(rst.getString("GoodsTypeNumber"));
				list.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return list;
	}
	
	public	List<StoreOut> selectLisenceplate()
	{	
		List<StoreOut> Lisenceplate = new ArrayList<StoreOut>();
		con = DBUtil.getConnection();
		String sql = " select Licenseplate from Vehicle";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				StoreOut store = new StoreOut();
				store.setLicenseplate(rst.getString("Licenseplate"));
				Lisenceplate.add(store);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return Lisenceplate;
	}

	
	public List<ShowGoodsComboBox> selectConsigneeName()
	{
		con = DBUtil.getConnection();
		List<ShowGoodsComboBox> list = new ArrayList<ShowGoodsComboBox>();
		String sql = " select ConsigneeName,ConsigneeNumber from Consignee";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next())
			{
				ShowGoodsComboBox show = new ShowGoodsComboBox();
				show.setConsigneeName(rst.getString("ConsigneeName"));
				show.setConsigneeNumber(rst.getString("ConsigneeNumber"));
				list.add(show);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return list;
	}
	
}
