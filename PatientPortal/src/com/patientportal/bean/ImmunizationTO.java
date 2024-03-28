package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class ImmunizationTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer immunizationid;
	private Integer useridref;
	private String immunization;
	private String allergiedesc;
	private String allergieintruction;
	private String dateofimmunization;
	private String status;


	public void setImmunizationid(Integer immunizationid){
		this.immunizationid = immunizationid;
	}
	public Integer getImmunizationid(){
		return immunizationid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setImmunization(String immunization){
		this.immunization = immunization;
	}
	public String getImmunization(){
		return immunization;
	}


	public void setAllergiedesc(String allergiedesc){
		this.allergiedesc = allergiedesc;
	}
	public String getAllergiedesc(){
		return allergiedesc;
	}


	public void setAllergieintruction(String allergieintruction){
		this.allergieintruction = allergieintruction;
	}
	public String getAllergieintruction(){
		return allergieintruction;
	}


	public void setDateofimmunization(String dateofimmunization){
		this.dateofimmunization = dateofimmunization;
	}
	public String getDateofimmunization(){
		return dateofimmunization;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
