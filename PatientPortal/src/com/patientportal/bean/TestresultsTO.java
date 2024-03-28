package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class TestresultsTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer testid;
	private Integer useridref;
	private String testname;
	private String testdescription;
	private String testresult;
	private String orderby;
	private String dateoftest;
	private String status;


	public void setTestid(Integer testid){
		this.testid = testid;
	}
	public Integer getTestid(){
		return testid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setTestname(String testname){
		this.testname = testname;
	}
	public String getTestname(){
		return testname;
	}


	public void setTestdescription(String testdescription){
		this.testdescription = testdescription;
	}
	public String getTestdescription(){
		return testdescription;
	}


	public void setTestresult(String testresult){
		this.testresult = testresult;
	}
	public String getTestresult(){
		return testresult;
	}


	public void setOrderby(String orderby){
		this.orderby = orderby;
	}
	public String getOrderby(){
		return orderby;
	}


	public void setDateoftest(String dateoftest){
		this.dateoftest = dateoftest;
	}
	public String getDateoftest(){
		return dateoftest;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
