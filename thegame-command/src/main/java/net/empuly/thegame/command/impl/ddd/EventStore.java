package net.empuly.thegame.command.impl.ddd;

import java.util.UUID;

public interface EventStore {

	void bewaarEventSource(EventSource<? extends Event> eventSourceOmTeBewaren);

	<T extends EventSource<? extends Event>> T laadEventSourceViaId(Class<T> typeVanEventSourceDatJeVerwacht, UUID idVanDeEventSource);

	<T extends EventSource<? extends Event>> T laadEventSourceViaIdMetVersie(Class<T> typeVanEventSourceDatJeVerwacht, IdMetVersie idMetVersieVanDeEventSource);

}
