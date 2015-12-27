package com.cmbb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmbb.bean.Login;
import com.cmbb.service.CkxxService;

public class GoLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoLoginServlet() {
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
		CkxxService ckxxService = new CkxxService();
		String loginName = request.getParameter("user");
		String loginPsw = request.getParameter("pwd");
		Login login = new Login();
		login.setLoginName(loginName);
		login.setLoginPsw(loginPsw);
		boolean result = ckxxService.Gologin(login);
		if(result)
		{
			request.getSession().setAttribute("hasUser",loginName );
			request.getRequestDispatcher("../main.jsp").forward(request, response);
			
		}else{
			
			System.out.println("û�е�½�����ȵ�½");
			request.getSession().setAttribute("noUser","��½ʧ�ܣ������û�������������" );
			request.getRequestDispatcher("../index.jsp").forward(request, response);
			
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
