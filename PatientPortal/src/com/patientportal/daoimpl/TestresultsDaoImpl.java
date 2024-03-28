package com.patientportal.daoimpl;
import java.sql.*; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Date; 

import com.patientportal.util.DateWrapper; 
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.TestresultsTO;

public class TestresultsDaoImpl {


	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;



	public TestresultsDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}
	public boolean addTestresultsDetails(TestresultsTO testresults) {
		try {
		preparedStatement = con.prepareStatement("insert into TESTRESULTS values((select nvl(max(TESTID),1000)+1 from TESTRESULTS),?,?,?,?,?, sysdate,?)");
		preparedStatement.setInt(1,testresults.getUseridref());
		preparedStatement.setString(2,testresults.getTestname());
		preparedStatement.setString(3,testresults.getTestdescription());
		preparedStatement.setString(4,testresults.getTestresult());
		preparedStatement.setString(5,testresults.getOrderby());

		preparedStatement.setString(6,testresults.getStatus());
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
	
	
	

	public List<TestresultsTO> getPatientTestresults(int userid) {
		List<TestresultsTO> listTestresults = new ArrayList<TestresultsTO>();
		TestresultsTO testresults = null;
		try {
			preparedStatement = con.prepareStatement("select * from TESTRESULTS where USERIDREF = "+userid);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				testresults = new TestresultsTO();
				testresults.setTestid(resultSet.getInt(1));
				testresults.setUseridref(resultSet.getInt(2));
				testresults.setTestname(resultSet.getString(3));
				testresults.setTestdescription(resultSet.getString(4));
				testresults.setTestresult(resultSet.getString(5));
				testresults.setOrderby(resultSet.getString(6));
				testresults.setDateoftest(DateWrapper.convertSQLDateTOString(resultSet.getDate(7)+""));
				testresults.setStatus(resultSet.getString(8));
			listTestresults.add(testresults);
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
		return listTestresults;
	}

	

			public List<TestresultsTO> viewTestresults() {
				List<TestresultsTO> listTestresults = new ArrayList<TestresultsTO>();
				TestresultsTO testresults = null;
				try {
					preparedStatement = con.prepareStatement("select * from TESTRESULTS");
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						testresults = new TestresultsTO();
						testresults.setTestid(resultSet.getInt(1));
						testresults.setUseridref(resultSet.getInt(2));
						testresults.setTestname(resultSet.getString(3));
						testresults.setTestdescription(resultSet.getString(4));
						testresults.setTestresult(resultSet.getString(5));
						testresults.setOrderby(resultSet.getString(6));
						testresults.setDateoftest(DateWrapper.convertSQLDateTOString(resultSet.getDate(7)+""));
						testresults.setStatus(resultSet.getString(8));
					listTestresults.add(testresults);
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
				return listTestresults;
			}

	public boolean updateTestresults(Integer testid, TestresultsTO testresults) {
		try {
		preparedStatement = con.prepareStatement("update TESTRESULTS set USERIDREF = ?, TESTNAME = ?, TESTDESCRIPTION = ?, TESTRESULT = ?, ORDERBY = ?, DATEOFTEST = ? where TESTID = ?");
		preparedStatement.setInt(1,testresults.getUseridref());
		preparedStatement.setString(2,testresults.getTestname());
		preparedStatement.setString(3,testresults.getTestdescription());
		preparedStatement.setString(4,testresults.getTestresult());
		preparedStatement.setString(5,testresults.getOrderby());


		preparedStatement.setInt(6,testresults.getTestid());
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
	public boolean deleteTestresults(Integer testid) {
		try {
		preparedStatement = con.prepareStatement("delete TESTRESULTS where TESTID = "+testid);
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


			public TestresultsTO viewTestresults(Integer testid) {
				TestresultsTO testresults = new TestresultsTO();
				try {
					preparedStatement = con.prepareStatement("select * from TESTRESULTS where TESTID = "+testid);
					resultSet = preparedStatement.executeQuery();
					if(resultSet.next()) {
						testresults = new TestresultsTO();
							testresults.setTestid(resultSet.getInt(1));
							testresults.setUseridref(resultSet.getInt(2));
							testresults.setTestname(resultSet.getString(3));
							testresults.setTestdescription(resultSet.getString(4));
							testresults.setTestresult(resultSet.getString(5));
							testresults.setOrderby(resultSet.getString(6));
							testresults.setDateoftest(DateWrapper.convertSQLDateTOString(resultSet.getDate(7)+""));
							testresults.setStatus(resultSet.getString(8));
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
				return testresults;
			}

  }
