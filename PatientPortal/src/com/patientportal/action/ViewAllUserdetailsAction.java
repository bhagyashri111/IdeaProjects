package com.patientportal.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.patientportal.bean.UserdetailsTO;
import com.patientportal.serviceimpl.UserdetailsServiceImpl;
import com.patientportal.exception.ConnectionException;
import com.patientportal.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ViewAllUserdetailsAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		List<UserdetailsTO> userdetailstolist = null;
		String path = "";
		try {
			if (request.getParameter("role") != null) {
				userdetailstolist = new UserdetailsServiceImpl()
						.getUserdetails((String) request.getParameter("role"));
				if (userdetailstolist != null) {
					request
					.setAttribute("userdetailstolist",
							userdetailstolist);
					request
							.setAttribute("role",
									request.getParameter("role"));
					path = UtilConstants._VIEW_USERDETAILS_JSP;
				} else {
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._VIEW_USERDETAILS_FAILED);
					path = UtilConstants._VIEW_USERDETAILS_JSP;
				}
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_USERDETAILS_FAILED);
				path = UtilConstants._VIEW_USERDETAILS_JSP;
			}

		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			path = UtilConstants._STATUS_PATH;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._VIEW_USERDETAILS_FAILED);
			path = UtilConstants._STATUS_PATH;
		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
