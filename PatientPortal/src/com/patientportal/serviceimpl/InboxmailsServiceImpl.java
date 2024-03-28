package com.patientportal.serviceimpl;

import java.util.List;
import java.util.Date;
import com.patientportal.daoimpl.InboxmailsDaoImpl;
import com.patientportal.bean.InboxmailsTO;
import com.patientportal.exception.ConnectionException;
import com.patientportal.exception.LoginException;
import com.patientportal.exception.DataNotFoundException;
import com.patientportal.bean.InboxmailsTO;

public class InboxmailsServiceImpl {

	private static final long serialVersionUID = 1L;

	InboxmailsDaoImpl inboxmailsDaoImpl = new InboxmailsDaoImpl();
	boolean flag = false;

	public List<InboxmailsTO> viewUserInboxmails(int userid) throws ConnectionException {
		return inboxmailsDaoImpl.viewUserInboxmails(userid);
	}

	public InboxmailsTO getInboxmails(Integer mailid)
			throws ConnectionException {
		return inboxmailsDaoImpl.viewInboxmails(mailid);
	}

	public boolean addInboxmails(InboxmailsTO inbox_mails)
			throws ConnectionException {
		return inboxmailsDaoImpl.addInboxmailsDetails(inbox_mails);
	}

	public boolean updateInboxmails(Integer mailid, InboxmailsTO inbox_mails)
			throws ConnectionException {
		return inboxmailsDaoImpl.updateInboxmails(mailid, inbox_mails);
	}

	public boolean deleteInboxmails(Integer mailid) throws ConnectionException {
		return inboxmailsDaoImpl.deleteInboxmails(mailid);
	}
}
