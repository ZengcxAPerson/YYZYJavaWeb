package com.cmbb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.bean.DedicatedLine;
import com.cmbb.bean.Goods;
import com.cmbb.util.DBUtil;

/**
 * 车队信息dao
 * @author Administrator
 *
 */
public class DedicatedLineDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	/**
	 * 线路管理显示
	 * @return
	 */
	public List<DedicatedLine> selectDedicatedLine(){
		List<DedicatedLine> dedicatedLineList=new ArrayList<DedicatedLine>();
		con=DBUtil.getConnection();
		String sql="select * from dbo.DedicatedLine";
		try {
			pst=con.prepareStatement(sql);
			rst=pst.executeQuery();
			while(rst.next()){
				DedicatedLine dedicatedLine=new DedicatedLine();
				dedicatedLine.setDedicatedLineId(rst.getInt("dedicatedLineId"));
				dedicatedLine.setDedicatedLineStart(rst.getString("dedicatedLineStart"));
				dedicatedLine.setDedicatedLineDestination(rst.getString("dedicatedLineDestination"));
				dedicatedLine.setDedicatedLineThrough(rst.getString("dedicatedLineThrough"));
				dedicatedLine.setDedicatedLineRemark(rst.getString("dedicatedLineRemark"));
				dedicatedLineList.add(dedicatedLine);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		
		return dedicatedLineList;
	}
	/**
	 * 添加线路
	 * @param dedicatedLine
	 * @return
	 */
	public boolean addDedicatedLine(DedicatedLine dedicatedLine){
		
		con=DBUtil.getConnection();
		String sql="insert into dbo.DedicatedLine values(?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, dedicatedLine.getDedicatedLineStart());
			pst.setString(2, dedicatedLine.getDedicatedLineDestination());
			pst.setString(3, dedicatedLine.getDedicatedLineThrough());
			pst.setString(4, dedicatedLine.getDedicatedLineRemark());
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
	
	public boolean delDedicatedLine(String LineId){
		con=DBUtil.getConnection();
		String sql="delete from  dbo.DedicatedLine where DedicatedLineId=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, LineId);
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
