package com.patientportal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.patientportal.bean.MedicationTO;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.util.DateWrapper;

public class MedicationDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public MedicationDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addMedicationDetails(MedicationTO medication) {
		try {
			preparedStatement = con
					.prepareStatement("insert into MEDICATION values((select nvl(max(MEDICATIONID),1000)+1 from MEDICATION),?,?,?,?, sysdate,?)");
			preparedStatement.setInt(1, medication.getUseridref());
			preparedStatement.setString(2, medication.getMedicationname());
			preparedStatement.setString(3, medication.getMedicationdesc());
			preparedStatement
					.setString(4, medication.getMedicationintruction());

			preparedStatement.setString(5, medication.getStatus());
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

	public List<MedicationTO> viewMedication() {
		List<MedicationTO> listMedication = new ArrayList<MedicationTO>();
		MedicationTO medication = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from MEDICATION");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medication = new MedicationTO();
				medication.setMedicationid(resultSet.getInt(1));
				medication.setUseridref(resultSet.getInt(2));
				medication.setMedicationname(resultSet.getString(3));
				medication.setMedicationdesc(resultSet.getString(4));
				medication.setMedicationintruction(resultSet.getString(5));
				medication.setDateofmedication(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				medication.setStatus(resultSet.getString(7));
				listMedication.add(medication);
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
		return listMedication;
	}
	
	
	public List<MedicationTO> getPatientMedication(String patient) {
		List<MedicationTO> listMedication = new ArrayList<MedicationTO>();
		
		int userid = new UserdetailsDaoImpl().getUserid(patient);
		System.out.println(patient);
		System.out.println(userid);
		
		MedicationTO medication = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from MEDICATION where USERIDREF = "+userid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medication = new MedicationTO();
				medication.setMedicationid(resultSet.getInt(1));
				medication.setUseridref(resultSet.getInt(2));
				medication.setMedicationname(resultSet.getString(3));
				medication.setMedicationdesc(resultSet.getString(4));
				medication.setMedicationintruction(resultSet.getString(5));
				medication.setDateofmedication(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				medication.setStatus(resultSet.getString(7));
				listMedication.add(medication);
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
		return listMedication;
	}
	
	

	public boolean updateMedication(Integer medicationid,
			MedicationTO medication) {
		try {
			preparedStatement = con
					.prepareStatement("update MEDICATION set USERIDREF = ?, MEDICATIONNAME = ?, MEDICATIONDESC = ?, MEDICATIONINTRUCTION = ?, DATEOFMEDICATION = ? where MEDICATIONID = ?");
			preparedStatement.setInt(1, medication.getUseridref());
			preparedStatement.setString(2, medication.getMedicationname());
			preparedStatement.setString(3, medication.getMedicationdesc());
			preparedStatement
					.setString(4, medication.getMedicationintruction());

			preparedStatement.setInt(5, medication.getMedicationid());
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

	public boolean deleteMedication(Integer medicationid) {
		try {
			preparedStatement = con
					.prepareStatement("delete MEDICATION where MEDICATIONID = "
							+ medicationid);
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

	public MedicationTO viewMedication(Integer medicationid) {
		MedicationTO medication = new MedicationTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from MEDICATION where MEDICATIONID = "
							+ medicationid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				medication = new MedicationTO();
				medication.setMedicationid(resultSet.getInt(1));
				medication.setUseridref(resultSet.getInt(2));
				medication.setMedicationname(resultSet.getString(3));
				medication.setMedicationdesc(resultSet.getString(4));
				medication.setMedicationintruction(resultSet.getString(5));
				medication.setDateofmedication(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				medication.setStatus(resultSet.getString(7));
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
		return medication;
	}

	public List<MedicationTO> getMyMedication(Integer userid) {

		List<MedicationTO> list = new ArrayList<MedicationTO>();
		MedicationTO medication = new MedicationTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from MEDICATION where USERIDREF = "
							+ userid + " order by DATEOFMEDICATION");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				medication = new MedicationTO();
				medication.setMedicationid(resultSet.getInt(1));
				medication.setUseridref(resultSet.getInt(2));
				medication.setMedicationname(resultSet.getString(3));
				medication.setMedicationdesc(resultSet.getString(4));
				medication.setMedicationintruction(resultSet.getString(5));
				medication.setDateofmedication(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				medication.setStatus(resultSet.getString(7));
				list.add(medication);
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
		return list;
	}

}
