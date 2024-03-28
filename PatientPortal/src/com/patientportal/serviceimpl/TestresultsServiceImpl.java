package com.patientportal.serviceimpl;

import java.util.List;

import com.patientportal.bean.TestresultsTO;
import com.patientportal.daoimpl.TestresultsDaoImpl;
import com.patientportal.exception.ConnectionException;

public class TestresultsServiceImpl {

	private static final long serialVersionUID = 1L;

	TestresultsDaoImpl testresultsDaoImpl = new TestresultsDaoImpl();
	boolean flag = false;

	public List<TestresultsTO> getPatientTestresults(int userid)
			throws ConnectionException {
		return testresultsDaoImpl.getPatientTestresults(userid);
	}

	public List<TestresultsTO> getTestresults() throws ConnectionException {
		return testresultsDaoImpl.viewTestresults();
	}

	public TestresultsTO getTestresults(Integer testid)
			throws ConnectionException {
		return testresultsDaoImpl.viewTestresults(testid);
	}

	public boolean addTestresults(TestresultsTO testresults)
			throws ConnectionException {
		return testresultsDaoImpl.addTestresultsDetails(testresults);
	}

	public boolean updateTestresults(Integer testid, TestresultsTO testresults)
			throws ConnectionException {
		return testresultsDaoImpl.updateTestresults(testid, testresults);
	}

	public boolean deleteTestresults(Integer testid) throws ConnectionException {
		return testresultsDaoImpl.deleteTestresults(testid);
	}
}
