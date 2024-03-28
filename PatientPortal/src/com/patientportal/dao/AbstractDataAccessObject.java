package com.patientportal.dao;
import java.sql.*; 
import java.sql.DriverManager;
import java.util.Properties;

public class AbstractDataAccessObject {

	private Connection connection;
	private static Properties properties;
	public Properties getProperties()

	{
		return properties;
	}


	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}


	public Connection getConnection()
    {
			try
			{
				Properties properties = getProperties();
				Class.forName(properties.getProperty("driver"));
				connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("duser"), properties.getProperty("dpass"));
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		return connection;
	}
  }
