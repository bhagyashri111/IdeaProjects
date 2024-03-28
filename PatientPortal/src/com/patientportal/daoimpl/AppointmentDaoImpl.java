package com.patientportal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.patientportal.bean.AppointmentTO;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.util.DateWrapper;

public class AppointmentDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public AppointmentDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addAppointmentDetails(AppointmentTO appointment) {
		try {
			preparedStatement = con
					.prepareStatement("insert into APPOINTMENT values((select nvl(max(APPOINTMENTID),1000)+1 from APPOINTMENT),?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, appointment.getUseridref());
			preparedStatement.setString(2, appointment.getWhattosee());
			preparedStatement.setString(3, appointment.getReasonforvisit());
			preparedStatement.setString(4, appointment.getPrefereddatefrom());
			preparedStatement.setString(5, appointment.getLoginid());
			preparedStatement.setString(6, appointment.getAvailabletimes());
			preparedStatement.setString(7, appointment
					.getAdditionnalinformation());
			preparedStatement.setString(8, "Request");
			int results = preparedStatement.executeUpdate();
			if (results > 0) {
				flag = true;
				con.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return flag;
		}
	}

	public List<AppointmentTO> viewAppointment() {
		List<AppointmentTO> listAppointment = new ArrayList<AppointmentTO>();
		AppointmentTO appointment = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from APPOINTMENT");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				appointment = new AppointmentTO();
				appointment.setAppointmentid(resultSet.getInt(1));
				appointment.setUseridref(resultSet.getInt(2));
				appointment.setWhattosee(resultSet.getString(3));
				appointment.setReasonforvisit(resultSet.getString(4));
				appointment.setPrefereddatefrom(resultSet.getString(5) + "");
				appointment.setLoginid(resultSet.getString(6) + "");
				appointment.setAvailabletimes(resultSet.getString(7));
				appointment.setAdditionnalinformation(resultSet.getString(8));
				appointment.setStatus(resultSet.getString(9));
				listAppointment.add(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return listAppointment;
	}

	public boolean updateAppointment(Integer appointmentid,
			AppointmentTO appointment) {
		try {
			preparedStatement = con
					.prepareStatement("update APPOINTMENT set USERIDREF = ?, WHATTOSEE = ?, REASONFORVISIT = ?, PREFEREDDATEFROM = ?, PREFEREDDATETO = ?, AVAILABLETIMES = ?, ADDITIONNALINFORMATION = ? where APPOINTMENTID = ?");
			preparedStatement.setInt(1, appointment.getUseridref());
			preparedStatement.setString(2, appointment.getWhattosee());
			preparedStatement.setString(3, appointment.getReasonforvisit());
			preparedStatement.setString(4, appointment.getPrefereddatefrom());
			preparedStatement.setString(5, appointment.getLoginid());
			preparedStatement.setString(6, appointment.getAvailabletimes());
			preparedStatement.setString(7, appointment
					.getAdditionnalinformation());

			preparedStatement.setInt(8, appointment.getAppointmentid());
			int results = preparedStatement.executeUpdate();
			if (results > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return flag;
		}
	}
	
	
	
	public boolean cancelAppointment(Integer appointmentid, String status) {
		try {
			preparedStatement = con
					.prepareStatement("update APPOINTMENT set status = '"+status+"' where APPOINTMENTID = ?");
			preparedStatement.setInt(1, appointmentid);
			int results = preparedStatement.executeUpdate();
			if (results > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return flag;
		}
	}
	
	
	
	public boolean cancelAppointment(Integer appointmentid,
			Integer userid) {
		try {
			preparedStatement = con
					.prepareStatement("update APPOINTMENT set status = 'Canceled' where APPOINTMENTID = ? and USERIDREF = ?");
			preparedStatement.setInt(1, appointmentid);
			preparedStatement.setInt(2, userid);
			int results = preparedStatement.executeUpdate();
			if (results > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return flag;
		}
	}
	
 


	public boolean deleteAppointment(Integer appointmentid) {
		try {
			preparedStatement = con
					.prepareStatement("delete APPOINTMENT where APPOINTMENTID = "
							+ appointmentid);
			int results = preparedStatement.executeUpdate();
			if (results > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return flag;
		}
	}

	public AppointmentTO viewAppointment(Integer appointmentid) {
		AppointmentTO appointment = new AppointmentTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from APPOINTMENT where APPOINTMENTID = "
							+ appointmentid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				appointment = new AppointmentTO();
				appointment.setAppointmentid(resultSet.getInt(1));
				appointment.setUseridref(resultSet.getInt(2));
				appointment.setWhattosee(resultSet.getString(3));
				appointment.setReasonforvisit(resultSet.getString(4));
				appointment.setPrefereddatefrom(resultSet.getString(5) + "");
				appointment.setLoginid(resultSet.getString(6) + "");
				appointment.setAvailabletimes(resultSet.getString(7));
				appointment.setAdditionnalinformation(resultSet.getString(8));
				appointment.setStatus(resultSet.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return appointment;
	}
	
	public List<AppointmentTO> viewMyAppointment(Integer userid) {

		List<AppointmentTO> listAppointment = new ArrayList<AppointmentTO>();
		AppointmentTO appointment =  null;;
		try {
			preparedStatement = con
					.prepareStatement("select * from APPOINTMENT where USERIDREF = "
							+ userid +" order by PREFEREDDATEFROM");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				appointment = new AppointmentTO();
				appointment.setAppointmentid(resultSet.getInt(1));
				appointment.setUseridref(resultSet.getInt(2));
				appointment.setWhattosee(resultSet.getString(3));
				appointment.setReasonforvisit(resultSet.getString(4));
				appointment.setPrefereddatefrom(resultSet.getString(5) + "");
				appointment.setLoginid(resultSet.getString(6) + "");
				appointment.setAvailabletimes(resultSet.getString(7));
				appointment.setAdditionnalinformation(resultSet.getString(8));
				appointment.setStatus(resultSet.getString(9));
				listAppointment.add(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return listAppointment;
	}
	
	
	public List<AppointmentTO> getDoctorAppointment(String userid) {

		List<AppointmentTO> listAppointment = new ArrayList<AppointmentTO>();
		AppointmentTO appointment =  null;;
		try {
			preparedStatement = con
					.prepareStatement("select * from APPOINTMENT where PREFEREDDATETO = '"
							+ userid +"' order by PREFEREDDATEFROM");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				appointment = new AppointmentTO();
				appointment.setAppointmentid(resultSet.getInt(1));
				appointment.setUseridref(resultSet.getInt(2));
				appointment.setWhattosee(resultSet.getString(3));
				appointment.setReasonforvisit(resultSet.getString(4));
				appointment.setPrefereddatefrom(resultSet.getString(5) + "");
				appointment.setLoginid(resultSet.getString(6) + "");
				appointment.setAvailabletimes(resultSet.getString(7));
				appointment.setAdditionnalinformation(resultSet.getString(8));
				appointment.setStatus(resultSet.getString(9));
				listAppointment.add(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return listAppointment;
	}
	
	
	
	public List<AppointmentTO> viewAppointment(String loginid) {
		List<AppointmentTO> listAppointment = new ArrayList<AppointmentTO>();
		AppointmentTO appointment = null;
		try {
			preparedStatement = con
			.prepareStatement("select * from APPOINTMENT where PREFEREDDATETO = "
					+ loginid +" order by PREFEREDDATEFROM");			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				appointment = new AppointmentTO();
				appointment.setAppointmentid(resultSet.getInt(1));
				appointment.setUseridref(resultSet.getInt(2));
				appointment.setWhattosee(resultSet.getString(3));
				appointment.setReasonforvisit(resultSet.getString(4));
				appointment.setPrefereddatefrom(resultSet.getString(5) + "");
				appointment.setLoginid(resultSet.getString(6) + "");
				appointment.setAvailabletimes(resultSet.getString(7));
				appointment.setAdditionnalinformation(resultSet.getString(8));
				appointment.setStatus(resultSet.getString(9));
				listAppointment.add(appointment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception raised" + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Exception raised" + e);
			}
		}
		return listAppointment;
}
}
