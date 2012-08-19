package net.empuly.thegame.query.api.domain.spel;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

import org.fest.assertions.Assertions;
import org.joda.time.LocalDateTime;

public class SpelSnapshotAssert {

	public static SpelSnapshotAssert assertThat(final SpelSnapshot spelsnapshot) {
		return new SpelSnapshotAssert(spelsnapshot);
	}

	private final SpelSnapshot spelsnapshot;

	public SpelSnapshotAssert(final SpelSnapshot spelsnapshot) {
		checkNotNull(spelsnapshot);
		this.spelsnapshot = spelsnapshot;
	}
	
	public void heeftSnapshotVelden(final UUID spelId, final LocalDateTime tijdstipAangemaakt, final int spelStatusCode) {
		heeftSnapshotVelden(spelId,tijdstipAangemaakt,SpelStatus.fromCode(spelStatusCode));
	}

	public void heeftSnapshotVelden(final UUID spelId, final LocalDateTime tijdstipAangemaakt, final SpelStatus spelStatus) {
		heeftSpelId(spelId);
		heeftTijdstipcAangemaakt(tijdstipAangemaakt);
		heeftSpelStatus(spelStatus);
	}

	public void heeftSpelId(final UUID spelId) {
		Assertions.assertThat(spelsnapshot.getSpelId().getId()).isEqualTo(spelId);
	}

	public void heeftSpelStatus(final SpelStatus spelStatus) {
		Assertions.assertThat(spelsnapshot.getStatus()).isEqualTo(spelStatus);
	}

	public void heeftTijdstipcAangemaakt(final LocalDateTime tijdstipAangemaakt) {
		Assertions.assertThat(spelsnapshot.getTijdstipAangemaakt()).isEqualTo(tijdstipAangemaakt);
	}
}
