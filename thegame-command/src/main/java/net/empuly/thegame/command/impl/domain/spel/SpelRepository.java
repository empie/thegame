package net.empuly.thegame.command.impl.domain.spel;

import java.util.UUID;

import net.empuly.thegame.command.impl.ddd.eventstore.EventStore;
import net.empuly.thegame.command.impl.ddd.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Repository
public class SpelRepository implements Repository<Spel> {

	@Autowired
	private EventStore eventStore;

	@Override
	public void bewaar(final Spel spel) {
		this.eventStore.bewaarEventSource(spel);
		spel.markeerAlleNogTePersisterenEventsAlsGepersisteerd();
	}

	@Override
	public Spel haalLaatsteVersieOpViaId(final UUID id) {
		final Spel spel = this.eventStore.laadEventSourceViaId(Spel.class, id);
		return spel;
	}

}
