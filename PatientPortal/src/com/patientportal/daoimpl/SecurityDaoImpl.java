package com.patientportal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.patientportal.bean.UserdetailsTO;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.exception.ConnectionException;

public class SecurityDaoImpl extends AbstractDataAccessObject {

	static Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	boolean flag = false;

	/**
	 * The closeConnection method of the AttendanceDaoImpl Class. <br>
	 * 
	 * This method is called when to take Employee InTime.
	 * 
	 * @throws ConnectionException
	 *             if an error occurred
	 */
	public void closeConnection() throws ConnectionException {
		try {
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				pstmt.close();

			if (con != null)
				con.close();
		} catch (SQLException ex) {
			throw new ConnectionException(
					"Server Busy please Try after Sometine");
		}
	}

	/**
	 * The loginCheck method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to loginCheck whether the user Autharised or
	 * not.
	 * 
	 * @param passing
	 *            Employeeid as one parameter.
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return vector with logindetails depends upon operations.
	 * @throws SQLException
	 */
	public Vector<UserdetailsTO> loginCheck(UserdetailsTO pro)
			throws ConnectionException {
		UserdetailsTO userdetailsTO = null;
		Vector<UserdetailsTO> vpro = new Vector<UserdetailsTO>();
		try {
			con = new AbstractDataAccessObject().getConnection();
			pstmt = con.prepareStatement("select * from userdetails where loginid = ? and password = ? ");
			String username = pro.getLoginid();
			String password = pro.getPassword();
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userdetailsTO = new UserdetailsTO();
				userdetailsTO.setUserid(rs.getInt(1));
				userdetailsTO.setLoginid(rs.getString(2));
				userdetailsTO.setFullname(rs.getString(4));
				userdetailsTO.setRole(rs.getString(10));
				vpro.add(userdetailsTO);
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical problum Occoured Please Try Later");
		} finally {
			closeConnection();
		}
		return vpro;
	}
	
	 public String recoverPasswordByQuestion(UserdetailsTO regbean)
	    {
	        String password = null;
	        String loginid=regbean.getLoginid();
	        String secretquestid=regbean.getSquest();
	        String secretans=regbean.getSanswer();
	        try 
	        {con=getConnection();
	            PreparedStatement cstmt=con.prepareStatement("select password from USERDETAILS where SECURITYQUESTION = ? and SECURITYANSWER = ? and LOGINID = ?");
	            cstmt.setString(3,loginid);
	            cstmt.setString(1,secretquestid);
	            cstmt.setString(2,secretans);
	            ResultSet rs = cstmt.executeQuery();
	            
	            if(rs.next()){
	            	password = rs.getString(1);
	            }
	            
	            
	            con.close();
	        } 
	        catch (Exception e) 
	        {
	            password="";
	        }
	        return password;        
	    }
	

	/**
	 * The changePass method of the SecurityDaoImpl Class. <br>
	 * 
	 * This method is called when to changePassword details.
	 * 
	 * @param Passing
	 *            Profile bean as a one parameter.
	 * 
	 * @throws SQLException
	 *             if an error occurred
	 * @throws NullPointerException
	 *             if an error occurred
	 * @return boolean value true or false depends upon operations.
	 * @throws SQLException
	 * @throws SQLException
	 */
	public boolean changePass(UserdetailsTO pf) throws ConnectionException,
			SQLException {
		try {
			con = new AbstractDataAccessObject().getConnection();
			String newpass = pf.getNewpassword();
			String user = pf.getLoginid();
			String firstname = pf.getFullname();
			System.out.println(user);
			System.out.println(firstname);
			String oldpass = pf.getOldpassword();
			pstmt = con.prepareStatement("update userdetails set password = ? where loginid = ? and password = ?");
			pstmt.setString(1, newpass);
			pstmt.setString(2, user);
			pstmt.setString(3, oldpass);
			int c = pstmt.executeUpdate();
			if (c > 0) {
				flag = true;
				con.commit();
			}
		} catch (SQLException e) {
			throw new ConnectionException(
					"Some Technical Prablum Occoured Please Try Later");
		} catch (NullPointerException e) {
			throw new SQLException("Department List is empty");
		} finally {
			closeConnection();
		}
		return flag;
	}
}