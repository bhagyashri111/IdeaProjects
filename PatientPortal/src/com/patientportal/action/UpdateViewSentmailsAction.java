package com.patientportal.action;
import java.io.IOException; 
import java.util.List; 
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

public class UpdateViewSentmailsAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		SentmailsTO sentmailsto = null;
		String path = "";
		try {
			sentmailsto = new SentmailsServiceImpl().getSentmails(Integer.parseInt(request.getParameter(UtilConstants._MAILID)));


			if (sentmailsto != null) {
				request.setAttribute("sent_mails", sentmailsto);
				path = UtilConstants._UPDATE_VIEW_SENTMAILS_JSP;
			} else {
				request.setAttribute(UtilConstants._STATUS,
						UtilConstants._VIEW_SENTMAILS_FAILED);
				path = UtilConstants._VIEW_SENTMAILS;
			}
		}
		catch (ConnectionException e) {
			request.setAttribute(UtilConstants._STATUS,e.getMessage());
			path=UtilConstants._STATUS_PATH;
		}
			catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(UtilConstants._STATUS, UtilConstants._VIEW_SENTMAILS_FAILED);
			path = UtilConstants._STATUS_PATH;
		}finally{
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
