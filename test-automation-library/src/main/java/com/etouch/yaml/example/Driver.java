/*
 * 
 */
package com.etouch.yaml.example;

// TODO: Auto-generated Javadoc
/**
 * The Interface Driver.
 */
public interface Driver {
	
	/**
	 * Gets the web driver.
	 *
	 * @param driverType the driver type
	 * @return the web driver
	 */
	public Object getWebDriver(String driverType);
	
	/**
	 * Gets the mobile driver.
	 *
	 * @param driverType the driver type
	 * @return the mobile driver
	 */
	public Object getMobileDriver(String driverType);
}
