package com.patientportal.action;
import java.io.IOException; 
import java.util.Map; 
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

public class DeletePrescriptionAction extends HttpServlet {

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
			BeanUtils.populate(prescriptionto, map);
			flag = new PrescriptionServiceImpl().deletePrescription(prescriptionto.getPrescriptionid());


			if (flag) {
				request.setAttribute("status", UtilConstants._DELETE_PRESCRIPTION);
				path = UtilConstants._VIEW_ALLPRESCRIPTION_ACTION;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._DELETE_PRESCRIPTION_FAILED);
				path = UtilConstants._STATUS_PATH;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._DELETE_PRESCRIPTION_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
