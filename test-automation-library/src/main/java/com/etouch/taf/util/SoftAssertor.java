/*
 * 
 */
package com.etouch.taf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;



// TODO: Auto-generated Javadoc
/**
 * The Class SoftAssertor.
 */
public class SoftAssertor {
	
	/** The log. */
	static Log log=LogUtil.getLog(SoftAssertor.class);
	
	/** The verification failures map. */
	private static Map<ITestResult,List<String>> verificationFailuresMap = new HashMap<ITestResult,List<String>>();
	
	 
    /**
     * Assert true.
     *
     * @param condition the condition
     * @param errMsg the err msg
     */
    public static void assertTrue(boolean condition, String errMsg) {
    	try {
    		Assert.assertTrue(condition);
    	} catch(Throwable e) {
    		addVerificationFailure(errMsg + " Exception msg: "+e.getMessage());
    		
    	}
    }
 
    /**
     * Assert false.
     *
     * @param condition the condition
     * @param errMsg the err msg
     */
    public static void assertFalse(boolean condition, String errMsg)  {
    	try {
    		Assert.assertFalse(condition);
	} catch(Throwable e) {
    		addVerificationFailure(errMsg + " Exception msg: "+e.getMessage());
    		
	}
    }
 
    /**
     * Assert equals.
     *
     * @param actual the actual
     * @param expected the expected
     * @param errMsg the err msg
     */
    public static void assertEquals(Object actual, Object expected, String errMsg)  {
    	try {
    		Assert.assertEquals(actual, expected);
		} catch(Throwable e) {
    		addVerificationFailure(errMsg + " Exception msg: "+e.getMessage());
    		
		}
    }
    
    /**
     * Assert true.
     *
     * @param condition the condition
     */
    public static void assertTrue(boolean condition) {
    	try {
    		Assert.assertTrue(condition);
    	} catch(Throwable e) {
    		addVerificationFailure(" Exception msg: "+e.getMessage());
    		
    	}
    }
 
    /**
     * Assert false.
     *
     * @param condition the condition
     */
    public static void assertFalse(boolean condition)  {
    	try {
    		Assert.assertFalse(condition);
	} catch(Throwable e) {
    		addVerificationFailure(" Exception msg: "+e.getMessage());
    		
	}
    }
 
    
    /**
     * Assert not null.
     *
     * @param actual the actual
     * @param errMsg the err msg
     */
    public static void assertNotNull(Object actual, String errMsg)  {
    	try {
    		Assert.assertNotNull(actual);
		} catch(Throwable e) {
    		addVerificationFailure(errMsg+" Exception msg: "+e.getMessage());    		
		}
    }
 
	/**
	 * Gets the verification failures.
	 *
	 * @return the verification failures
	 */
	public static List<String> getVerificationFailures() {
		List<String> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
		return verificationFailures == null ? new ArrayList<String>() : verificationFailures;
	}
	
	/**
	 * Adds the verification failure.
	 *
	 * @param e the e
	 */
	public static void addVerificationFailure(String e) {
		List<String> verificationFailures = getVerificationFailures();
		verificationFailures.add(e);
		verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
	}

	/**
	 * Assert fail.
	 *
	 * @param errMsg the err msg
	 */
	public static void assertFail(String errMsg) {
		
		try {
    		Assert.fail(errMsg);
		} catch(Throwable e) {
    		addVerificationFailure(errMsg+" Exception msg: "+e.getMessage());    		
		}
		
	}

	/**
	 * Assert equals.
	 *
	 * @param actual the actual
	 * @param expected the expected
	 */
	public static void assertEquals(Object actual, Object expected)  {
    	try {
    		Assert.assertEquals(actual, expected);
		} catch(Throwable e) {
    		addVerificationFailure(" Exception msg: "+e.getMessage());
    		
		}
    }

	/**
	 * Assert not null.
	 *
	 * @param actual the actual
	 */
	public static void assertNotNull(Object actual) {
		try {
    			Assert.assertNotNull(actual);
			} catch(Throwable e) {
    		addVerificationFailure("Exception msg: "+e.getMessage());    		
		}
		
	}
	
	/**
	 * Display assert errors.
	 */
	public static void displayAssertErrors()
	{
		if(verificationFailuresMap!=null && verificationFailuresMap.size()>0 )
		{
			Set keys = verificationFailuresMap.keySet();
			java.util.Iterator<ITestResult> itr = keys.iterator();
			while(itr.hasNext())
			{
				List<String> errorList = verificationFailuresMap.get(itr.next());
				if(errorList!=null && errorList.size()>0)
				{
					for(int index=0; index<errorList.size(); index++)
					{
						log.error(errorList.get(index));					
					}
					
				}
			}
			
			Assert.fail("Exception during execution of Test methods");
		}
	}
	

}
