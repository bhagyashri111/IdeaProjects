package com.patientportal.bean;
import java.io.Serializable; 
import java.util.Date; 
import java.sql.Blob; 

public class AllergiesTO implements Serializable {


	private static final long serialVersionUID = 1L;



	private Integer allergieid;
	private Integer useridref;
	private String allergietype;
	private String allergiedesc;
	private String allergieintruction;
	private String dateofallergie;
	private String status;


	public void setAllergieid(Integer allergieid){
		this.allergieid = allergieid;
	}
	public Integer getAllergieid(){
		return allergieid;
	}


	public void setUseridref(Integer useridref){
		this.useridref = useridref;
	}
	public Integer getUseridref(){
		return useridref;
	}


	public void setAllergietype(String allergietype){
		this.allergietype = allergietype;
	}
	public String getAllergietype(){
		return allergietype;
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


	public void setDateofallergie(String dateofallergie){
		this.dateofallergie = dateofallergie;
	}
	public String getDateofallergie(){
		return dateofallergie;
	}


	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}
