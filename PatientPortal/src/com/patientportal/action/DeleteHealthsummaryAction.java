package com.patientportal.action;
import java.io.IOException; 
import java.util.Map; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import com.patientportal.bean.HealthsummaryTO; 
import com.patientportal.bean.HealthsummaryTO; 
import com.patientportal.serviceimpl.HealthsummaryServiceImpl; 
import com.patientportal.exception.ConnectionException; 
import com.patientportal.util.UtilConstants; 
import com.sun.org.apache.commons.beanutils.BeanUtils; 

public class DeleteHealthsummaryAction extends HttpServlet {

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
		HealthsummaryTO healthsummaryto = new HealthsummaryTO();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(healthsummaryto, map);
			flag = new HealthsummaryServiceImpl().deleteHealthsummary(healthsummaryto.getHealthissueid());


			if (flag) {
				request.setAttribute("status", UtilConstants._DELETE_HEALTHSUMMARY);
				path = UtilConstants._VIEW_ALLHEALTHSUMMARY_ACTION;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._DELETE_HEALTHSUMMARY_FAILED);
				path = UtilConstants._STATUS_PATH;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._DELETE_HEALTHSUMMARY_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
