package net.empuly.thegame.web.testutil.webdriver;

public class WebdriverProperties {

	public static String getBaseUrl() {
		return getServletRoot() + "/" + getContextPath();
	}

	private static String getHostName() {
		return "localhost";
	}


	private static String getPort() {
		return "8080";
	}

	
	private static String getServletRoot() {
		return "http://" + getHostName() + ":" + getPort();
	}

	private static String getContextPath() {
		return "thegame";
	}

	
}
