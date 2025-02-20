package com.patientportal.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		System.out.println("in logout user="+session.getAttribute("user"));
		session.setAttribute("user",null);
		session.setAttribute("role", null);
		session.setAttribute("loginid", null);
		session.setAttribute("fullname", null);
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp?status=logout successfully");
					rd.forward(request, response);	
	}

}
