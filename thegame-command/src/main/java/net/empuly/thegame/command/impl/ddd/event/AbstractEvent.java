package net.empuly.thegame.command.impl.ddd.event;

import static com.google.common.base.Preconditions.checkNotNull;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTrait;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTraitImpl;

public abstract class AbstractEvent implements Event {

	private final IdMetVersie aggregateRootId;
	private final ValueObjectTrait valueObjectTrait;

	protected AbstractEvent(final IdMetVersie aggregateRootId) {
		checkNotNull(aggregateRootId);
		this.aggregateRootId = aggregateRootId;
		this.valueObjectTrait = new ValueObjectTraitImpl();
	}

	@Override
	public boolean equals(final Object obj) {
		return this.valueObjectTrait.areEqual(this, obj);
	}

	@Override
	public IdMetVersie eventVoorAggregateRootMetId() {
		return this.aggregateRootId;
	}

	@Override
	public int hashCode() {
		return this.valueObjectTrait.computeHashCode(this);
	}

	@Override
	public String toString() {
		return this.valueObjectTrait.computeToString(this);
	}

}
