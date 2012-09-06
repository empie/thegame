package net.empuly.thegame.web.webdriver.spel;

import static org.fest.assertions.Assertions.assertThat;
import net.empuly.thegame.db.testdata.row.SpelSnapshotRow;
import net.empuly.thegame.query.testutils.WebdriverTest;
import net.empuly.thegame.web.testutil.webdriver.ArrivedAssert;
import net.empuly.thegame.web.webdriver.pagina.ThegameApplicatie;
import net.empuly.thegame.web.webdriver.pagina.spel.SpelLijstPagina;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(WebdriverTest.class)
public class ThegameWebdriverTest {

	private SpelSnapshotRow oudsteSpelSnapshotRow = SpelSnapshotRow.spelSnapshotMet().allesIngevuld().tijdstipAangemaakt(new LocalDateTime().minusDays(2));
	private SpelSnapshotRow jongsteSpelSnapshotRow = SpelSnapshotRow.spelSnapshotMet().allesIngevuld().tijdstipAangemaakt(new LocalDateTime().minusDays(1));
	
	@Test
	public void gegeven_geenSpellenInDeLijst_wanneer_opSpelLijstPagina_dan_geenTabelMaarBoodschapGetoond() {
		final SpelLijstPagina spelLijstPagina = ThegameApplicatie.navigeerNaarRoot();
		ArrivedAssert.assertThat(spelLijstPagina).arrivedAt();
		assertThat(spelLijstPagina.geenSpelenGetoond()).isTrue();
	}
	
	@Test
	public void gegeven_meerdereSpellenInDeLijst_wanneer_opSpelLijstPagina_dan_tabelMetSpelenGetoond() {
		final SpelLijstPagina spelLijstPagina = ThegameApplicatie.navigeerNaarRoot();
		ArrivedAssert.assertThat(spelLijstPagina).arrivedAt();
		assertThat(spelLijstPagina.geenSpelenGetoond()).isFalse();
	}
}
