package net.empuly.thegame.command.impl.ddd;

import java.util.List;

public interface AggregateRootTrait extends EventSource<Event> {

	IdMetVersie idMetVersie();

	List<Event> nogTePersisterenEvents();

	void reconstrueer(Iterable<Event> events);

	void pasToeEnOnthoud(Event event);

	void alleEventsGepersisteerd();

	
	
}
