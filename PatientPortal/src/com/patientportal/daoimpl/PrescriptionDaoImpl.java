package com.patientportal.daoimpl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.patientportal.util.DateWrapper;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.PrescriptionTO;

public class PrescriptionDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public PrescriptionDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addPrescriptionDetails(PrescriptionTO prescription) {
		try {
			preparedStatement = con
					.prepareStatement("insert into PRESCRIPTION values((select nvl(max(PRESCRIPTIONID),1000)+1 from PRESCRIPTION),?,?,?, sysdate,?,?)");
			preparedStatement.setInt(1, prescription.getUseridref());
			preparedStatement.setString(2, prescription.getPrescription());
			preparedStatement.setString(3, prescription.getPrescriptiondesc());

			preparedStatement.setString(4, prescription
					.getAdditionnalinformation());
			preparedStatement.setString(5, prescription.getStatus());
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

	public boolean addPrescriptionDetails(int medicationid, int userid) {
		try {

			preparedStatement = con
					.prepareStatement("select * from MEDICATION where MEDICATIONID = ?");
			preparedStatement.setInt(1, medicationid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				PreparedStatement	preparedStatement1 = con
						.prepareStatement("insert into PRESCRIPTION values((select nvl(max(PRESCRIPTIONID),1000)+1 from PRESCRIPTION),?,?,?, sysdate,?,?)");
				preparedStatement1.setInt(1, resultSet.getInt(2));
				preparedStatement1.setString(2, resultSet.getString(3));
				preparedStatement1.setString(3, resultSet.getString(4));
				preparedStatement1.setString(4, resultSet.getString(5));
				preparedStatement1.setString(5, "Renewal Request");
				int results = preparedStatement1.executeUpdate();
				if (results > 0) {
					flag = true;
					con.commit();
				}
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

	public List<PrescriptionTO> getPatientPrescription(String patientid) {
		List<PrescriptionTO> listPrescription = new ArrayList<PrescriptionTO>();
		PrescriptionTO prescription = null;
		
		int userid = new UserdetailsDaoImpl().getUserid(patientid);
		try {
			preparedStatement = con
					.prepareStatement("select * from PRESCRIPTION where useridref = "+userid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				prescription = new PrescriptionTO();
				prescription.setPrescriptionid(resultSet.getInt(1));
				prescription.setUseridref(resultSet.getInt(2));
				prescription.setPrescription(resultSet.getString(3));
				prescription.setPrescriptiondesc(resultSet.getString(4));
				prescription.setPrescriptiondate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				prescription.setAdditionnalinformation(resultSet.getString(6));
				prescription.setStatus(resultSet.getString(7));
				listPrescription.add(prescription);
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
		return listPrescription;
	}
	
	
	public List<PrescriptionTO> viewPrescription() {
		List<PrescriptionTO> listPrescription = new ArrayList<PrescriptionTO>();
		PrescriptionTO prescription = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from PRESCRIPTION");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				prescription = new PrescriptionTO();
				prescription.setPrescriptionid(resultSet.getInt(1));
				prescription.setUseridref(resultSet.getInt(2));
				prescription.setPrescription(resultSet.getString(3));
				prescription.setPrescriptiondesc(resultSet.getString(4));
				prescription.setPrescriptiondate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				prescription.setAdditionnalinformation(resultSet.getString(6));
				prescription.setStatus(resultSet.getString(7));
				listPrescription.add(prescription);
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
		return listPrescription;
	}

	public boolean updatePrescription(Integer prescriptionid,
			PrescriptionTO prescription) {
		try {
			preparedStatement = con
					.prepareStatement("update PRESCRIPTION set USERIDREF = ?, PRESCRIPTION = ?, PRESCRIPTIONDESC = ?, PRESCRIPTIONDATE = ?, ADDITIONNALINFORMATION = ? where PRESCRIPTIONID = ?");
			preparedStatement.setInt(1, prescription.getUseridref());
			preparedStatement.setString(2, prescription.getPrescription());
			preparedStatement.setString(3, prescription.getPrescriptiondesc());

			preparedStatement.setString(4, prescription
					.getAdditionnalinformation());

			preparedStatement.setInt(5, prescription.getPrescriptionid());
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

	public boolean deletePrescription(Integer prescriptionid) {
		try {
			preparedStatement = con
					.prepareStatement("delete PRESCRIPTION where PRESCRIPTIONID = "
							+ prescriptionid);
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

	public PrescriptionTO viewPrescription(Integer prescriptionid) {
		PrescriptionTO prescription = new PrescriptionTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from PRESCRIPTION where PRESCRIPTIONID = "
							+ prescriptionid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				prescription = new PrescriptionTO();
				prescription.setPrescriptionid(resultSet.getInt(1));
				prescription.setUseridref(resultSet.getInt(2));
				prescription.setPrescription(resultSet.getString(3));
				prescription.setPrescriptiondesc(resultSet.getString(4));
				prescription.setPrescriptiondate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				prescription.setAdditionnalinformation(resultSet.getString(6));
				prescription.setStatus(resultSet.getString(7));
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
		return prescription;
	}

}
