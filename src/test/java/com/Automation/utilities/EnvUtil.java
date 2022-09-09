package com.Automation.utilities;

import lombok.Getter;

import java.util.Properties;


public class EnvUtil
{
	private static @Getter	Properties props = null;

	// To get and set all properties from property reader
	
	public static void loadProperties(String env)
	{
		if(props==null) {
			props = PropertyReader.loadAllProperties(env);
		}
	}
	public static Properties getProperties()
	{
		return props;
	}
	@SuppressWarnings("finally")
	public static String getProperty(String key)
	{
		String keyvalue = null;
		try
		{
			keyvalue = props.getProperty(key);
		}
		catch(Exception e)
		{
			//log.fatal("Exception Occured while getting the property value\n" + e.getMessage());
		}
		finally
		{
			return keyvalue;
		}
	}
	
	public static void SetProperty(String key, String value)
	{
		props.put(key, value);
	}
}