/*
 * 
 */
package com.etouch.yaml.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.etouch.taf.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class YamlConfigReader.
 */
public class YamlConfigReader {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
			 	     
		Yaml yaml = new Yaml(); 
			try{
					InputStream in = new FileInputStream( new File( "C:\\Users\\Rajeswari Thangavelu\\workspace\\yamlpoc\\src\\devconfig.yml")); 
//			    TafConfiguration config = (TafConfiguration)yaml.load( in);
//			    
//			    WebDriver webDriver=config.getWeb();
//			    System.out.println(webDriver.getTool());
//			    
//			    for(String currentTestBed:webDriver.getCurrentTestBeds() )
//			    System.out.println("Web: Current Test Beds " +currentTestBed);
//			    
//			    TestBed ieTestBed=(TestBed)webDriver.getTestBeds().get(1);
//			    System.out.println("Browser Name: "+ieTestBed.getBrowserName());
//			    
//			    
//			    MobileDriver mobileDriver=config.getMobile();
//			    for(String currentTestBed:mobileDriver.getCurrentTestBeds() )
//				    System.out.println("Mobile: Current Test Beds " +currentTestBed);
//			    
//			    TestBed androidTestBed=(TestBed)mobileDriver.getTestBeds().get(1);
//			    System.out.println("Device Name: "+androidTestBed.getAppPackage());
				    
			   
			}
			catch(IOException e){
					CommonUtil.sop("Problem in file reading " + e.getMessage());
			}
		}
		
}
	