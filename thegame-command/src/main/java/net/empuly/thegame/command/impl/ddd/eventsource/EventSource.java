package net.empuly.thegame.command.impl.ddd.eventsource;

import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;

public interface EventSource<T extends Event> {

	List<T> nogTePersisterenEvents();

	IdMetVersie idMetVersie();

	void reconstrueer(Iterable<Event> events);

}
