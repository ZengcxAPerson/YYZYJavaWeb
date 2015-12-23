package com.cmbb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.cmbb.bean.Motorcade;
import com.cmbb.util.DBUtil;
/**
 * 车队管理
 * @author Administrator
 *
 */
public class MotorcadeDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	/**
	 * 车队管理的显示
	 * @return
	 */
	public List<Motorcade> selectMotorcade(){
		List<Motorcade> MotorcadeList=new ArrayList<Motorcade>();
		con=DBUtil.getConnection();
		String sql="select * from dbo.Motorcade";
		try {
			pst=con.prepareStatement(sql);
			rst=pst.executeQuery();
			while(rst.next()){
				Motorcade motorcade=new Motorcade();
				motorcade.setMotorcadeNum(rst.getString("motorcadeNum"));
				motorcade.setMotorcadeName(rst.getString("motorcadeName"));
				motorcade.setChargeId(rst.getString("chargeId"));
				MotorcadeList.add(motorcade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		
		return MotorcadeList;
	}
	/**
	 * 添加车队
	 * @param motorcade
	 * @return
	 */
	public boolean addMotorcade(Motorcade motorcade){
		con=DBUtil.getConnection();
		String sql="insert into dbo.Motorcade values(?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, motorcade.getMotorcadeNum());
			pst.setString(2, motorcade.getMotorcadeName());
			pst.setString(3, motorcade.getChargeId());
			int r=pst.executeUpdate();
			if(r>0){
				return true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
	
	
	/**
	 * 得到车队编号
	 * @return
	 */
	public String getMotorcadeNum(){
		String num=null;
		con=DBUtil.getConnection();
		String sql="select MAX(MotorcadeNum) from Motorcade";
		try {
			pst=con.prepareStatement(sql);
			rst=pst.executeQuery();
			if(rst.next()){
				num=String.valueOf(rst.getString(1));
				int inum=Integer.valueOf(num.substring(4))+1;
				num="MTC-000"+String.valueOf(inum);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		return num;
	}
	/**
	 * 删除车队
	 * @param motorcadeNum
	 * @return
	 */
	public boolean delMotorcade(String motorcadeNum){
		con=DBUtil.getConnection();
		String sql="delete  from  Motorcade where MotorcadeNum=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, motorcadeNum);
			int r=pst.executeUpdate();
			if(r>0){
				return true;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		
		return false;
	}
}
