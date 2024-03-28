package com.patientportal.serviceimpl;

import java.util.List;

import com.patientportal.bean.InboxmailsTO;
import com.patientportal.bean.SentmailsTO;
import com.patientportal.daoimpl.SentmailsDaoImpl;
import com.patientportal.exception.ConnectionException;

public class SentmailsServiceImpl {

	private static final long serialVersionUID = 1L;

	SentmailsDaoImpl sentmailsDaoImpl = new SentmailsDaoImpl();
	boolean flag = false;

	public List<SentmailsTO> viewSentmails(int userid) throws ConnectionException {
		return sentmailsDaoImpl.viewUserSentmails(userid);
	}

	public SentmailsTO getSentmails(Integer mailid) throws ConnectionException {
		return sentmailsDaoImpl.viewSentmails(mailid);
	}

	public boolean addSentmails(InboxmailsTO sent_mails)
			throws ConnectionException {
		return sentmailsDaoImpl.addSentmailsDetails(sent_mails);
	}

	public boolean updateSentmails(Integer mailid, SentmailsTO sent_mails)
			throws ConnectionException {
		return sentmailsDaoImpl.updateSentmails(mailid, sent_mails);
	}

	public boolean deleteSentmails(Integer mailid) throws ConnectionException {
		return sentmailsDaoImpl.deleteSentmails(mailid);
	}
}
