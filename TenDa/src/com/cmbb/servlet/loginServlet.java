package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Login;
import com.cmbb.dao.LoginDao;

public class loginServlet extends HttpServlet {
	private LoginDao dao;
	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
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
		String loginname=request.getParameter("user");
		String loginpsw=request.getParameter("pwd");
		String loginpower=dao.selectLoginPower(loginname);
		
		Login login=new Login();
		login.setLoginName(loginname);
		login.setLoginPsw(loginpsw);
		login.setLoginPower(loginpower);
		if(dao.selectLogin(login)){
			request.getSession().setAttribute("logint", login);//成功后显示数据
			request.getSession().setAttribute("logintrue", loginname);
			response.sendRedirect("main.jsp");
		}else{
			request.getSession().setAttribute("loginfalse", "登录错误");
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		dao=new LoginDao();
	}

}
