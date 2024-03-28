package com.patientportal.daoimpl;
import java.sql.*; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Date; 

import com.patientportal.util.DateWrapper; 
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.AllergiesTO;

public class AllergiesDaoImpl {


	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;



	public AllergiesDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}
	public boolean addAllergiesDetails(AllergiesTO allergies) {
		try {
		preparedStatement = con.prepareStatement("insert into ALLERGIES values((select nvl(max(ALLERGIEID),1000)+1 from ALLERGIES),?,?,?,?, sysdate,?)");
		preparedStatement.setInt(1,allergies.getUseridref());
		preparedStatement.setString(2,allergies.getAllergietype());
		preparedStatement.setString(3,allergies.getAllergiedesc());
		preparedStatement.setString(4,allergies.getAllergieintruction());

		preparedStatement.setString(5,allergies.getStatus());
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


			public List<AllergiesTO> viewAllergies() {
				List<AllergiesTO> listAllergies = new ArrayList<AllergiesTO>();
				AllergiesTO allergies = null;
				try {
					preparedStatement = con.prepareStatement("select * from ALLERGIES");
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						allergies = new AllergiesTO();
						allergies.setAllergieid(resultSet.getInt(1));
						allergies.setUseridref(resultSet.getInt(2));
						allergies.setAllergietype(resultSet.getString(3));
						allergies.setAllergiedesc(resultSet.getString(4));
						allergies.setAllergieintruction(resultSet.getString(5));
						allergies.setDateofallergie(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
						allergies.setStatus(resultSet.getString(7));
					listAllergies.add(allergies);
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
				return listAllergies;
			}

			public List<AllergiesTO> viewPatientAllergies(int userid) {
				List<AllergiesTO> listAllergies = new ArrayList<AllergiesTO>();
				AllergiesTO allergies = null;
				try {
					preparedStatement = con.prepareStatement("select * from ALLERGIES where USERIDREF = "+userid);
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						allergies = new AllergiesTO();
						allergies.setAllergieid(resultSet.getInt(1));
						allergies.setUseridref(resultSet.getInt(2));
						allergies.setAllergietype(resultSet.getString(3));
						allergies.setAllergiedesc(resultSet.getString(4));
						allergies.setAllergieintruction(resultSet.getString(5));
						allergies.setDateofallergie(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
						allergies.setStatus(resultSet.getString(7));
					listAllergies.add(allergies);
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
				return listAllergies;
			}

			
			
	public boolean updateAllergies(Integer allergieid, AllergiesTO allergies) {
		try {
		preparedStatement = con.prepareStatement("update ALLERGIES set USERIDREF = ?, ALLERGIETYPE = ?, ALLERGIEDESC = ?, ALLERGIEINTRUCTION = ?, DATEOFALLERGIE = ? where ALLERGIEID = ?");
		preparedStatement.setInt(1,allergies.getUseridref());
		preparedStatement.setString(2,allergies.getAllergietype());
		preparedStatement.setString(3,allergies.getAllergiedesc());
		preparedStatement.setString(4,allergies.getAllergieintruction());


		preparedStatement.setInt(5,allergies.getAllergieid());
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
	public boolean deleteAllergies(Integer allergieid) {
		try {
		preparedStatement = con.prepareStatement("delete ALLERGIES where ALLERGIEID = "+allergieid);
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


			public AllergiesTO viewAllergies(Integer allergieid) {
				AllergiesTO allergies = new AllergiesTO();
				try {
					preparedStatement = con.prepareStatement("select * from ALLERGIES where ALLERGIEID = "+allergieid);
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						allergies = new AllergiesTO();
							allergies.setAllergieid(resultSet.getInt(1));
							allergies.setUseridref(resultSet.getInt(2));
							allergies.setAllergietype(resultSet.getString(3));
							allergies.setAllergiedesc(resultSet.getString(4));
							allergies.setAllergieintruction(resultSet.getString(5));
							allergies.setDateofallergie(DateWrapper.convertSQLDateTOString(resultSet.getDate(6)+""));
							allergies.setStatus(resultSet.getString(7));
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
				return allergies;
			}

  }
