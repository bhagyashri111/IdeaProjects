package com.patientportal.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.patientportal.bean.SentmailsTO;
import com.patientportal.bean.SentmailsTO;
import com.patientportal.serviceimpl.SentmailsServiceImpl;
import com.patientportal.exception.ConnectionException;
import com.patientportal.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddSentmailsAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		boolean flag = false;
		String path = "";
		SentmailsTO sentmailsto = new SentmailsTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(sentmailsto, map);
			// flag = new SentmailsServiceImpl().addSentmails(sentmailsto);

			if (flag) {
				request.setAttribute("status", UtilConstants._ADD_SENTMAILS);
				path = UtilConstants._ADD_SENTMAILS_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._ADD_SENTMAILS_FAILED);
				path = UtilConstants._STATUS_PATH;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._ADD_SENTMAILS_FAILED);
			path = UtilConstants._STATUS_PATH;
		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
