package net.empuly.thegame.query.api.domain.spel;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import net.empuly.thegame.query.api.domain.ddd.SnapshotFactory;

import org.joda.time.LocalDateTime;

@SnapshotFactory
public class SpelSnapshotFactory {

	public SpelSnapshot maakSpelSnapshot(final SpelId spelId, final LocalDateTime tijdstipAangemaakt, final SpelStatus spelStatus) {
		checkNotNull(spelId);
		checkNotNull(tijdstipAangemaakt);
		checkNotNull(spelStatus);

		checkArgument(tijdstipAangemaaktNietInDeToekomst(tijdstipAangemaakt));

		return new SpelSnapshot(spelId, tijdstipAangemaakt, spelStatus);
	}

	private boolean tijdstipAangemaaktNietInDeToekomst(final LocalDateTime tijdstipAangemaakt) {
		return tijdstipAangemaakt.isBefore(new LocalDateTime());
	}

}
