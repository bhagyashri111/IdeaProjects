package com.patientportal.bean;

import java.io.Serializable;
import java.util.Date;
import java.sql.Blob;

public class UserdetailsTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userid;
	private String loginid;
	private String password;
	private String oldpassword;
	private String newpassword;
	private String fullname;
	private String dateofbirth;
	private String dateofregister;
	private String address;
	private String email;
	private String phone;
	private String status;
	private String role;
	private String specialtytype;
	private String squest;
	private String sanswer;

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofregister(String dateofregister) {
		this.dateofregister = dateofregister;
	}

	public String getDateofregister() {
		return dateofregister;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSpecialtytype() {
		if (specialtytype == null) {
			return "";
		}
		return specialtytype;
	}

	public void setSpecialtytype(String specialtytype) {
		this.specialtytype = specialtytype;
	}

	public String getSquest() {
		return squest;
	}

	public void setSquest(String squest) {
		this.squest = squest;
	}

	public String getSanswer() {
		return sanswer;
	}

	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}

}
