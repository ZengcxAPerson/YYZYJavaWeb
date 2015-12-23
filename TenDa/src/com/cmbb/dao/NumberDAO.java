package com.cmbb.dao;

import java.sql.*;



import com.cmbb.util.*;

public class NumberDAO {
	private Connection con ;
	private PreparedStatement pst ;
	private ResultSet rst ;
	
	
	/**
	 * 商品编号自增
	 * @return
	 */
	public String setGoodsNumber()
	{
		String num = null;
		con = DBUtil.getConnection();
		String sql = "select MAX(GoodsNumber) from Goods";
		try {
			pst = con.prepareStatement(sql);
			rst = pst.executeQuery();
			if(rst.next())
			{
				num =String.valueOf(rst.getString(1));
				int num1 =Integer.valueOf(num.substring(7))+1;
				num = "GOODS00" + String.valueOf(num1);
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
	 * 入库单编号自增
	 * @return
	 */
	public String setStoreEntryNum()
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
				System.out.println("新增的入库单编号："+num1);
				num = "SKI-000" + String.valueOf(num1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			DBUtil.closeAll(con, pst, rst);
		}
		return num;
	}
}
