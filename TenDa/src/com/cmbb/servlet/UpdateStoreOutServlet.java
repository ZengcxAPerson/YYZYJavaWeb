package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.StoreOut;
import com.cmbb.service.CkxxService;

public class UpdateStoreOutServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateStoreOutServlet() {
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

		doPost(request,response);
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		StoreOut storeOut = new StoreOut();
		String StoreOutNum = request.getParameter("StoreOutNum");
		String StoreOutDate = request.getParameter("StoreOutDate");
		String Licenseplate = request.getParameter("Licenseplate");
		String ChargeId = request.getParameter("ChargeId");
		String GoodsId =request.getParameter("GoodsId") ;
		int GoodsAmount =Integer.parseInt(request.getParameter("GoodsAmount"));
		String ConsigneeId = request.getParameter("ConsigneeId");
		String GoodsTypeId = request.getParameter("GoodsTypeId");
		String GoodsRemark = request.getParameter("GoodsRemark");
		
		storeOut.setStoreOutNum(StoreOutNum);
		storeOut.setStoreOutDate(StoreOutDate);
		storeOut.setLicenseplate(Licenseplate);
		storeOut.setChargeId(ChargeId);
		storeOut.setGoodsId(GoodsId);
		storeOut.setGoodsAmount(GoodsAmount);
		storeOut.setConsigneeId(ConsigneeId);
		storeOut.setGoodsTypeId(GoodsTypeId);
		storeOut.setGoodsRemark(GoodsRemark);
		CkxxService ckxxservice = new CkxxService();
		boolean updateO = ckxxservice.updateStoreOut(storeOut);
		if(updateO)
		{
			RequestDispatcher rd= request.getRequestDispatcher("../ckxx/ShowOutStoreServlet");
			rd.forward(request, response);
		}else{
			out.write("ÐÞ¸ÄÊ§°Ü");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
