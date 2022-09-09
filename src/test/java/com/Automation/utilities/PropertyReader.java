package com.Automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader 

{


	// Public method for reading the property
	public static Properties getProperties(String sFilePath)
	{
		Properties props = new Properties();
		try
		{
			System.out.println("Passed File Path:" + sFilePath);
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ sFilePath);			
			props.load(fs);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return props;
	}
	
	public static Properties loadAllProperties(String env)
	{
			Properties props = new Properties();
	    	File dir = new File(System.getProperty("user.dir")+ "/src/test/resources/DataConfig/");
			File[] path = dir.listFiles();
	    	for (File file : dir.listFiles())
	    	{
	    	    if (file.getName().endsWith((".properties")))
	    	      {
	    	    	 props.putAll(getProperties("/src/test/resources/DataConfig/" + file.getName()));
	    	      }
	    	}
			dir = new File(System.getProperty("user.dir")+ "/src/test/resources/DataConfig/"+env);
			for (File file : dir.listFiles())
			{
				if (file.getName().endsWith((".properties")))
				{
					props.putAll(getProperties("/src/test/resources/DataConfig/" + env + "/"+ file.getName()));
				}
			}
	    	return props;
	 }
}