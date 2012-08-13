package net.empuly.thegame.query.api.domain.spel;

import java.io.Serializable;

import net.empuly.thegame.query.api.domain.ddd.Snapshot;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTrait;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTraitImpl;

import org.joda.time.LocalDateTime;

@Snapshot
public class SpelSnapshot implements Serializable {

	private static final long serialVersionUID = 1L;

	private final SpelId spelId;

	private final LocalDateTime tijdstipAangemaakt;

	private final SpelStatus status;

	private final ValueObjectTrait valueObjectTrait;

	SpelSnapshot(final SpelId spelId, final LocalDateTime tijdstipAangemaakt, final SpelStatus status) {
		this.spelId = spelId;
		this.tijdstipAangemaakt = tijdstipAangemaakt;
		this.status = status;
		this.valueObjectTrait = new ValueObjectTraitImpl();
	}

	@Override
	public boolean equals(final Object obj) {
		return valueObjectTrait.areEqual(this, obj);
	}
	@Override
	public int hashCode() {
		return valueObjectTrait.computeHashCode(this);
	}
	@Override
	public String toString() {
		return valueObjectTrait.computeToString(this);
	}

	public SpelId getSpelId() {
		return spelId;
	}

	public SpelStatus getStatus() {
		return status;
	}

	public LocalDateTime getTijdstipAangemaakt() {
		return tijdstipAangemaakt;
	}

}
