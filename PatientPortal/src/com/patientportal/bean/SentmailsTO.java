package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class SentmailsTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer mailid;
	private Integer frommailidref;
	private Integer tomailidref;
	private String mailsub;
	private String mailbody;
	private String maildate;


	public void setMailid(Integer mailid){
		this.mailid = mailid;
	}
	public Integer getMailid(){
		return mailid;
	}


	public void setFrommailidref(Integer frommailidref){
		this.frommailidref = frommailidref;
	}
	public Integer getFrommailidref(){
		return frommailidref;
	}


	public void setTomailidref(Integer tomailidref){
		this.tomailidref = tomailidref;
	}
	public Integer getTomailidref(){
		return tomailidref;
	}


	public void setMailsub(String mailsub){
		this.mailsub = mailsub;
	}
	public String getMailsub(){
		return mailsub;
	}


	public void setMailbody(String mailbody){
		this.mailbody = mailbody;
	}
	public String getMailbody(){
		return mailbody;
	}


	public void setMaildate(String maildate){
		this.maildate = maildate;
	}
	public String getMaildate(){
		return maildate;
	}
}
