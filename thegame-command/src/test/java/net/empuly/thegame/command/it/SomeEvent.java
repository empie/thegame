package net.empuly.thegame.command.it;

import net.empuly.thegame.command.impl.ddd.event.AbstractEvent;
import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;

class SomeEvent extends AbstractEvent implements Event {
	SomeEvent(IdMetVersie aggregateRootId) {
		super(aggregateRootId);
	}

}