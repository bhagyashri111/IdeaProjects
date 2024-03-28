package com.patientportal.action;
import java.io.IOException; 
import java.util.List; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;

import com.patientportal.bean.MedicationTO; 
import com.patientportal.serviceimpl.MedicationServiceImpl; 
import com.patientportal.exception.ConnectionException; 
import com.patientportal.util.UtilConstants; 
import com.sun.org.apache.commons.beanutils.BeanUtils; 

public class ViewAllMedicationAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		List<MedicationTO> medicationtolist = null;
		String path = "";
		try {
			HttpSession session =request.getSession();
			if(((String)session.getAttribute("role")).equals("doctor")){
				medicationtolist = new MedicationServiceImpl().getPatientMedication((String)session.getAttribute("patientid"));
			}else
				medicationtolist = new MedicationServiceImpl().getMyMedication((Integer)session.getAttribute("userid"));


			if (medicationtolist != null) {
				request.setAttribute("medicationtolist", medicationtolist);
				path = UtilConstants._VIEW_MEDICATION_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_MEDICATION_FAILED);
				path = UtilConstants._VIEW_MEDICATION;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._VIEW_MEDICATION_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
