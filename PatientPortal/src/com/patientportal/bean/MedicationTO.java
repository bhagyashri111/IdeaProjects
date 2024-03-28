package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class MedicationTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer medicationid;
	private Integer useridref;
	private String medicationname;
	private String medicationdesc;
	private String medicationintruction;
	private String dateofmedication;
	private String status;


	public void setMedicationid(Integer medicationid){
		this.medicationid = medicationid;
	}
	public Integer getMedicationid(){
		return medicationid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setMedicationname(String medicationname){
		this.medicationname = medicationname;
	}
	public String getMedicationname(){
		return medicationname;
	}


	public void setMedicationdesc(String medicationdesc){
		this.medicationdesc = medicationdesc;
	}
	public String getMedicationdesc(){
		return medicationdesc;
	}


	public void setMedicationintruction(String medicationintruction){
		this.medicationintruction = medicationintruction;
	}
	public String getMedicationintruction(){
		return medicationintruction;
	}


	public void setDateofmedication(String dateofmedication){
		this.dateofmedication = dateofmedication;
	}
	public String getDateofmedication(){
		return dateofmedication;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
