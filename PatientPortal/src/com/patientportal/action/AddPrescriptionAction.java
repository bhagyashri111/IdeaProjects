package com.patientportal.action;

import java.io.IOException;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.patientportal.bean.PrescriptionTO;
import com.patientportal.bean.PrescriptionTO;
import com.patientportal.serviceimpl.PrescriptionServiceImpl;
import com.patientportal.exception.ConnectionException;
import com.patientportal.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddPrescriptionAction extends HttpServlet {

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
		PrescriptionTO prescriptionto = new PrescriptionTO();
		Map map = request.getParameterMap();
		try {
			if (request.getParameter("medicationid") == null) {
				request.setAttribute("status", "Please select Medication to renewal");
				path = UtilConstants._ADD_PRESCRIPTION_JSP;
			} else {
//				BeanUtils.populate(prescriptionto, map);
				flag = new PrescriptionServiceImpl()
						.addPrescription(Integer.parseInt(request.getParameter("medicationid")),(Integer)request.getSession().getAttribute("userid"));
				if (flag) {
					request.setAttribute("status",
							UtilConstants._ADD_PRESCRIPTION);
					path = "./ViewAllPrescriptionAction";
				} else {
					request.setAttribute(UtilConstants._STATUS,
							UtilConstants._ADD_PRESCRIPTION_FAILED);
					path = UtilConstants._STATUS_PATH;
				}
			}
			
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			path = UtilConstants._STATUS_PATH;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._ADD_PRESCRIPTION_FAILED);
			path = UtilConstants._STATUS_PATH;
		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
