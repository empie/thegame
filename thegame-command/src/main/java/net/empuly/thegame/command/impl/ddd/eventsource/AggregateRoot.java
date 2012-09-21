package net.empuly.thegame.command.impl.ddd.eventsource;

import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;

public interface AggregateRoot extends EventSource<Event> {

	@Override
	IdMetVersie idMetVersie();

	@Override
	List<Event> nogTePersisterenEvents();

	@Override
	void reconstrueer(Iterable<Event> events);

	void pasToeEnOnthoud(Event event);

	void markeerAlleNogTePersisterenEventsAlsGepersisteerd();

	
	
}
