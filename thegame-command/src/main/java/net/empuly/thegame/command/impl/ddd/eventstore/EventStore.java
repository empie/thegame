package net.empuly.thegame.command.impl.ddd.eventstore;

import java.util.UUID;

import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventsource.EventSource;

public interface EventStore {

	void bewaarEventSource(EventSource<? extends Event> eventSourceOmTeBewaren);

	<T extends EventSource<? extends Event>> T laadEventSourceViaId(Class<T> typeVanEventSourceDatJeVerwacht, UUID idVanDeEventSource);
}
