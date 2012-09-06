package net.empuly.thegame.command.impl.ddd;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRootTraitImpl implements AggregateRootTrait {

	private final IdMetVersie id;
	private final List<Event> nogTePersisterenEvents;

	public AggregateRootTraitImpl(final IdMetVersie id) {
		checkNotNull(id);
		this.id = id;
		this.nogTePersisterenEvents = new ArrayList<Event>();
	}

	@Override
	public List<Event> nogTePersisterenEvents() {
		return new ArrayList<Event>(nogTePersisterenEvents);
	}
	
	@Override
	public IdMetVersie idMetVersie() {
		return id;
	}

	@Override
	public void reconstrueer(final Iterable<Event> events) {
		for (final Event event : events) {
			pasToe(event);
		}
	}

	@Override
	public final void pasToeEnOnthoud(final Event event) {
		pasToe(event);
		nogTePersisterenEvents.add(event);
	}

	protected abstract void pasToe(Event event);

	@Override
	public void alleEventsGepersisteerd() {
		nogTePersisterenEvents.clear();
	}

}