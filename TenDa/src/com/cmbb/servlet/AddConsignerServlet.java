package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Consigner;
import com.cmbb.dao.HyllDAO;


public class AddConsignerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddConsignerServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
		String ConsignerNumber = request.getParameter("consignerNumber") ;
		String ConsignerCompany = request.getParameter("consignerCompany") ;
		String ConsignerName = request.getParameter("consignerName") ;
		String ConsignerAddr = request.getParameter("consignerAddr") ;
		String ConsignerPhone = request.getParameter("consignerPhone") ;
		String ConsignerMobile = request.getParameter("consignerMobile") ;
		String ConsignerFax = request.getParameter("consignerFax") ;
		String ConsignerEmail = request.getParameter("consignerEmail") ;
		String ConsignerIdCard = request.getParameter("consignerIdCard") ;
		
		Consigner consigner = new Consigner();
		consigner.setConsignerNumber(ConsignerNumber);
		consigner.setConsignerCompany(ConsignerCompany);
		consigner.setConsignerName(ConsignerName);
		consigner.setConsignerAddr(ConsignerAddr);
		consigner.setConsignerPhone(ConsignerPhone);
		consigner.setConsignerMobile(ConsignerMobile);
		consigner.setConsignerFax(ConsignerFax);
		consigner.setConsignerEmail(ConsignerEmail);
		consigner.setConsignerIdCard(ConsignerIdCard);
		HyllDAO dao = new HyllDAO();
		boolean result = dao.addConsigner(consigner);
		System.out.println(result);
		if(result) {
			request.getRequestDispatcher("HyShowConsignerServlet").forward(request, response);
		}else {
			request.getSession().setAttribute("error", "ÃÌº” ß∞‹");
			request.getRequestDispatcher("hyShowConsigner.jsp").forward(request, response);
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
