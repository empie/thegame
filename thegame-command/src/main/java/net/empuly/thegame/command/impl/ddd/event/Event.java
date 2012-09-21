package net.empuly.thegame.command.impl.ddd.event;

import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;

public interface Event {

	IdMetVersie eventVoorAggregateRootMetId();
	
}
