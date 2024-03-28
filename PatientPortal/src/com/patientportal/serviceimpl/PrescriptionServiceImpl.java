package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.PrescriptionDaoImpl;
import com.patientportal.bean.PrescriptionTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.PrescriptionTO;

public class PrescriptionServiceImpl {

	private static final long serialVersionUID = 1L;

	PrescriptionDaoImpl prescriptionDaoImpl = new PrescriptionDaoImpl();
	boolean flag = false;

	public List<PrescriptionTO> getPrescription() throws ConnectionException {
		return prescriptionDaoImpl.viewPrescription();
	}
	
	public List<PrescriptionTO> getPatientPrescription(String patientid) throws ConnectionException {
		return prescriptionDaoImpl.getPatientPrescription(patientid);
	}
	
	
	public PrescriptionTO getPrescription(Integer prescriptionid)
			throws ConnectionException {
		return prescriptionDaoImpl.viewPrescription(prescriptionid);
	}

	public boolean addPrescription(PrescriptionTO prescription)
			throws ConnectionException {
		return prescriptionDaoImpl.addPrescriptionDetails(prescription);
	}
	
	public boolean addPrescription(int prescription,int userid) throws ConnectionException {
		return prescriptionDaoImpl.addPrescriptionDetails( prescription,userid);
	}

	public boolean updatePrescription(Integer prescriptionid,
			PrescriptionTO prescription) throws ConnectionException {
		return prescriptionDaoImpl.updatePrescription(prescriptionid,
				prescription);
	}

	public boolean deletePrescription(Integer prescriptionid)
			throws ConnectionException {
		return prescriptionDaoImpl.deletePrescription(prescriptionid);
	}
}
