package com.patientportal.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patientportal.bean.AppointmentTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.serviceimpl.AppointmentServiceImpl;
import com.patientportal.util.UtilConstants;

public class ViewAllAppointmentAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		List<AppointmentTO> appointmenttolist = null;
		String path = "";
		try {
			if(request.getParameter("mine")==null)
				appointmenttolist = new AppointmentServiceImpl().getAppointment();
			else if(request.getParameter("mine") !=null && request.getSession().getAttribute("role").equals("doctor")){
				appointmenttolist = new AppointmentServiceImpl().getDoctorAppointment((String)request.getSession().getAttribute("loginid"));
			}
			else
				appointmenttolist = new AppointmentServiceImpl().getMyAppointment((Integer)request.getSession().getAttribute("userid"));

			if (appointmenttolist != null) {
				request.setAttribute("appointmenttolist", appointmenttolist);
				path = UtilConstants._VIEW_APPOINTMENT_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_APPOINTMENT_FAILED);
				path = UtilConstants._VIEW_APPOINTMENT;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._VIEW_APPOINTMENT_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
