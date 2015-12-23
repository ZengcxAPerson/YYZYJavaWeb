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

public class AddOutStoreServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddOutStoreServlet() {
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
		CkxxService ckxxservice = new CkxxService();
		
		StoreOut storeOut = new StoreOut();
		String StoreOutNum =  ckxxservice.getStoreOutNum();
		String StoreOutDate = request.getParameter("storeOutDate");
		String Licenseplate = request.getParameter("licenseplate");
		String ChargeId = request.getParameter("chargeId");
		String GoodsId =request.getParameter("goodsId") ;
		int GoodsAmount =Integer.parseInt(request.getParameter("goodsAmount"));
		String ConsigneeId = request.getParameter("ConsigneeId");
		String GoodsTypeId = request.getParameter("goodsTypeId");
		String GoodsRemark = request.getParameter("goodsRemark");
		
		storeOut.setStoreOutNum(StoreOutNum);
		storeOut.setStoreOutDate(StoreOutDate);
		storeOut.setLicenseplate(Licenseplate);
		storeOut.setChargeId(ChargeId);
		storeOut.setGoodsId(GoodsId);
		storeOut.setGoodsAmount(GoodsAmount);
		storeOut.setConsigneeId(ConsigneeId);
		storeOut.setGoodsTypeId(GoodsTypeId);
		storeOut.setGoodsRemark(GoodsRemark);
		
		
		boolean addO = ckxxservice.addStoreOut(storeOut);
		if(addO)
		{
			RequestDispatcher rd= request.getRequestDispatcher("../ckxx/ShowOutStoreServlet");
			rd.forward(request, response);
		}else{
			out.write("添加失败，请重新添加");
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
