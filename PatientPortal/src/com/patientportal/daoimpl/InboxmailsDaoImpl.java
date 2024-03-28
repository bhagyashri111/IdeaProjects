package com.patientportal.daoimpl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.patientportal.util.DateWrapper;
import com.patientportal.dao.AbstractDataAccessObject;
import com.patientportal.bean.InboxmailsTO;

public class InboxmailsDaoImpl {

	Connection con = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean flag = false;

	private static final long serialVersionUID = 1L;

	public InboxmailsDaoImpl() {
		con = new AbstractDataAccessObject().getConnection();
	}

	public boolean addInboxmailsDetails(InboxmailsTO inbox_mails) {
		try {
			preparedStatement = con
					.prepareStatement("insert into INBOX_MAILS values((select nvl(max(MAILID),1000)+1 from INBOX_MAILS),?,?,?,?, sysdate)");
			PreparedStatement preparedStatement1 = con
			.prepareStatement("insert into SENT_MAILS values((select nvl(max(MAILID),1000)+1 from INBOX_MAILS),?,?,?,?, sysdate)");
	
			preparedStatement.setInt(1, inbox_mails.getUserid());
			preparedStatement.setInt(2, inbox_mails.getTomailidref());
			preparedStatement.setString(3, inbox_mails.getMailsub());
			preparedStatement.setString(4, inbox_mails.getMailbody());
			
			preparedStatement1.setInt(1, inbox_mails.getTomailidref());
			preparedStatement1.setInt(2, inbox_mails.getUserid());
			preparedStatement1.setString(3, inbox_mails.getMailsub());
			preparedStatement1.setString(4, inbox_mails.getMailbody());

			int results = preparedStatement.executeUpdate();
			int results1 = preparedStatement1.executeUpdate();
			if (results > 0 && results1 > 0) {
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

	public List<InboxmailsTO> viewInboxmails() {
		List<InboxmailsTO> listInboxmails = new ArrayList<InboxmailsTO>();
		InboxmailsTO inbox_mails = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from INBOX_MAILS");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				inbox_mails = new InboxmailsTO();
				inbox_mails.setMailid(resultSet.getInt(1));
				inbox_mails.setFrommailidref(resultSet.getInt(2));
				inbox_mails.setTomailidref(resultSet.getInt(3));
				inbox_mails.setMailsub(resultSet.getString(4));
				inbox_mails.setMailbody(resultSet.getString(5));
				inbox_mails.setMaildate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				listInboxmails.add(inbox_mails);
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
		return listInboxmails;
	}

	public List<InboxmailsTO> viewUserInboxmails(int userid) {
		List<InboxmailsTO> listInboxmails = new ArrayList<InboxmailsTO>();
		InboxmailsTO inbox_mails = null;
		try {
			preparedStatement = con
					.prepareStatement("select * from INBOX_MAILS where TOMAILIDREF = "+userid);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				inbox_mails = new InboxmailsTO();
				inbox_mails.setMailid(resultSet.getInt(1));
				inbox_mails.setFrommailidref(resultSet.getInt(2));
				inbox_mails.setTomailidref(resultSet.getInt(3));
				inbox_mails.setMailsub(resultSet.getString(4));
				inbox_mails.setMailbody(resultSet.getString(5));
				inbox_mails.setMaildate(DateWrapper
						.convertSQLDateTOString(resultSet.getDate(6) + ""));
				listInboxmails.add(inbox_mails);
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
		return listInboxmails;
	}

	
	
	public boolean updateInboxmails(Integer mailid, InboxmailsTO inbox_mails) {
		try {
			preparedStatement = con
					.prepareStatement("update INBOX_MAILS set FROMMAILIDREF = ?, TOMAILIDREF = ?, MAILSUB = ?, MAILBODY = ? where MAILID = ?");
			preparedStatement.setInt(1, inbox_mails.getFrommailidref());
			preparedStatement.setInt(2, inbox_mails.getTomailidref());
			preparedStatement.setString(3, inbox_mails.getMailsub());
			preparedStatement.setString(4, inbox_mails.getMailbody());

			preparedStatement.setInt(5, inbox_mails.getMailid());
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

	public boolean deleteInboxmails(Integer mailid) {
		try {
			preparedStatement = con
					.prepareStatement("delete INBOX_MAILS where MAILID = "
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

	public InboxmailsTO viewInboxmails(Integer mailid) {
		InboxmailsTO inbox_mails = new InboxmailsTO();
		try {
			preparedStatement = con
					.prepareStatement("select * from INBOX_MAILS where MAILID = "
							+ mailid);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				inbox_mails = new InboxmailsTO();
				inbox_mails.setMailid(resultSet.getInt(1));
				inbox_mails.setFrommailidref(resultSet.getInt(2));
				inbox_mails.setTomailidref(resultSet.getInt(3));
				inbox_mails.setMailsub(resultSet.getString(4));
				inbox_mails.setMailbody(resultSet.getString(5));
				inbox_mails.setMaildate(DateWrapper
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
		return inbox_mails;
	}

}
