package com.patientportal.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.patientportal.bean.AllergiesTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.serviceimpl.AllergiesServiceImpl;
import com.patientportal.util.UtilConstants;

public class ViewAllAllergiesAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		List<AllergiesTO> allergiestolist = null;
		String path = "";
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("role").equals("patient")){
				allergiestolist = new AllergiesServiceImpl().getPatientAllergies((Integer)session.getAttribute("userid"));
			}else{
				allergiestolist = new AllergiesServiceImpl().getPatientAllergies(Integer.parseInt((String)session.getAttribute("userdata")));
			}
			if (allergiestolist != null) {
				request.setAttribute("allergiestolist", allergiestolist);
				path = UtilConstants._VIEW_ALLERGIES_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_ALLERGIES_FAILED);
				path = UtilConstants._VIEW_ALLERGIES;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._VIEW_ALLERGIES_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
