package com.patientportal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.patientportal.bean.InboxmailsTO;
import com.patientportal.bean.SentmailsTO;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.util.DateWrapper;

public class SentmailsDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public SentmailsDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addSentmailsDetails(InboxmailsTO sent_mails) {
		try {
			preparedStatement = con
					.prepareStatement("insert into SENT_MAILS values((select nvl(max(MAILID),1000)+1 from SENT_MAILS),?,?,?,?, sysdate)");
			preparedStatement.setInt(1, sent_mails.getFrommailidref());
			preparedStatement.setInt(2, sent_mails.getTomailidref());
			preparedStatement.setString(3, sent_mails.getMailsub());
			preparedStatement.setString(4, sent_mails.getMailbody());

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

	public List<SentmailsTO> viewUserSentmails(int userid) {
		List<SentmailsTO> listSentmails = new ArrayList<SentmailsTO>();
		SentmailsTO sent_mails = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from SENT_MAILS where TOMAILIDREF = "
							+ userid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				sent_mails = new SentmailsTO();
				sent_mails.setMailid(resultSet.getInt(1));
				sent_mails.setFrommailidref(resultSet.getInt(2));
				sent_mails.setTomailidref(resultSet.getInt(3));
				sent_mails.setMailsub(resultSet.getString(4));
				sent_mails.setMailbody(resultSet.getString(5));
				sent_mails.setMaildate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				listSentmails.add(sent_mails);
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
		return listSentmails;
	}

	public boolean updateSentmails(Integer mailid, SentmailsTO sent_mails) {
		try {
			preparedStatement = con
					.prepareStatement("update SENT_MAILS set FROMMAILIDREF = ?, TOMAILIDREF = ?, MAILSUB = ?, MAILBODY = ? where MAILID = ?");
			preparedStatement.setInt(1, sent_mails.getFrommailidref());
			preparedStatement.setInt(2, sent_mails.getTomailidref());
			preparedStatement.setString(3, sent_mails.getMailsub());
			preparedStatement.setString(4, sent_mails.getMailbody());

			preparedStatement.setInt(5, sent_mails.getMailid());
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

	public boolean deleteSentmails(Integer mailid) {
		try {
			preparedStatement = con
					.prepareStatement("delete SENT_MAILS where MAILID = "
							+ mailid);
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

	public SentmailsTO viewSentmails(Integer mailid) {
		SentmailsTO sent_mails = new SentmailsTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from SENT_MAILS where MAILID = "
							+ mailid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				sent_mails = new SentmailsTO();
				sent_mails.setMailid(resultSet.getInt(1));
				sent_mails.setFrommailidref(resultSet.getInt(2));
				sent_mails.setTomailidref(resultSet.getInt(3));
				sent_mails.setMailsub(resultSet.getString(4));
				sent_mails.setMailbody(resultSet.getString(5));
				sent_mails.setMaildate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
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
		return sent_mails;
	}

}
