package net.empuly.thegame.command.impl.ddd.eventsource;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;

public abstract class AggregateRootTraitImpl implements AggregateRoot {

	private final IdMetVersie id;
	private final List<Event> nogTePersisterenEvents;

	public AggregateRootTraitImpl(final IdMetVersie id) {
		checkNotNull(id);
		this.id = id;
		this.nogTePersisterenEvents = new ArrayList<Event>();
	}

	@Override
	public List<Event> nogTePersisterenEvents() {
		return Collections.unmodifiableList(nogTePersisterenEvents);
	}

	@Override
	public IdMetVersie idMetVersie() {
		return id;
	}

	@Override
	public void reconstrueer(final Iterable<Event> events) {
		checkNotNull(events);
		for (final Event event : events) {
			pasToeMetControles(event);
		}
	}

	private void pasToeMetControles(Event event) {
		checkNotNull(event);
		pasToe(event);
	}

	@Override
	public final void pasToeEnOnthoud(final Event event) {
		pasToeMetControles(event);
		nogTePersisterenEvents.add(event);
	}

	protected abstract void pasToe(Event event);

	@Override
	public void markeerAlleNogTePersisterenEventsAlsGepersisteerd() {
		nogTePersisterenEvents.clear();
	}

}