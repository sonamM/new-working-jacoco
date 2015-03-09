/*
 * 
 */
package com.etouch.yaml.example;

import com.etouch.taf.core.driver.mobile.MobileDriver;


// TODO: Auto-generated Javadoc
/**
 * The Class TafConfiguration.
 */
public class TafConfiguration {
	
	/** The test types. */
	private String[] testTypes;
	
	/** The web. */
	private WebDriver web;
	
	/** The mobile. */
	private MobileDriver mobile;
	
	/**
	 * Gets the test types.
	 *
	 * @return the test types
	 */
	public String[] getTestTypes() {
		return testTypes;
	}
	
	/**
	 * Sets the test types.
	 *
	 * @param testTypes the new test types
	 */
	public void setTestTypes(String[] testTypes) {
		this.testTypes = testTypes;
	}
	
	/**
	 * Gets the web.
	 *
	 * @return the web
	 */
	public WebDriver getWeb() {
		return web;
	}
	
	/**
	 * Sets the web.
	 *
	 * @param web the new web
	 */
	public void setWeb(WebDriver web) {
		this.web = web;
	}
	
	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public MobileDriver getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(MobileDriver mobile) {
		this.mobile = mobile;
	}

	
	
}
