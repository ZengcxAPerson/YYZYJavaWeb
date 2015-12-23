package com.cmbb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cmbb.bean.*;
import com.cmbb.dao.HyllDAO;


public class BeforeHytjServlet extends HttpServlet {
	HyllDAO dao = new HyllDAO()	;
	/**
	 * Constructor of the object.
	 */
	public BeforeHytjServlet() {
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
		response.setContentType("text/html;charset=gbk");
		//货源类型下拉框
		List<GoodsType> goodsTypeList = dao.showGoodsType();
		
		//仓库下拉框
		List<WareHouse> wareList = dao.showWareHouse();
		
		//仓库位置下拉框
		List<StockRegion> stockList = dao.showStockRegion();
		
		request.getSession().setAttribute("stockList", stockList);
		request.getSession().setAttribute("wareList", wareList);
		request.getSession().setAttribute("goodsTypeList", goodsTypeList);
		request.getRequestDispatcher("hytj.jsp").forward(request, response);
		
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
