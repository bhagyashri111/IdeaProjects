package com.patientportal.daoimpl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.patientportal.util.DateWrapper;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.HealthsummaryTO;

public class HealthsummaryDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public HealthsummaryDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addHealthsummaryDetails(HealthsummaryTO healthsummary) {
		try {
			preparedStatement = con
					.prepareStatement("insert into HEALTHSUMMARY values((select nvl(max(HEALTHISSUEID),1000)+1 from HEALTHSUMMARY),?,?, sysdate,?)");
			preparedStatement.setInt(1, healthsummary.getUseridref());
			preparedStatement.setString(2, healthsummary.getHealthissue());

			preparedStatement.setString(3, "No status");
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

	public List<HealthsummaryTO> viewHealthsummary() {
		List<HealthsummaryTO> listHealthsummary = new ArrayList<HealthsummaryTO>();
		HealthsummaryTO healthsummary = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from HEALTHSUMMARY");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				healthsummary = new HealthsummaryTO();
				healthsummary.setHealthissueid(resultSet.getInt(1));
				healthsummary.setUseridref(resultSet.getInt(2));
				healthsummary.setHealthissue(resultSet.getString(3));
				healthsummary.setDateofnote(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(4) + ""));
				healthsummary.setStatus(resultSet.getString(5));
				listHealthsummary.add(healthsummary);
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
		return listHealthsummary;
	}
	
	
	public List<HealthsummaryTO> getPatientHealthsummary(int userid) {
		List<HealthsummaryTO> listHealthsummary = new ArrayList<HealthsummaryTO>();
		HealthsummaryTO healthsummary = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from HEALTHSUMMARY where USERIDREF = "+userid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				healthsummary = new HealthsummaryTO();
				healthsummary.setHealthissueid(resultSet.getInt(1));
				healthsummary.setUseridref(resultSet.getInt(2));
				healthsummary.setHealthissue(resultSet.getString(3));
				healthsummary.setDateofnote(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(4) + ""));
				healthsummary.setStatus(resultSet.getString(5));
				listHealthsummary.add(healthsummary);
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
		return listHealthsummary;
	}

	public boolean updateHealthsummary(Integer healthissueid,
			HealthsummaryTO healthsummary) {
		try {
			preparedStatement = con
					.prepareStatement("update HEALTHSUMMARY set USERIDREF = ?, HEALTHISSUE = ?, DATEOFNOTE = ? where HEALTHISSUEID = ?");
			preparedStatement.setInt(1, healthsummary.getUseridref());
			preparedStatement.setString(2, healthsummary.getHealthissue());

			preparedStatement.setInt(3, healthsummary.getHealthissueid());
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

	public boolean deleteHealthsummary(Integer healthissueid) {
		try {
			preparedStatement = con
					.prepareStatement("delete HEALTHSUMMARY where HEALTHISSUEID = "
							+ healthissueid);
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

	public HealthsummaryTO viewHealthsummary(Integer healthissueid) {
		HealthsummaryTO healthsummary = new HealthsummaryTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from HEALTHSUMMARY where HEALTHISSUEID = "
							+ healthissueid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				healthsummary = new HealthsummaryTO();
				healthsummary.setHealthissueid(resultSet.getInt(1));
				healthsummary.setUseridref(resultSet.getInt(2));
				healthsummary.setHealthissue(resultSet.getString(3));
				healthsummary.setDateofnote(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(4) + ""));
				healthsummary.setStatus(resultSet.getString(5));
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
		return healthsummary;
	}

}
