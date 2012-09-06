package net.empuly.thegame.command.impl.domain.spel;

import java.util.List;

import net.empuly.thegame.command.impl.ddd.AggregateRootTrait;
import net.empuly.thegame.command.impl.ddd.AggregateRootTraitImpl;
import net.empuly.thegame.command.impl.ddd.Event;
import net.empuly.thegame.command.impl.ddd.IdMetVersie;

public class Spel implements AggregateRootTrait {

	private final AggregateRootTraitImpl aggregateRootTrait;

	private Spel() {
		this.aggregateRootTrait = new AggregateRootTraitImpl(null) {

			@Override
			protected void pasToe(final Event event) {

			}
		};
	}

	@Override
	public IdMetVersie idMetVersie() {
		return aggregateRootTrait.idMetVersie();
	}

	@Override
	public List<Event> nogTePersisterenEvents() {
		return aggregateRootTrait.nogTePersisterenEvents();
	}

	@Override
	public void pasToeEnOnthoud(final Event event) {
		aggregateRootTrait.pasToeEnOnthoud(event);
	}

	@Override
	public void reconstrueer(final Iterable<Event> events) {
		aggregateRootTrait.reconstrueer(events);
	}

	@Override
	public void alleEventsGepersisteerd() {
		aggregateRootTrait.alleEventsGepersisteerd();
	}

}
