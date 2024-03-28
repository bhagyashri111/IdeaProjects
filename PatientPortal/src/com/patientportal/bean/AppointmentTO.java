package com.patientportal.bean;

import java.io.Serializable;
import java.util.Date;
import java.sql.Blob;

public class AppointmentTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer appointmentid;
	private Integer useridref;
	private String whattosee;
	private String reasonforvisit;
	private String prefereddatefrom;
	private String loginid;
	private String availabletimes;
	private String additionnalinformation;
	private String status;

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setUseridref(Integer useridref) {
		this.useridref = useridref;
	}

	public Integer getUseridref() {
		return useridref;
	}

	public void setWhattosee(String whattosee) {
		this.whattosee = whattosee;
	}

	public String getWhattosee() {
		return whattosee;
	}

	public void setReasonforvisit(String reasonforvisit) {
		this.reasonforvisit = reasonforvisit;
	}

	public String getReasonforvisit() {
		return reasonforvisit;
	}

	public void setPrefereddatefrom(String prefereddatefrom) {
		this.prefereddatefrom = prefereddatefrom;
	}

	public String getPrefereddatefrom() {
		return prefereddatefrom;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAvailabletimes(String availabletimes) {
		this.availabletimes = availabletimes;
	}

	public String getAvailabletimes() {
		return availabletimes;
	}

	public void setAdditionnalinformation(String additionnalinformation) {
		this.additionnalinformation = additionnalinformation;
	}

	public String getAdditionnalinformation() {
		return additionnalinformation;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
