package net.empuly.thegame.web.webdriver.pagina.spel;

import net.empuly.thegame.web.testutil.webdriver.Pagina;
import net.empuly.thegame.web.testutil.webdriver.elements.HtmlHx;
import net.empuly.thegame.web.testutil.webdriver.elements.HtmlSpan;

import org.openqa.selenium.By;

public class SpelLijstPagina extends Pagina<SpelLijstPagina> {

	private static final String SPEL_LIJST_ARTIKEL_ID = "spelLijstArtikel";
	private static final String SPEL_LIJST_TITEL_ID = "spelLijstTitel";
	private static final String GEEN_SPELEN_SPAN_ID = "geenSpelenSpan";
	private final HtmlHx spelLijstTitel = new HtmlHx(By.id(SPEL_LIJST_TITEL_ID));
	private final HtmlSpan geenSpelenSpan= new HtmlSpan(By.id(GEEN_SPELEN_SPAN_ID));

	@Override
	public boolean arrivedAt() {
		return spelLijstTitel.isPresent();
	}

	public boolean geenSpelenGetoond() {
		return geenSpelenSpan.isPresent();
	}

}
