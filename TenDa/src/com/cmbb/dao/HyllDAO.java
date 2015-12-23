package com.cmbb.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.bean.*;
import com.cmbb.util.*;

public class HyllDAO {
	public Connection con;
	public PreparedStatement pst ;
	public ResultSet rst ;
	
//	public List<Goods> showGoods() {
//		con = DBManager.getCon();
//		List<Goods> goodsList = new ArrayList<Goods>();
//		String sql = "select * from Goods";
//		try {
//			pst = con.prepareStatement(sql);
//			rst = pst.executeQuery();
//			while(rst.next()) {
//				Goods goods = new Goods();
//				
//				goods.setGoodsNumber(rst.getString("GoodsNumber"));
//				goods.setGoodsName(rst.getString("GoodsName"));
//				goods.setGoodsUnit(rst.getString("GoodsTypeId"));
//				goods.setGoodsConsignerId(rst.getString("GoodsConsignerId"));
//				goods.setGoodsConsigneeId(rst.getString("GoodsConsigneeId"));
//				goods.setGoodsStart(rst.getString("GoodsStart"));
//				goods.setGoodsDestination(rst.getString("GoodsDestination"));
//				goods.setGoodsABC(rst.getString("GoodsABC"));
//				goods.setGoodsCity(rst.getString("GoodsCity"));
//				goods.setGoodsStockId(rst.getString("GoodsStockId"));
//				goods.setGoodsStockRegionId(rst.getString("GoodsStockRegionId"));
//				goods.setGoodsPrice(rst.getDouble("GoodsPrice"));
//				goods.setGoodsAmount(rst.getString("GoodsAmount"));
//				goods.setGoodsUnit(rst.getString("GoodsUnit"));
//				goods.setGoodsState(rst.getString("GoodsState"));
//				
//				goodsList.add(goods);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			DBManager.closeAll(rst, pst, con);
//		}
//		return goodsList;
//	}
	

	/**
	 * 货物类型      下拉框
	 * @return
	 */
	public List<GoodsType> showGoodsType() {
		con = DBUtil.getConnection();
		List<GoodsType> typeList = new ArrayList<GoodsType>();
		String sql = "select * from GoodsType order by GoodsTypeId";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				GoodsType goodsType = new GoodsType();
				goodsType.setGoodsTypeId(rst.getInt("GoodsTypeId"));
				goodsType.setGoodsTypeName(rst.getString("GoodsTypeName"));
				goodsType.setGoodsTypeNumber(rst.getString("GoodsTypeNumber"));
				typeList.add(goodsType);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return typeList;
	}
	
	/**
	 * 添加货源 仓库下拉框
	 */
	public List<WareHouse> showWareHouse() {
		con = DBUtil.getConnection();
		List<WareHouse> wareList = new ArrayList<WareHouse>();
		String sql = "select * from WareHouse";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				WareHouse ware = new WareHouse();
				ware.setWareHouseId(rst.getInt("WareHouseId"));
				ware.setWareHouseNumber(rst.getString("WareHouseNumber"));
				ware.setWareHouseName(rst.getString("WareHouseName"));
				ware.setChargeId(rst.getString("ChargeId"));
				ware.setWareHouseAdd(rst.getString("WareHouseAdd"));
				wareList.add(ware);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return wareList;
	}
	
	/**
	 * 仓库位置
	 */
	public List<StockRegion> showStockRegion() {
		con = DBUtil.getConnection();
		List<StockRegion> stockList = new ArrayList<StockRegion>();
		String sql = "select * from StockRegion";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				StockRegion stock = new StockRegion();
				stock.setStockRegionId(rst.getInt("StockRegionId"));
				stock.setStockRegionNumber(rst.getString("StockRegionNumber"));
				stock.setStockRegionName(rst.getString("StockRegionName"));
				stockList.add(stock);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return stockList;
	}
	
