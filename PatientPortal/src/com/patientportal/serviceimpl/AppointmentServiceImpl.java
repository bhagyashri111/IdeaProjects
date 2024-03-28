package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.AppointmentDaoImpl;
import com.patientportal.bean.AppointmentTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.AppointmentTO;

public class AppointmentServiceImpl {

	private static final long serialVersionUID = 1L;

	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	boolean flag = false;

	public List<AppointmentTO> getAppointment() throws ConnectionException {
		return appointmentDaoImpl.viewAppointment();
	}

	public List<AppointmentTO> viewMyAppointment(Integer userid) throws ConnectionException {
		return appointmentDaoImpl.viewMyAppointment(userid);
	}
	
	public List<AppointmentTO> getMyAppointment(Integer userid) throws ConnectionException {
		return appointmentDaoImpl.viewMyAppointment(userid);
	}
	
	public List<AppointmentTO> getDoctorAppointment(String userid) throws ConnectionException {
		return appointmentDaoImpl.getDoctorAppointment(userid);
	}
	
	
	public AppointmentTO getAppointment(Integer appointmentid)
			throws ConnectionException {
		return appointmentDaoImpl.viewAppointment(appointmentid);
	}
	
	

	public boolean addAppointment(AppointmentTO appointment)
			throws ConnectionException {
		return appointmentDaoImpl.addAppointmentDetails(appointment);
	}

	public boolean updateAppointment(Integer appointmentid,
			AppointmentTO appointment) throws ConnectionException {
		return appointmentDaoImpl.updateAppointment(appointmentid, appointment);
	}
	
	public boolean cancelAppointment(Integer appointmentid,
			Integer userid) throws ConnectionException {
		return appointmentDaoImpl.cancelAppointment(appointmentid, userid);
	}
	
	
	
	public boolean cancelAppointment(Integer appointmentid, String status) throws ConnectionException {
		return appointmentDaoImpl.cancelAppointment(appointmentid, status);
	}
	 
	
	
	public boolean deleteAppointment(Integer appointmentid)
			throws ConnectionException {
		return appointmentDaoImpl.deleteAppointment(appointmentid);
	}
}
