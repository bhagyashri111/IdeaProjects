package com.patientportal.serviceimpl;

import java.util.List;

import com.patientportal.bean.AllergiesTO;
import com.patientportal.daoimpl.AllergiesDaoImpl;
import com.patientportal.exception.ConnectionException;

public class AllergiesServiceImpl {

	private static final long serialVersionUID = 1L;

	AllergiesDaoImpl allergiesDaoImpl = new AllergiesDaoImpl();
	boolean flag = false;

	public List<AllergiesTO> getAllergies() throws ConnectionException {
		return allergiesDaoImpl.viewAllergies();
	}
	
	public List<AllergiesTO> getPatientAllergies(int userid) throws ConnectionException {
		return allergiesDaoImpl.viewPatientAllergies(userid);
	}
	
	public AllergiesTO getAllergies(Integer allergieid)
			throws ConnectionException {
		return allergiesDaoImpl.viewAllergies(allergieid);
	}

	public boolean addAllergies(AllergiesTO allergies)
			throws ConnectionException {
		return allergiesDaoImpl.addAllergiesDetails(allergies);
	}

	public boolean updateAllergies(Integer allergieid, AllergiesTO allergies)
			throws ConnectionException {
		return allergiesDaoImpl.updateAllergies(allergieid, allergies);
	}

	public boolean deleteAllergies(Integer allergieid)
			throws ConnectionException {
		return allergiesDaoImpl.deleteAllergies(allergieid);
	}
}
