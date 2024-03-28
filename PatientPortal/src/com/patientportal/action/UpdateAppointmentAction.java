package com.patientportal.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.patientportal.bean.AppointmentTO;
import com.patientportal.bean.AppointmentTO;
import com.patientportal.serviceimpl.AppointmentServiceImpl;
import com.patientportal.exception.ConnectionException;
import com.patientportal.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UpdateAppointmentAction extends HttpServlet {

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
		AppointmentTO appointmentto = new AppointmentTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(appointmentto, map);
			System.out.println(request.getParameter("status"));
			if(request.getParameter("status")==null)
				flag = new AppointmentServiceImpl().cancelAppointment(Integer.parseInt(request.getParameter("appointmentid")),(Integer)request.getSession().getAttribute("userid"));
			else
				flag = new AppointmentServiceImpl().cancelAppointment(Integer.parseInt(request.getParameter("appointmentid")),(String)request.getParameter("status"));
			
			if (flag) {
				request.setAttribute("status",
						UtilConstants._UPDATE_APPOINTMENT);
				path = "./ViewAllAppointmentAction?mine="+request.getSession().getAttribute("userid");
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._DELETE_APPOINTMENT_FAILED);
				path = UtilConstants._STATUS_PATH;
			}
		} catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS, e.getMessage());
			path = UtilConstants._STATUS_PATH;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS,
					UtilConstants._DELETE_APPOINTMENT_FAILED);
			path = UtilConstants._STATUS_PATH;
		} finally {
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
