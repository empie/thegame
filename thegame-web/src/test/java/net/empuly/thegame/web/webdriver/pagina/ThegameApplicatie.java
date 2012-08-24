package net.empuly.thegame.web.webdriver.pagina;

import net.empuly.thegame.web.testutil.webdriver.WebdriverLink;
import net.empuly.thegame.web.webdriver.pagina.spel.SpelLijstPagina;

public class ThegameApplicatie {
	
	
	public static SpelLijstPagina navigeerNaarRoot() {
		WebdriverLink.APPLICATION_ROOT.open();
		SpelLijstPagina spelLijstPagina = new SpelLijstPagina();
		return spelLijstPagina;
	}
}
