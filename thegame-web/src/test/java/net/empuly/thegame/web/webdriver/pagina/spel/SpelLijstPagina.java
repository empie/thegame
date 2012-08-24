package net.empuly.thegame.web.webdriver.pagina.spel;

import net.empuly.thegame.web.testutil.webdriver.Pagina;
import net.empuly.thegame.web.testutil.webdriver.elements.HtmlH3;

import org.openqa.selenium.By;

public class SpelLijstPagina extends Pagina<SpelLijstPagina> {

	private static final String SPEL_LIJST_ARTIKEL_ID = "spelLijstArtikel";
	private static final String SPEL_LIJST_TITEL_ID = "spelLijstTitel";
	private final HtmlH3 spelLijstTitel = new HtmlH3(By.id(SPEL_LIJST_TITEL_ID));

	@Override
	public boolean arrivedAt() {
		return spelLijstTitel.isPresent();
	}

}
