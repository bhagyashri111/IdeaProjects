package com.patientportal.daoimpl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.patientportal.util.DateWrapper;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.UserdetailsTO;

public class UserdetailsDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public UserdetailsDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addUserdetailsDetails(UserdetailsTO userdetails) {
		try {
			preparedStatement = con
					.prepareStatement("insert into USERDETAILS values((select nvl(max(USERID),1000)+1 from USERDETAILS),?,?,?,?, sysdate,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, userdetails.getLoginid());
			preparedStatement.setString(2, userdetails.getPassword());
			preparedStatement.setString(3, userdetails.getFullname());
			preparedStatement.setDate(4, DateWrapper
					.convertStringTODate(userdetails.getDateofbirth()));
			preparedStatement.setString(5, userdetails.getAddress());
			preparedStatement.setString(6, userdetails.getEmail());
			preparedStatement.setString(7, userdetails.getPhone());
			System.out.println(userdetails.getRole());
			if ("".equals(userdetails.getRole()) || userdetails.getRole()==null) {
				preparedStatement.setString(8, "patient");
			} else {
				preparedStatement.setString(8, "doctor");
			}

			preparedStatement.setString(9, userdetails.getSpecialtytype());
			preparedStatement.setString(10, userdetails.getSquest());
			preparedStatement.setString(11, userdetails.getSanswer());
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

	public List<UserdetailsTO> viewUserdetails(String role) {
		System.out.println(role);
		List<UserdetailsTO> listUserdetails = new ArrayList<UserdetailsTO>();
		UserdetailsTO userdetails = null;
		try {
			String sql = "select * from USERDETAILS where role != 'admin' and role = '"
					+ role + "'";
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userdetails = new UserdetailsTO();
				userdetails.setUserid(resultSet.getInt(1));
				userdetails.setLoginid(resultSet.getString(2));
				userdetails.setPassword(resultSet.getString(3));
				userdetails.setFullname(resultSet.getString(4));
				userdetails.setDateofbirth(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				userdetails.setDateofregister(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				userdetails.setAddress(resultSet.getString(7));
				userdetails.setEmail(resultSet.getString(8));
				userdetails.setPhone(resultSet.getString(9));
				userdetails.setStatus(resultSet.getString(10));
				userdetails.setSpecialtytype(resultSet.getString(11));
				listUserdetails.add(userdetails);
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
		return listUserdetails;
	}
	
	public List<UserdetailsTO> viewUserdetails() {
		List<UserdetailsTO> listUserdetails = new ArrayList<UserdetailsTO>();
		UserdetailsTO userdetails = null;
		try {
			String sql = "select * from USERDETAILS where role != 'admin'";
			preparedStatement = con.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userdetails = new UserdetailsTO();
				userdetails.setUserid(resultSet.getInt(1));
				userdetails.setLoginid(resultSet.getString(2));
				userdetails.setPassword(resultSet.getString(3));
				userdetails.setFullname(resultSet.getString(4));
				userdetails.setDateofbirth(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				userdetails.setDateofregister(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				userdetails.setAddress(resultSet.getString(7));
				userdetails.setEmail(resultSet.getString(8));
				userdetails.setPhone(resultSet.getString(9));
				userdetails.setStatus(resultSet.getString(10));
				userdetails.setSpecialtytype(resultSet.getString(11));
				listUserdetails.add(userdetails);
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
		return listUserdetails;
	}

	public boolean updateUserdetails(Integer userid, UserdetailsTO userdetails) {
		try {
			preparedStatement = con
					.prepareStatement("update USERDETAILS set FULLNAME = ?, DATEOFBIRTH = ?, ADDRESS = ?, EMAIL = ?, PHONE = ? where USERID = ?");
			preparedStatement.setString(1, userdetails.getFullname());
			preparedStatement.setDate(2, DateWrapper
					.convertStringTODate(userdetails.getDateofbirth()));

			preparedStatement.setString(3, userdetails.getAddress());
			preparedStatement.setString(4, userdetails.getEmail());
			preparedStatement.setString(5, userdetails.getPhone());

			preparedStatement.setInt(6, userdetails.getUserid());
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

	public boolean deleteUserdetails(Integer userid) {
		try {
			preparedStatement = con
					.prepareStatement("delete USERDETAILS where USERID = "
							+ userid);
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

	public UserdetailsTO viewUserdetails(Integer userid) {
		UserdetailsTO userdetails = new UserdetailsTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from USERDETAILS where USERID = "
							+ userid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userdetails = new UserdetailsTO();
				userdetails.setUserid(resultSet.getInt(1));
				userdetails.setLoginid(resultSet.getString(2));
				userdetails.setPassword(resultSet.getString(3));
				userdetails.setFullname(resultSet.getString(4));
				userdetails.setDateofbirth(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(5) + ""));
				userdetails.setDateofregister(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				userdetails.setAddress(resultSet.getString(7));
				userdetails.setEmail(resultSet.getString(8));
				userdetails.setPhone(resultSet.getString(9));
				userdetails.setStatus(resultSet.getString(10));
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
		return userdetails;
	}

	public Integer getUserid(String loginid) {
		int userid = 0;
		try {
			preparedStatement = con
					.prepareStatement("select * from USERDETAILS where LOGINID = '"
							+ loginid+"'");
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				 userid = resultSet.getInt(1);
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
		return userid;
	}

	
	
}
