package utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;



public class configReader {
	

	Properties prop;
	public configReader(){
		
		
		try {
			File src=new File("D:\\SeleniumWS1\\freyrNew\\configuration\\config.properties");
			FileInputStream fis=new FileInputStream(src);
			 prop=new Properties();
			prop.load(fis);
			
	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		}
	public String getChromePath(){
		String path=prop.getProperty("ChromeDriver");
		return path;
		
	
	}
	public String getUrl(){
		String path=prop.getProperty("URL");
		return path;
		
	
	}
	public String getUsername(){
		String path=prop.getProperty("UserName");
		return path;
		
	
	}
	public String getpassword(){
		String path=prop.getProperty("Password");
		return path;
		
	
	}
	
		
	
	}

	


