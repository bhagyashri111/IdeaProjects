package com.patientportal.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.patientportal.bean.UserdetailsTO;
import com.patientportal.daoimpl.SecurityDaoImpl;
import com.patientportal.util.LoggerManager;

public class RecoverPasswordAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "Recoverpasswordfprm.jsp?status=<font color=red>Entries not Matched... Try Again</font>";;
	      try{
	    	  UserdetailsTO rb=new UserdetailsTO();
	          String loginid=request.getParameter("username");
	          String sanswer=request.getParameter("sanswer");
	          String squest=request.getParameter("squest");
	          rb.setLoginid(loginid);
	          rb.setSquest(squest);
	          rb.setSanswer(sanswer);    
	          String password=new SecurityDaoImpl().recoverPasswordByQuestion(rb);
	          if(password.equals("") || password==null){
	              target="home.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
	              request.setAttribute("status", "Entries not Matched... Try Again");
	          }
	          else{
	        	   request.setAttribute("status"," Password is '"+password+"'");
	             target="home.jsp?status=Password is  <font color=green>"+password+"</font>";}
	        }
	        catch(Exception e)
	        {
	           LoggerManager.writeLogSevere(e);
	        }
	        RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request,response);
	  
	}

}
