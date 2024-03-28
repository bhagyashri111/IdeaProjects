package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.UserdetailsDaoImpl;
import com.patientportal.bean.UserdetailsTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.UserdetailsTO;

public class UserdetailsServiceImpl {

	private static final long serialVersionUID = 1L;

	UserdetailsDaoImpl userdetailsDaoImpl = new UserdetailsDaoImpl();
	boolean flag = false;

	public List<UserdetailsTO> getUserdetails(String role)
			throws ConnectionException {
		return userdetailsDaoImpl.viewUserdetails(role);
	}

	public UserdetailsTO getUserdetails(Integer userid)
			throws ConnectionException {
		return userdetailsDaoImpl.viewUserdetails(userid);
	}

	public boolean addUserdetails(UserdetailsTO userdetails)
			throws ConnectionException {
		return userdetailsDaoImpl.addUserdetailsDetails(userdetails);
	}

	public boolean updateUserdetails(Integer userid, UserdetailsTO userdetails)
			throws ConnectionException {
		return userdetailsDaoImpl.updateUserdetails(userid, userdetails);
	}

	public boolean deleteUserdetails(Integer userid) throws ConnectionException {
		return userdetailsDaoImpl.deleteUserdetails(userid);
	}
}
