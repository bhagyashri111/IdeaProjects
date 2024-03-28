package com.patientportal.action;
import java.io.IOException; 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.patientportal.bean.ImmunizationTO; 
import com.patientportal.bean.ImmunizationTO; 
import com.patientportal.serviceimpl.ImmunizationServiceImpl; 
import com.patientportal.exception.ConnectionException; 
import com.patientportal.util.UtilConstants; 
import com.sun.org.apache.commons.beanutils.BeanUtils; 

public class UpdateViewImmunizationAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		ImmunizationTO immunizationto = null;
		String path = "";
		try {
			immunizationto = new ImmunizationServiceImpl().getImmunization(Integer.parseInt(request.getParameter(UtilConstants._IMMUNIZATIONID)));


			if (immunizationto != null) {
				request.setAttribute("immunization", immunizationto);
				path = UtilConstants._UPDATE_VIEW_IMMUNIZATION_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_IMMUNIZATION_FAILED);
				path = UtilConstants._VIEW_IMMUNIZATION;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._VIEW_IMMUNIZATION_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
