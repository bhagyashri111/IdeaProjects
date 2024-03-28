package com.patientportal.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patientportal.bean.UserdetailsTO;
import com.patientportal.daoimpl.SecurityDaoImpl;
import com.patientportal.util.UtilConstants;

/**
 * LoginAction Servlet Class for to login user into his account. This class
 * Helps to login.
 * 
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";
		HttpSession session = request.getSession();
		UserdetailsTO pro = new UserdetailsTO();
		Vector<UserdetailsTO> vpro = new Vector<UserdetailsTO>();
		String username = request.getParameter("loginid");
		pro.setLoginid(username);
		String password = request.getParameter("password");
		pro.setPassword(password);
		try {
			vpro = new SecurityDaoImpl().loginCheck(pro);
			Iterator it = vpro.listIterator();
			while (it.hasNext()) {
				pro = (UserdetailsTO) it.next();
				System.out.println("in LoginAction Role is.........."
						+ pro.getRole());
			}
			session.setAttribute("fullname", pro.getFullname());
			session.setAttribute("loginid", pro.getLoginid());
			session.setAttribute("userid", pro.getUserid());
			session.setAttribute("useridref", pro.getUserid());
			request.setAttribute("status", "Welcome " + pro.getFullname());
			System.out.println(pro.getRole());
			session.setAttribute("role", pro.getRole());
			if (pro.getRole().equalsIgnoreCase("admin")) {
				target = "./adminhome.jsp";
			} else if (pro.getRole().equalsIgnoreCase("doctor")) {
				target = "./doctorhome.jsp";
			} else if (pro.getRole().equalsIgnoreCase("patient")) {
				target = "./patienthome.jsp";
			} else {
				request.setAttribute("status", "Invalid Loginname and Password");
				target = "./status.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("status", "Invalid Loginname and Password");
			target = "./home.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
