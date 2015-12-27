package com.cmbb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cmbb.bean.Login;
import com.cmbb.util.DBUtil;

/**
 * ��¼dao
 * @author Administrator
 *
 */
public class LoginDao {
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rst;
	/**
	 * ��¼�û�
	 * @param login
	 * @return
	 */
	public boolean selectLogin(Login login){
		String sql="select count(*) from Login where loginName=? and loginPsw=?";
		con=DBUtil.getConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, login.getLoginName());
			pst.setString(2, login.getLoginPsw());
			rst=pst.executeQuery();
			while(rst.next()){
				int num=rst.getInt(1);
				if(num>0){
					return true;
				}
				
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
	 * ��ѯ��Power
	 * @return
	 */
	public String selectLoginPower(String loginname){
		String loginpower=null;
		con=DBUtil.getConnection();
		String sql="select loginPower from Login where loginName=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, loginname);
			rst=pst.executeQuery();
			while(rst.next()){
				 loginpower=rst.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		return loginpower;
	}
	/**
	 * �����û����޸�����
	 * @param loginname
	 * @param loginpsw
	 * @return
	 */
	public boolean updateLogin(Login login){
		
		con=DBUtil.getConnection();
		String sql="update Login set loginPsw =? where loginname=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, login.getLoginPsw());
			pst.setString(2, login.getLoginName());
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
	 * �����û�����ѯ��¼�û���������Ϣ
	 * @param loginname
	 * @return
	 */
	public List<Login> selectLoginAll(String loginname){
		List<Login> loginList=new ArrayList<Login>();
		con=DBUtil.getConnection();
		String sql="select * from Login where loginName=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, loginname);
			rst=pst.executeQuery();
			while(rst.next()){
				Login login=new Login();
				login.setLoginId(rst.getString("loginId"));
				login.setLoginName(rst.getString("loginName"));
				login.setLoginPsw(rst.getString("loginPsw"));
				login.setLoginPower(rst.getString("loginPower"));
				loginList.add(login);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(con, pst, rst);
		}
		return loginList;
	}
}
