package net.empuly.thegame.command.impl.ddd;

import java.util.List;

public interface EventSource<T extends Event> {

	List<T> nogTePersisterenEvents();

	IdMetVersie idMetVersie();

	void reconstrueer(Iterable<Event> events);

}
