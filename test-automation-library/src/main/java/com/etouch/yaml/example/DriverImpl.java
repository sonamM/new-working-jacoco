/*
 * 
 */
package com.etouch.yaml.example;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverImpl.
 */
public abstract class DriverImpl implements Driver{

	/** The hub. */
	private String hub;
	
	/** The port. */
	private String port;
	
	/** The tool. */
	private String tool;
	
	/** The current test beds. */
	private String[] currentTestBeds;
	
	/** The test beds. */
	private List<TestBed> testBeds;
	
	/**
	 * Gets the hub.
	 *
	 * @return the hub
	 */
	public String getHub() {
		return hub;
	}
	
	/**
	 * Sets the hub.
	 *
	 * @param hub the new hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	
	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Gets the tool.
	 *
	 * @return the tool
	 */
	public String getTool() {
		return tool;
	}
	
	/**
	 * Sets the tool.
	 *
	 * @param tool the new tool
	 */
	public void setTool(String tool) {
		this.tool = tool;
	}
	
	/**
	 * Gets the current test beds.
	 *
	 * @return the current test beds
	 */
	public String[] getCurrentTestBeds() {
		return currentTestBeds;
	}
	
	/**
	 * Sets the current test beds.
	 *
	 * @param currentTestBeds the new current test beds
	 */
	public void setCurrentTestBeds(String[] currentTestBeds) {
		this.currentTestBeds = currentTestBeds;
	}
	
	/**
	 * Gets the test beds.
	 *
	 * @return the test beds
	 */
	public List<TestBed> getTestBeds() {
		return testBeds;
	}
	
	/**
	 * Sets the test beds.
	 *
	 * @param testBeds the new test beds
	 */
	public void setTestBeds(List<TestBed> testBeds) {
		this.testBeds = testBeds;
	}
	
	/* (non-Javadoc)
	 * @see com.etouch.yaml.example.Driver#getWebDriver(java.lang.String)
	 */
	public Object getWebDriver(String driverType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.etouch.yaml.example.Driver#getMobileDriver(java.lang.String)
	 */
	public Object getMobileDriver(String driverType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
