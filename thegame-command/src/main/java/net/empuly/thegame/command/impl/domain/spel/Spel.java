package net.empuly.thegame.command.impl.domain.spel;

import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventsource.AggregateRoot;
import net.empuly.thegame.command.impl.ddd.eventsource.AggregateRootTraitImpl;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;

public class Spel implements AggregateRoot {

	private final AggregateRootTraitImpl aggregateRootTrait;

	private Spel(IdMetVersie idMetVersie) {
		this.aggregateRootTrait = new AggregateRootTraitImpl(idMetVersie) {

			@Override
			protected void pasToe(final Event event) {

			}
		};
	}

	@Override
	public IdMetVersie idMetVersie() {
		return this.aggregateRootTrait.idMetVersie();
	}

	@Override
	public void markeerAlleNogTePersisterenEventsAlsGepersisteerd() {
		this.aggregateRootTrait.markeerAlleNogTePersisterenEventsAlsGepersisteerd();
	}

	@Override
	public List<Event> nogTePersisterenEvents() {
		return this.aggregateRootTrait.nogTePersisterenEvents();
	}

	@Override
	public void pasToeEnOnthoud(final Event event) {
		this.aggregateRootTrait.pasToeEnOnthoud(event);
	}

	@Override
	public void reconstrueer(final Iterable<Event> events) {
		this.aggregateRootTrait.reconstrueer(events);
	}

}
