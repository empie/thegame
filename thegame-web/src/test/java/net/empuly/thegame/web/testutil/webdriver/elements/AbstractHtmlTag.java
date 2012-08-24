package net.empuly.thegame.web.testutil.webdriver.elements;

import static com.google.common.base.Preconditions.checkNotNull;

import net.empuly.thegame.web.testutil.webdriver.WebdriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AbstractHtmlTag {

	private By byToLookupElement;

	public AbstractHtmlTag(By byToLookupElement) {
		checkNotNull(byToLookupElement);
		this.byToLookupElement = byToLookupElement;
	}
	
	public WebElement getWebElement() {
		return WebdriverFactory.getWebdriver().findElement(byToLookupElement);
	}
	
	public boolean isPresent() {
		try {
			getWebElement();
			return true;
		}catch(NoSuchElementException noSuchElementException) {
			return false;
		}
	}


}
