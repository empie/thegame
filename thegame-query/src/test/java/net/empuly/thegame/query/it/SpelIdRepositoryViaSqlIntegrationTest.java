package net.empuly.thegame.query.it;

import static org.fest.assertions.Assertions.assertThat;

import java.util.UUID;

import net.empuly.thegame.db.testdata.TestDataInserter;
import net.empuly.thegame.db.testdata.row.SpelSnapshotRow;
import net.empuly.thegame.query.api.domain.spel.SpelIdRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context-thegame-query.xml", "/context-thegame-app-test.xml" })
public class SpelIdRepositoryViaSqlIntegrationTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Autowired
	private SpelIdRepository spelIdRepository;

	@Autowired
	private TestDataInserter testDataInserter;

	private SpelSnapshotRow spelSnapshotRow;

	@Test
	public void gegeven_eenbestaandeUUIDInDeDatabank_wanneer_spelIdBestaat_dan_true() throws Exception {
		assertThat(spelIdRepository.spelIdBestaat(spelSnapshotRow.getId())).isTrue();
	}

	@Test
	public void gegeven_eenLegeDatabank_wanneer_spelIdBestaat_dan_false() throws Exception {
		assertThat(spelIdRepository.spelIdBestaat(UUID.randomUUID())).isFalse();
	}

	@Test
	public void gegeven_eenParameterDieNullIs_wanneer_spelIdBestaat_dan_nullpointerException() throws Exception {
		expectedException.expect(NullPointerException.class);
		spelIdRepository.spelIdBestaat(null);
	}

	@Before
	public void setUp() {
		spelSnapshotRow = SpelSnapshotRow.spelSnapshotMet().allesIngevuld();
		testDataInserter.with(spelSnapshotRow).clearAndInsert();
	}
}
