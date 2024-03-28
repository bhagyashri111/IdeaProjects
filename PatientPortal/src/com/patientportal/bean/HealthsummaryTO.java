package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class HealthsummaryTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer healthissueid;
	private Integer useridref;
	private String healthissue;
	private String dateofnote;
	private String status;


	public void setHealthissueid(Integer healthissueid){
		this.healthissueid = healthissueid;
	}
	public Integer getHealthissueid(){
		return healthissueid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setHealthissue(String healthissue){
		this.healthissue = healthissue;
	}
	public String getHealthissue(){
		return healthissue;
	}


	public void setDateofnote(String dateofnote){
		this.dateofnote = dateofnote;
	}
	public String getDateofnote(){
		return dateofnote;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
