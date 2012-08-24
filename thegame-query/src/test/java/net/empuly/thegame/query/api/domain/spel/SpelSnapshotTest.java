package net.empuly.thegame.query.api.domain.spel;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import com.google.common.testing.EqualsTester;

public class SpelSnapshotTest {
	
	@Test
	public void equalsAndHashcode() {
		final SpelId spelId = new SpelId();
		final LocalDateTime tijdstipAangemaakt = new LocalDateTime().minusMinutes(3);
		final SpelSnapshot spelSnapshot1 = new SpelSnapshotFactory().maakSpelSnapshot(spelId, tijdstipAangemaakt, SpelStatus.BEEINDIGD);
		final SpelSnapshot spelSnapshot2 = new SpelSnapshotFactory().maakSpelSnapshot(new SpelId(), tijdstipAangemaakt, SpelStatus.BEEINDIGD);
		final SpelSnapshot spelSnapshot3 = new SpelSnapshotFactory().maakSpelSnapshot(spelId, tijdstipAangemaakt.minusDays(1), SpelStatus.BEEINDIGD);
		final SpelSnapshot spelSnapshot4 = new SpelSnapshotFactory().maakSpelSnapshot(spelId, tijdstipAangemaakt, SpelStatus.GESTART);
		final SpelSnapshot spelSnapshotEqualTo1 = new SpelSnapshotFactory().maakSpelSnapshot(spelId, tijdstipAangemaakt, SpelStatus.BEEINDIGD);

		new EqualsTester()
			.addEqualityGroup(spelSnapshot1,spelSnapshotEqualTo1)
			.addEqualityGroup(spelSnapshot2)
			.addEqualityGroup(spelSnapshot3)
			.addEqualityGroup(spelSnapshot4)
			.testEquals();
	}

}
