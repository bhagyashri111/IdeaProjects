package com.patientportal.util;
import java.io.IOException; 
import java.io.InputStream; 
import java.util.Properties; 
import javax.servlet.ServletConfig; 
import javax.servlet.ServletContext; 
import javax.servlet.http.HttpServlet; 
import com.patientportal.dao.AbstractDataAccessObject; 
import com.patientportal.util.LoggerManager; 

public class InitServlet extends HttpServlet { 
	/** 
	 *  
	 */ 
	private static final long serialVersionUID = 1L; 
	AbstractDataAccessObject dobject; 
	public void init(ServletConfig sc) 
		{ 
		ServletContext ctx = sc.getServletContext(); 
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config")); 
		Properties props = new Properties(); 
		 
		try 
		{ 
			props.load(fis); 
		} 
		catch (IOException ioe) 
	{ 
			ioe.printStackTrace(); 
		} 
		dobject = new AbstractDataAccessObject(); 
		dobject.setProperties(props); 
		LoggerManager.logger = new LoggerManager().getLogger(props.getProperty("logfile")); 
		LoggerManager.writeLogInfo("Logger Instantiated"); 
		} 
} 
