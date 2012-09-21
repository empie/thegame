package net.empuly.thegame.command.it;

import java.util.ArrayList;
import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventsource.AggregateRootTraitImpl;
import net.empuly.thegame.command.impl.ddd.eventsource.EventSource;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;

public class SomeEventSource implements EventSource<SomeEvent> {

	private final AggregateRootTraitImpl aggregateRootTrait;

	public List<Event> events = new ArrayList<Event>();

	public SomeEventSource(IdMetVersie idMetVersie) {

		this.aggregateRootTrait = new AggregateRootTraitImpl(idMetVersie) {

			@Override
			protected void pasToe(final Event event) {
				SomeEventSource.this.events.add(event);
			}
		};

	}

	public List<Event> getEvents() {
		return this.events;
	}

	@Override
	public IdMetVersie idMetVersie() {
		return this.aggregateRootTrait.idMetVersie();
	}

	@Override
	public List<SomeEvent> nogTePersisterenEvents() {
		return new ArrayList<SomeEvent>();
	}

	@Override
	public void reconstrueer(final Iterable<Event> events) {
		this.aggregateRootTrait.reconstrueer(events);
	}

}