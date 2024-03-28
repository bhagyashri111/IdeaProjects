package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.MedicationDaoImpl;
import com.patientportal.bean.MedicationTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.MedicationTO;

public class MedicationServiceImpl {

	private static final long serialVersionUID = 1L;

	MedicationDaoImpl medicationDaoImpl = new MedicationDaoImpl();
	boolean flag = false;

	public List<MedicationTO> getPatientMedication(String patient) throws ConnectionException {
		return medicationDaoImpl.getPatientMedication(patient);
	}

	public List<MedicationTO> getMyMedication(int userid)
			throws ConnectionException {
		return medicationDaoImpl.getMyMedication(userid);
	}

	public MedicationTO getMedication(Integer medicationid)
			throws ConnectionException {
		return medicationDaoImpl.viewMedication(medicationid);
	}

	public boolean addMedication(MedicationTO medication)
			throws ConnectionException {
		return medicationDaoImpl.addMedicationDetails(medication);
	}

	public boolean updateMedication(Integer medicationid,
			MedicationTO medication) throws ConnectionException {
		return medicationDaoImpl.updateMedication(medicationid, medication);
	}

	public boolean deleteMedication(Integer medicationid)
			throws ConnectionException {
		return medicationDaoImpl.deleteMedication(medicationid);
	}
}
