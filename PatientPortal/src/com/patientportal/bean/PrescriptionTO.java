package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class PrescriptionTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer prescriptionid;
	private Integer useridref;
	private String prescription;
	private String prescriptiondesc;
	private String prescriptiondate;
	private String additionnalinformation;
	private String status;


	public void setPrescriptionid(Integer prescriptionid){
		this.prescriptionid = prescriptionid;
	}
	public Integer getPrescriptionid(){
		return prescriptionid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setPrescription(String prescription){
		this.prescription = prescription;
	}
	public String getPrescription(){
		return prescription;
	}


	public void setPrescriptiondesc(String prescriptiondesc){
		this.prescriptiondesc = prescriptiondesc;
	}
	public String getPrescriptiondesc(){
		return prescriptiondesc;
	}


	public void setPrescriptiondate(String prescriptiondate){
		this.prescriptiondate = prescriptiondate;
	}
	public String getPrescriptiondate(){
		return prescriptiondate;
	}


	public void setAdditionnalinformation(String additionnalinformation){
		this.additionnalinformation = additionnalinformation;
	}
	public String getAdditionnalinformation(){
		return additionnalinformation;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
