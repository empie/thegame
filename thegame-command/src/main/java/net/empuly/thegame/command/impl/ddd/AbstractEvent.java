package net.empuly.thegame.command.impl.ddd;

import static com.google.common.base.Preconditions.checkNotNull;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTrait;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTraitImpl;

public abstract class AbstractEvent implements Event{

	private final IdMetVersie aggregateRootId;
	private final ValueObjectTrait valueObjectTrait;

	AbstractEvent(final IdMetVersie aggregateRootId) {
		checkNotNull(aggregateRootId);
		this.aggregateRootId = aggregateRootId;
		this.valueObjectTrait =  new ValueObjectTraitImpl();
	}

	@Override
	public boolean equals(final Object obj) {
		return valueObjectTrait.areEqual(this, obj);
	}

	@Override
	public IdMetVersie aggregateRootId() {
		return aggregateRootId;
	}

	@Override
	public int hashCode() {
		return valueObjectTrait.computeHashCode(this);
	}

	@Override
	public String toString() {
		return valueObjectTrait.computeToString(this);
	}

}