	/**
	 * 添加货源
	 */
	public boolean addGoods(Goods goods) {
		con =DBUtil.getConnection();
		String sql = "insert into Goods values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,goods.getGoodsNumber());
			pst.setString(2, goods.getGoodsName());
			pst.setString(3, goods.getGoodsTypeId());
			pst.setString(4, goods.getGoodsConsignerId());
			pst.setString(5, goods.getGoodsConsigneeId());
			pst.setString(6, goods.getGoodsStart());
			pst.setString(7, goods.getGoodsDestination());
			pst.setString(8, goods.getGoodsABC());
			pst.setString(9, goods.getGoodsCity());
			pst.setString(10, goods.getGoodsStockId());
			pst.setString(11, goods.getGoodsStockRegionId());
			pst.setDouble(12, goods.getGoodsPrice());
			pst.setString(13, goods.getGoodsAmount());
			pst.setString(14, goods.getGoodsUnit());
			pst.setString(15, goods.getGoodsState());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return false ;
	}
	
	/**
	 * 货源类型添加
	 */
	public boolean addCoodsType(GoodsType goodsType ) {
		con =DBUtil.getConnection();
		String sql = "insert into GoodsType values(?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, goodsType.getGoodsTypeNumber());
			pst.setString(2, goodsType.getGoodsTypeName());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return false ;
	}
	
	/**
	 * 收货管理  显示收货人信息
	 */
	public List<Consignee> showConsignee() {
		con = DBUtil.getConnection();
		List<Consignee> consigneeList = new ArrayList<Consignee>();
		String sql = "select * from Consignee";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				Consignee consignee = new Consignee();
				
				consignee.setConsigneeNumber(rst.getString("ConsigneeNumber"));
				consignee.setConsigneeCompany(rst.getString("ConsigneeCompany"));
				consignee.setConsigneeName(rst.getString("ConsigneeName"));
				consignee.setConsigneeAddr(rst.getString("ConsigneeAddr"));
				consignee.setConsigneePhone(rst.getString("ConsigneePhone"));
				consignee.setConsigneeIdCard(rst.getString("ConsigneeIdCard"));
				
				consigneeList.add(consignee);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return consigneeList;
	}
	
	/**
	 * 添加收货人信息
	 */
	public boolean addConsignee(Consignee consignee ) {
		con = DBUtil.getConnection();
		String sql = "insert into Consignee values(?,?,?,?,?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,consignee.getConsigneeNumber());
			pst.setString(2,consignee.getConsigneeCompany());
			pst.setString(3,consignee.getConsigneeName());
			pst.setString(4,consignee.getConsigneeAddr());
			pst.setString(5,consignee.getConsigneePhone());
			pst.setString(6,consignee.getConsigneeMobile());
			pst.setString(7,consignee.getConsigneeFax());
			pst.setString(8,consignee.getConsigneeEmail());
			pst.setString(9,consignee.getConsigneeIdCard());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return false ;
	}
	
	/**
	 * 收货管理  显示发货人信息
	 */
	public List<Consigner> showConsigner() {
		con = DBUtil.getConnection();
		List<Consigner> consignerList = new ArrayList<Consigner>();
		String sql = "select * from Consigner";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				Consigner consigner = new Consigner();
				
				consigner.setConsignerNumber(rst.getString("ConsignerNumber"));
				consigner.setConsignerCompany(rst.getString("ConsignerCompany"));
				consigner.setConsignerName(rst.getString("ConsignerName"));
				consigner.setConsignerAddr(rst.getString("ConsignerAddr"));
				consigner.setConsignerPhone(rst.getString("ConsignerPhone"));
				consigner.setConsignerIdCard(rst.getString("ConsignerIdCard"));
				
				consignerList.add(consigner);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return consignerList;
	}
	
	/**
	 * 添加发货人信息
	 */
	public boolean addConsigner(Consigner consigner ) {
		con =DBUtil.getConnection();
		String sql = "insert into Consigner values(?,?,?,?,?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,consigner.getConsignerNumber());
			pst.setString(2,consigner.getConsignerCompany());
			pst.setString(3,consigner.getConsignerName());
			pst.setString(4,consigner.getConsignerAddr());
			pst.setString(5,consigner.getConsignerPhone());
			pst.setString(6,consigner.getConsignerMobile());
			pst.setString(7,consigner.getConsignerFax());
			pst.setString(8,consigner.getConsignerEmail());
			pst.setString(9,consigner.getConsignerIdCard());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return false ;
	}
}
