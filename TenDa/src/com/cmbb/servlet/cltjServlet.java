package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Vehicle;
import com.cmbb.dao.VehicleDao;

public class cltjServlet extends HttpServlet {
	private VehicleDao dao;
	/**
	 * Constructor of the object.
	 */
	public cltjServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("utf-8");
		String licenseplate=new String(request.getParameter("licenseplate").getBytes("iso-8859-1"),"utf-8");
		String motorcadeNum=new String(request.getParameter("motorcadeNum").getBytes("iso-8859-1"),"utf-8");
		String trademark=new String(request.getParameter("trademark").getBytes("iso-8859-1"),"utf-8");
		String type=new String(request.getParameter("type").getBytes("iso-8859-1"),"utf-8");
		String weightlimit=new String(request.getParameter("weightlimit").getBytes("iso-8859-1"),"utf-8");
		String usagetime=new String(request.getParameter("usagetime").getBytes("iso-8859-1"),"utf-8");
		String drivingexperience=new String(request.getParameter("drivingexperience").getBytes("iso-8859-1"),"utf-8");
		String licenceNumber=new String(request.getParameter("licenceNumber").getBytes("iso-8859-1"),"utf-8");
		String licenceStyle=new String(request.getParameter("licenceStyle").getBytes("iso-8859-1"),"utf-8");
		String transpotStyle=new String(request.getParameter("transpotStyle").getBytes("iso-8859-1"),"utf-8");
		String remark=new String(request.getParameter("remark").getBytes("iso-8859-1"),"utf-8");
		
		Vehicle v=new Vehicle();
		v.setLicenseplate(licenseplate);
		v.setMotorcadeNum(motorcadeNum);
		v.setTrademark(trademark);
		v.setType(type);
		v.setWeightlimit(weightlimit);
		v.setUsagetime(usagetime);
		v.setDrivingexperience(drivingexperience);
		v.setLicenceNumber(licenceNumber);
		v.setLicenceStyle(licenceStyle);
		v.setTranspotStyle(transpotStyle);
		v.setRemark(remark);
		
		if(dao.addVehicle(v)){
			request.getRequestDispatcher("clglServlet").forward(request, response);
		}else{
			out.print("<script>alert('ÃÌº” ß∞‹£°');history.go(-1);</script>");
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		dao=new VehicleDao();
	}

}
