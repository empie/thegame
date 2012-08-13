package net.empuly.thegame.query.api.domain.spel;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import net.empuly.thegame.query.api.domain.ddd.SnapshotFactory;

import org.joda.time.LocalDateTime;

@SnapshotFactory
public class SpelSnapshotFactory {

	public SpelSnapshot maakSpelSnapshot(SpelId spelId, LocalDateTime tijdstipAangemaakt, SpelStatus spelStatus) {
		checkNotNull(spelId);
		checkNotNull(tijdstipAangemaakt);
		checkNotNull(spelStatus);
		
		checkArgument(tijdstipAangemaaktNietInDeToekomst(tijdstipAangemaakt));
		
		
		return new SpelSnapshot(spelId, tijdstipAangemaakt, spelStatus);
	}

	private boolean tijdstipAangemaaktNietInDeToekomst(LocalDateTime tijdstipAangemaakt) {
		return tijdstipAangemaakt.isBefore(new LocalDateTime());
	}

	
	
}
