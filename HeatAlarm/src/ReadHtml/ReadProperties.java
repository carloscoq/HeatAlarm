package ReadHtml;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
	    Properties properties = new Properties();  
	    
	
	public double getmaxTemp(double maxTemp){
	try {
	    InputStream inFile = getClass().getResourceAsStream("config.properties"); 
	    properties.load(inFile);  
	    inFile.close();  
	  maxTemp = Double.parseDouble(properties.getProperty("tempMax"));
	} catch (IOException e) {
		System.out.println(e);
	}
	return maxTemp;
	}
	
	public double getminTemp(double minTemp){
		try {
	    InputStream inFile = getClass().getResourceAsStream("config.properties"); 
	    properties.load(inFile);  
	    inFile.close();  

	    minTemp = Double.parseDouble(properties.getProperty("tempMin"));
		} catch (IOException e) {
		}
		return minTemp;
		}


	}
