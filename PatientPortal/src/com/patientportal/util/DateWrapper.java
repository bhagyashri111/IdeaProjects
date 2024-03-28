package com.patientportal.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateWrapper {
	static String month[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
			"Aug", "Sep", "Oct", "Nov", "Dec" };

	public DateWrapper() {
	}

	public static String parseDate(Date date) {
		int monthid = date.getMonth();
		String newdate = date.getDate() + "-" + month[monthid] + "-"
				+ (date.getYear() + 1900);
		return newdate;
	}

	public static String parseDate(String date) {
		int monthid = Integer.parseInt(date.substring(date.indexOf("-") + 1,
				date.lastIndexOf("-")));
		String newdate = date.substring(0, date.indexOf("-")) + "-"
				+ month[monthid - 1] + "-"
				+ (date.substring(date.lastIndexOf("-") + 1, date.length()));
		return newdate;
	}

	public static String parseDate(java.sql.Date date) {
		String olddate = date.toString();
		String newdate = olddate.substring(olddate.lastIndexOf("-") + 1,
				olddate.length())
				+ "-"
				+ olddate.substring(olddate.indexOf("-") + 1, olddate
						.lastIndexOf("-"))
				+ "-"
				+ olddate.substring(0, olddate.indexOf("-"));
		return newdate;
	}

	public static java.sql.Date convertFromJAVADateToSQLDate(Date javaDate) {
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}

	public static java.sql.Date convertStringTODate(String dateString)
			throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = formatter.parse(dateString);
			return convertFromJAVADateToSQLDate(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String convertSQLDateTOString(String sqlDate) {
		try {
			String startDateArray[] = sqlDate.split("-");
			String date = "";
			if (startDateArray.length == 3) {
				date = startDateArray[2] + "/" + startDateArray[1] + "/"
						+ startDateArray[0];
			}
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
