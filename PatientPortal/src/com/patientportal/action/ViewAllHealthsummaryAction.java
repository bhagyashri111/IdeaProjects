package com.patientportal.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patientportal.bean.HealthsummaryTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.serviceimpl.HealthsummaryServiceImpl;
import com.patientportal.util.UtilConstants;

public class ViewAllHealthsummaryAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		List<HealthsummaryTO> healthsummarytolist = null;
		String path = "";
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("role").equals("patient")) {
				healthsummarytolist = new HealthsummaryServiceImpl()
						.getPatientHealthsummary((Integer) session
								.getAttribute("userid"));
			} else {
				healthsummarytolist = new HealthsummaryServiceImpl()
				.getPatientHealthsummary(Integer.parseInt((String)session
						.getAttribute("userdata")));
			}
			if (healthsummarytolist != null) {
				request
						.setAttribute("healthsummarytolist",
								healthsummarytolist);
				path = UtilConstants._VIEW_HEALTHSUMMARY_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_HEALTHSUMMARY_FAILED);
				path = UtilConstants._VIEW_HEALTHSUMMARY;
			}
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			path = UtilConstants._STATUS_PATH;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._VIEW_HEALTHSUMMARY_FAILED);
			path = UtilConstants._STATUS_PATH;
		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
