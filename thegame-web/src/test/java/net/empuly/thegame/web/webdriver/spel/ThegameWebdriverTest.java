package net.empuly.thegame.web.webdriver.spel;

import net.empuly.thegame.query.testutils.WebdriverTest;
import net.empuly.thegame.web.testutil.webdriver.ArrivedAssert;
import net.empuly.thegame.web.webdriver.pagina.ThegameApplicatie;
import net.empuly.thegame.web.webdriver.pagina.spel.SpelLijstPagina;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(WebdriverTest.class)
public class ThegameWebdriverTest {

	@Test
	public void kanLijstMetAlleSpellenOpvragen() {
		final SpelLijstPagina spelLijstPagina = ThegameApplicatie.navigeerNaarRoot();
		ArrivedAssert.assertThat(spelLijstPagina).arrivedAt();

	}
}
