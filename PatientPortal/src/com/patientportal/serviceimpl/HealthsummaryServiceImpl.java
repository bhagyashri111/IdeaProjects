package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.HealthsummaryDaoImpl;
import com.patientportal.bean.HealthsummaryTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.HealthsummaryTO;

public class HealthsummaryServiceImpl {

	private static final long serialVersionUID = 1L;

	HealthsummaryDaoImpl healthsummaryDaoImpl = new HealthsummaryDaoImpl();
	boolean flag = false;

	public List<HealthsummaryTO> getHealthsummary() throws ConnectionException {
		return healthsummaryDaoImpl.viewHealthsummary();
	}

	public HealthsummaryTO getHealthsummary(Integer healthissueid)
			throws ConnectionException {
		return healthsummaryDaoImpl.viewHealthsummary(healthissueid);
	}

	public List<HealthsummaryTO> getPatientHealthsummary(Integer userid)
			throws ConnectionException {
		return healthsummaryDaoImpl.getPatientHealthsummary(userid);
	}

	public boolean addHealthsummary(HealthsummaryTO healthsummary)
			throws ConnectionException {
		return healthsummaryDaoImpl.addHealthsummaryDetails(healthsummary);
	}

	public boolean updateHealthsummary(Integer healthissueid,
			HealthsummaryTO healthsummary) throws ConnectionException {
		return healthsummaryDaoImpl.updateHealthsummary(healthissueid,
				healthsummary);
	}

	public boolean deleteHealthsummary(Integer healthissueid)
			throws ConnectionException {
		return healthsummaryDaoImpl.deleteHealthsummary(healthissueid);
	}
}
