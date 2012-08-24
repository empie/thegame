package net.empuly.thegame.query.it;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import net.empuly.thegame.db.testdata.TestDataInserter;
import net.empuly.thegame.db.testdata.row.SpelSnapshotRow;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshot;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotAssert;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotRepository;
import net.empuly.thegame.query.testutils.IntegrationTest;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context-thegame-query.xml", "/context-thegame-app-test.xml" })
public class SpelSnapshotRepositoryViaSqlIntegrationTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Autowired
	private SpelSnapshotRepository spelSnapshotRepository;

	@Autowired
	private TestDataInserter testDataInserter;

	private SpelSnapshotRow spelSnapshotRow;
	private SpelSnapshotRow spelSnapshotRow2;

	@Test
	public void gegeven_eenLegeDatabank_als_alleSpelenOpgevraagd_dan_legeLijst() throws Exception {
		testDataInserter.clear();

		assertThat(spelSnapshotRepository.alleSpelen()).isEmpty();
	}

	@Test
	public void gegeven_tweeSnapshotsInDatabank_als_alleSpelenOpgevraagd_dan_LijstMetTweeElementenGesorteerdVolgensTijdstipToegevoegdNieuwsteEerst()
			throws Exception {

		final List<SpelSnapshot> alleSpelen = spelSnapshotRepository.alleSpelen();
		assertThat(alleSpelen).hasSize(2);
		final SpelSnapshot eersteSpel = alleSpelen.get(0);
		final SpelSnapshot oudsteSpel = alleSpelen.get(1);
		SpelSnapshotAssert.assertThat(eersteSpel).heeftSnapshotVelden(
				spelSnapshotRow.getId(),
				spelSnapshotRow.getTijdstipAangemaakt(),
				spelSnapshotRow.getStatusCode());
		SpelSnapshotAssert.assertThat(oudsteSpel).heeftSnapshotVelden(
				spelSnapshotRow2.getId(),
				spelSnapshotRow2.getTijdstipAangemaakt(),
				spelSnapshotRow2.getStatusCode());

	}

	@Before
	public void setUp() {
		spelSnapshotRow = SpelSnapshotRow.spelSnapshotMet().allesIngevuld();
		spelSnapshotRow2 = SpelSnapshotRow.spelSnapshotMet().allesIngevuld().tijdstipAangemaakt(tijdstipVerderInVerledenDanAndereRow());
		testDataInserter.with(spelSnapshotRow2, spelSnapshotRow).clearAndInsert();
	}

	private LocalDateTime tijdstipVerderInVerledenDanAndereRow() {
		return spelSnapshotRow.getTijdstipAangemaakt().minusDays(1);
	}

}
