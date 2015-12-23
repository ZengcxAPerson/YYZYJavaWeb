package com.cmbb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Goods;
import com.cmbb.dao.HyllDAO;
import com.cmbb.dao.NumberDAO;


public class DoHytjServlet extends HttpServlet {
	HyllDAO dao = new HyllDAO();
	/**
	 * Constructor of the object.
	 */
	public DoHytjServlet() {
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

		request.setCharacterEncoding("utf-8");
		//调用货源编号自增方法
		NumberDAO numdao = new NumberDAO();
		
		String GoodsNumber = numdao.setGoodsNumber();
		String GoodsName = request.getParameter("goodsName");
		String GoodsTypeId = request.getParameter("goodsTypeId");
		String GoodsConsignerId = request.getParameter("goodsConsignerId");
		String GoodsConsigneeId = request.getParameter("goodsConsigneeId");
		String GoodsStart = request.getParameter("goodsStart");
		String GoodsDestination =  request.getParameter("goodsDestination");
		String GoodsABC = request.getParameter("goodsABC");
		String GoodsCity = request.getParameter("goodsCity");
		String GoodsStockId = request.getParameter("goodsStockId");
		String GoodsStockRegionId = request.getParameter("goodsStockRegionId");
		double GoodsPrice = Double.valueOf(request.getParameter("goodsPrice"));
		String GoodsAmount = request.getParameter("goodsAmount");
		String GoodsUnit = request.getParameter("goodsUnit");
		String GoodsState = request.getParameter("goodsState");
		
		System.out.println(GoodsPrice);
		Goods goods= new Goods();
		goods.setGoodsNumber(GoodsNumber);
		goods.setGoodsName(GoodsName);
		goods.setGoodsUnit(GoodsTypeId);
		goods.setGoodsConsignerId(GoodsConsignerId);
		goods.setGoodsConsigneeId(GoodsConsigneeId);
		goods.setGoodsStart(GoodsStart);
		goods.setGoodsDestination(GoodsDestination);
		goods.setGoodsABC(GoodsABC);
		goods.setGoodsCity(GoodsCity);
		goods.setGoodsStockId(GoodsStockId);
		goods.setGoodsStockRegionId(GoodsStockRegionId);
		goods.setGoodsPrice(GoodsPrice);
		goods.setGoodsAmount(GoodsAmount);
		goods.setGoodsUnit(GoodsUnit);
		goods.setGoodsState(GoodsState);
		
		boolean result = dao.addGoods(goods);
		System.out.println(result);
		if(result) {
			request.getRequestDispatcher("HyllServelet").forward(request, response);
		}else {
			request.getSession().setAttribute("error", "添加失败");
			request.getRequestDispatcher("hytj.jsp").forward(request, response);
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
