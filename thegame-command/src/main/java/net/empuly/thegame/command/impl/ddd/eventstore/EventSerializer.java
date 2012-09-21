package net.empuly.thegame.command.impl.ddd.eventstore;

import net.empuly.thegame.command.impl.ddd.event.Event;

public interface EventSerializer {

	Event deserialize(String serialized);

	String serialize(Event event);

}