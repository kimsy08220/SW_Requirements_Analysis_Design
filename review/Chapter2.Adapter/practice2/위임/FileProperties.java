package practice2.ю╖юс;

import java.io.*;
import java.util.Properties;

public class FileProperties extends FileIO {
	private Properties properties = new Properties();
	
	public void readFromFile(String filename) throws IOException
	{
		properties.load(new FileInputStream(filename));
	}
	public void writeToFile(String filename) throws IOException
	{
		properties.store(new FileOutputStream(filename), "written by FileProperties");
	}
	public void setValue(String key, String value)
	{
		properties.setProperty(key, value);
	}
	public String getValue(String key)
	{
		return properties.getProperty(key, "");
	}
}
