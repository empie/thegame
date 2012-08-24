package net.empuly.thegame.web.testutil.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WebdriverFactory {
	private static WebDriver instance;

	public static WebDriver getWebdriver() {
		if (instance == null) {
			instance = createFirefoxDriver();
			instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Runtime.getRuntime().addShutdownHook(new Thread() {

				@Override
				public void run() {
					instance.quit();
				}
			});

		}

		return instance;
	}

	protected static WebDriver createFirefoxDriver() {
		try {
			final FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.addExtension(WebdriverFactory.class, "/firebug-1.10.2-fx.xpi");
			firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.10.2");
			firefoxProfile.setAcceptUntrustedCertificates(true);
			firefoxProfile.setEnableNativeEvents(true);
			// firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
			return new FirefoxDriver(firefoxProfile);
		} catch (final Exception e) {
			throw new RuntimeException("Firebug extension kon niet geladen worden. Kloppen de versies wel?", e);
		}
	}

	private WebdriverFactory() {
		// prevent instantiation
	}
}
