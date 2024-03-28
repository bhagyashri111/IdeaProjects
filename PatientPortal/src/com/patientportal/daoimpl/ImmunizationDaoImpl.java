package com.patientportal.daoimpl;
import java.sql.*; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Date; 

import com.patientportal.util.DateWrapper; 
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.ImmunizationTO;

public class ImmunizationDaoImpl {


	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;



	public ImmunizationDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}
	public boolean addImmunizationDetails(ImmunizationTO immunization) {
		try {
		preparedStatement = con.prepareStatement("insert into IMMUNIZATION values((select nvl(max(IMMUNIZATIONID),1000)+1 from IMMUNIZATION),?,?,?,?, sysdate,?)");
		preparedStatement.setInt(1,immunization.getUseridref());
		preparedStatement.setString(2,immunization.getImmunization());
		preparedStatement.setString(3,immunization.getAllergiedesc());
		preparedStatement.setString(4,immunization.getAllergieintruction());

		preparedStatement.setString(5,immunization.getStatus());
			int results = preparedStatement.executeUpdate();
			if(results>0){
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

	
	
	public List<ImmunizationTO> getPatientImmunization(int userid) {
		List<ImmunizationTO> listImmunization = new ArrayList<ImmunizationTO>();
		ImmunizationTO immunization = null;
		try {
			preparedStatement = con.prepareStatement("select * from IMMUNIZATION where USERIDREF = "+userid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				immunization = new ImmunizationTO();
				immunization.setImmunizationid(resultSet.getInt(1));
				immunization.setUseridref(resultSet.getInt(2));
				immunization.setImmunization(resultSet.getString(3));
				immunization.setAllergiedesc(resultSet.getString(4));
				immunization.setAllergieintruction(resultSet.getString(5));
				immunization.setDateofimmunization(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
				immunization.setStatus(resultSet.getString(7));
			listImmunization.add(immunization);
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
		return listImmunization;
	}


			public List<ImmunizationTO> viewImmunization() {
				List<ImmunizationTO> listImmunization = new ArrayList<ImmunizationTO>();
				ImmunizationTO immunization = null;
				try {
					preparedStatement = con.prepareStatement("select * from IMMUNIZATION");
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						immunization = new ImmunizationTO();
						immunization.setImmunizationid(resultSet.getInt(1));
						immunization.setUseridref(resultSet.getInt(2));
						immunization.setImmunization(resultSet.getString(3));
						immunization.setAllergiedesc(resultSet.getString(4));
						immunization.setAllergieintruction(resultSet.getString(5));
						immunization.setDateofimmunization(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
						immunization.setStatus(resultSet.getString(7));
					listImmunization.add(immunization);
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
				return listImmunization;
			}

	public boolean updateImmunization(Integer immunizationid, ImmunizationTO immunization) {
		try {
		preparedStatement = con.prepareStatement("update IMMUNIZATION set USERIDREF = ?, IMMUNIZATION = ?, ALLERGIEDESC = ?, ALLERGIEINTRUCTION = ?, DATEOFIMMUNIZATION = ? where IMMUNIZATIONID = ?");
		preparedStatement.setInt(1,immunization.getUseridref());
		preparedStatement.setString(2,immunization.getImmunization());
		preparedStatement.setString(3,immunization.getAllergiedesc());
		preparedStatement.setString(4,immunization.getAllergieintruction());


		preparedStatement.setInt(5,immunization.getImmunizationid());
			int results = preparedStatement.executeUpdate();
			if(results>0){
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
	public boolean deleteImmunization(Integer immunizationid) {
		try {
		preparedStatement = con.prepareStatement("delete IMMUNIZATION where IMMUNIZATIONID = "+immunizationid);
			int results = preparedStatement.executeUpdate();
			if(results>0){
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


			public ImmunizationTO viewImmunization(Integer immunizationid) {
				ImmunizationTO immunization = new ImmunizationTO();
				try {
					preparedStatement = con.prepareStatement("select * from IMMUNIZATION where IMMUNIZATIONID = "+immunizationid);
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						immunization = new ImmunizationTO();
							immunization.setImmunizationid(resultSet.getInt(1));
							immunization.setUseridref(resultSet.getInt(2));
							immunization.setImmunization(resultSet.getString(3));
							immunization.setAllergiedesc(resultSet.getString(4));
							immunization.setAllergieintruction(resultSet.getString(5));
							immunization.setDateofimmunization(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
							immunization.setStatus(resultSet.getString(7));
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
				return immunization;
			}

  }
