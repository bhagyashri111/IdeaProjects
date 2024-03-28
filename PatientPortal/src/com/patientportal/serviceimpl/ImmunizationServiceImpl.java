package com.patientportal.serviceimpl;

import java.util.List;

import com.patientportal.bean.ImmunizationTO;
import com.patientportal.daoimpl.ImmunizationDaoImpl;
import com.patientportal.exception.ConnectionException;

public class ImmunizationServiceImpl {

	private static final long serialVersionUID = 1L;

	ImmunizationDaoImpl immunizationDaoImpl = new ImmunizationDaoImpl();
	boolean flag = false;

	public List<ImmunizationTO> getImmunization() throws ConnectionException {
		return immunizationDaoImpl.viewImmunization();
	}

	public List<ImmunizationTO> getPatientImmunization(int userid)
			throws ConnectionException {
		return immunizationDaoImpl.getPatientImmunization(userid);
	}

	public ImmunizationTO getImmunization(Integer immunizationid)
			throws ConnectionException {
		return immunizationDaoImpl.viewImmunization(immunizationid);
	}

	public boolean addImmunization(ImmunizationTO immunization)
			throws ConnectionException {
		return immunizationDaoImpl.addImmunizationDetails(immunization);
	}

	public boolean updateImmunization(Integer immunizationid,
			ImmunizationTO immunization) throws ConnectionException {
		return immunizationDaoImpl.updateImmunization(immunizationid,
				immunization);
	}

	public boolean deleteImmunization(Integer immunizationid)
			throws ConnectionException {
		return immunizationDaoImpl.deleteImmunization(immunizationid);
	}
}
