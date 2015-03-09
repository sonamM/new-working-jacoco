package com.etouch.amazon.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Test;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.infra.mail.EmailValidator;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;

public class TestAmazonUnit extends TestCase{
	
	static Log log=LogUtil.getLog(TestAmazonUnit.class);
	//Added by Lavanya
	static Properties props = new Properties();
	
	public void loadProps(){
		InputStream ipStream = getClass().getClassLoader().getResourceAsStream("mail.properties");
		try
		{
			if(ipStream!=null)
			{
				props.load(ipStream);
			}
		}catch(IOException iex)
		{
			iex.printStackTrace();
		}
	}
	
	@Test
	public void test() throws Exception {
		
		initialize();
		boolean result=true;
		//Assert.assertEquals(true, result);
		SoftAssertor.assertEquals(true, result);		
		SoftAssertor.displayAssertErrors();
	}

	
	public void initialize() {
    	CommonUtil.sop(" On initialize");
    	
    	//String configFileName = "..\\AmazonPOC\\src\\test\\resources\\devConfig.yml";
    	String configFileName = "/Users/sonamdeo/eTouch-local-git/test-automation-version1/AmazonPOC/src/test/resources/devConfig.yml";
    	
    	InputStream in=null;
		try {
			in = convertFileToInputStream(configFileName);
			CommonUtil.sop(" Dev config file input stream is ready");
		} catch (DriverException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String currentTestBedName = System.getProperty("TESTBEDNAME");
		String [] currentTestBeds = {currentTestBedName};
		try {
			TestBedManager.INSTANCE.setConfig(in, currentTestBeds);			
		}
		catch (Exception e) {
			log.error("Please mention paramter in Maven command for TestBed Name");
		}
		
		TestBedManager.INSTANCE.executeTestNG();
    }
	
	/**
	 * This method helps to convert from file to InputStream
	 * @param fileName
	 * @return
	 * @throws DriverException
	 */
	private static InputStream convertFileToInputStream(String fileName) throws DriverException
	{
		InputStream ipStream=null;
		if(fileName != null){
			
			try {
				ipStream = new FileInputStream(new File(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			log.error(" File name is null - " + fileName);
			throw new DriverException(
					"failed to read profile configuration/TestNG, file name is missing");
		}
		return ipStream;
	}
	
	public static void main(String[] args) throws Exception
	{
		new TestAmazonUnit().loadProps();
		//Message[] messages = new EmailValidator().readMailThroughSMTP(props);
		Message[] messages = new EmailValidator().readMail(props);
		System.out.println("Message count is: "+messages.length);		
	}
}
