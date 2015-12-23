package com.cmbb.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.util.DBUtil;


import com.cmbb.bean.*;

public class pageDAO {
	private Connection con ; 
	private PreparedStatement pst ; 
	private ResultSet rst ;
	
	/**
	 * 查询货源所有记录数
	 */
	public int getCount() {
		int allCount = 0 ;
		con =DBUtil.getConnection();
		String sql = "select count(*) from Goods";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				allCount = rst.getInt(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return allCount;
	}
	
	
	
	/**
	 * 分页显示数据
	 */
	 public List<Goods> showPageSize(int curentPageNo , int pageSize) {
		 con = DBUtil.getConnection();
		 List<Goods> goodsList = new ArrayList<Goods>();
		 int num = pageSize*(curentPageNo-1);
		 System.out.println("num="+num);
		 String sql = "select top "+pageSize+" *  from Goods where GoodsId not in (select top "+num+"  GoodsId from Goods)";
		 try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			while(rst.next()) {
				Goods goods = new Goods();
				goods.setGoodsNumber(rst.getString("GoodsNumber"));
				goods.setGoodsName(rst.getString("GoodsName"));
				goods.setGoodsUnit(rst.getString("GoodsTypeId"));
				goods.setGoodsConsignerId(rst.getString("GoodsConsignerId"));
				goods.setGoodsConsigneeId(rst.getString("GoodsConsigneeId"));
				goods.setGoodsStart(rst.getString("GoodsStart"));
				goods.setGoodsDestination(rst.getString("GoodsDestination"));
				goods.setGoodsABC(rst.getString("GoodsABC"));
				goods.setGoodsCity(rst.getString("GoodsCity"));
				goods.setGoodsStockId(rst.getString("GoodsStockId"));
				goods.setGoodsStockRegionId(rst.getString("GoodsStockRegionId"));
				goods.setGoodsPrice(rst.getDouble("GoodsPrice"));
				goods.setGoodsAmount(rst.getString("GoodsAmount"));
				goods.setGoodsUnit(rst.getString("GoodsUnit"));
				goods.setGoodsState(rst.getString("GoodsState"));
				goodsList.add(goods);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(con, pst, rst);
		}
		return goodsList;
	 }
}
