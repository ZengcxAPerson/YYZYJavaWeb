package com.cmbb.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.bean.Vehicle;
import com.cmbb.util.DBUtil;

public class VehicleDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	/**
	 * 车辆管理的显示
	 * @return
	 */
	public List<Vehicle> selectvehicle(){
		List<Vehicle> vehicleList=new ArrayList<Vehicle>();
		con=DBUtil.getConnection();
		String sql="select * from Vehicle";
		try {
			pst=con.prepareStatement(sql);
			rst=pst.executeQuery();
			while(rst.next()){
				Vehicle vehicle=new Vehicle();
				vehicle.setLicenseplate(rst.getString("licenseplate"));
				vehicle.setMotorcadeNum(rst.getString("motorcadeNum"));
				vehicle.setTrademark(rst.getString("trademark"));
				vehicle.setType(rst.getString("type"));
				vehicle.setWeightlimit(rst.getString("weightlimit"));
				vehicle.setUsagetime(rst.getString("usagetime"));
				vehicle.setDrivingexperience(rst.getString("drivingexperience"));
				vehicle.setLicenceStyle(rst.getString("licenceStyle"));
				vehicle.setTranspotStyle(rst.getString("transpotStyle"));
				vehicleList.add(vehicle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		
		return vehicleList;
	}
	
	public boolean addVehicle(Vehicle vehicle){
		con=DBUtil.getConnection();
		String sql="insert into dbo.Vehicle values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, vehicle.getLicenseplate());
			pst.setString(2, vehicle.getMotorcadeNum());
			pst.setString(3, vehicle.getTrademark());
			pst.setString(4, vehicle.getType());
			pst.setString(5, vehicle.getWeightlimit());
			pst.setString(6, vehicle.getUsagetime());
			pst.setString(7, vehicle.getDrivingexperience());
			pst.setString(8, vehicle.getLicenceNumber());
			pst.setString(9, vehicle.getLicenceStyle());
			pst.setString(10, vehicle.getTranspotStyle());
			pst.setString(11, vehicle.getRemark());
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
