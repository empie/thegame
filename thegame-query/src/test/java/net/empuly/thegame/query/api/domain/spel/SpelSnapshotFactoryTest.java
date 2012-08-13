package net.empuly.thegame.query.api.domain.spel;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

import net.empuly.thegame.query.api.domain.spel.SpelId;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotFactory;
import net.empuly.thegame.query.api.domain.spel.SpelStatus;
import net.empuly.thegame.query.testutils.FixedDateTimeRule;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class SpelSnapshotFactoryTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Rule
	public FixedDateTimeRule fixedDateTimeRule = FixedDateTimeRule.create();
	
	private SpelSnapshotFactory spelSnapshotFactory; 
	
	@Before
	public void setUp() {
		fixedDateTimeRule.setFixedNow();
		spelSnapshotFactory = new SpelSnapshotFactory();
	}
	
	@Test
	public void wanneerSpelIdNullBijMakenVanSpelSnapshotDanNullpointer() throws Exception {
		expectedException.expect(NullPointerException.class);
		spelSnapshotFactory.maakSpelSnapshot(null, new LocalDateTime(), SpelStatus.BEEINDIGD);
	}
	
	@Test
	public void wanneerTijdstipAangemaaktNullBijMakenVanSpelSnapshotDanNullpointer() throws Exception {
		expectedException.expect(NullPointerException.class);
		spelSnapshotFactory.maakSpelSnapshot(new SpelId(), null, SpelStatus.BEEINDIGD);
	}

	@Test
	public void wanneerSpelStatusNullBijMakenVanSpelSnapshotDanNullpointer() throws Exception {
		expectedException.expect(NullPointerException.class);
		spelSnapshotFactory.maakSpelSnapshot(new SpelId(), new LocalDateTime(), null);
	}
	
	@Test
	public void wanneerTijdstipAangemaaktInDeToekomstBijMakenVanSpelSnapshotDanIllegalArgument() throws Exception {
		expectedException.expect(IllegalArgumentException.class);
		spelSnapshotFactory.maakSpelSnapshot(new SpelId(), new LocalDateTime().plusMillis(1), SpelStatus.BEEINDIGD);
	}

	
}
