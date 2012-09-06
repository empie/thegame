package net.empuly.thegame.command.impl.domain.spel;

import java.util.UUID;

import net.empuly.thegame.command.impl.ddd.EventStore;
import net.empuly.thegame.command.impl.ddd.IdMetVersie;
import net.empuly.thegame.command.impl.ddd.Repository;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Repository
public class SpelRepository implements Repository<Spel> {

	@Autowired
	private EventStore eventStore;

	@Override
	public void bewaar(final Spel spel) {
		eventStore.storeEventSource(spel);
		spel.alleEventsGepersisteerd();
	}

	@Override
	public Spel haalLaatsteVersieOpViaId(final UUID id) {
		final Spel spel = eventStore.laadEventSource(Spel.class, id);
		return spel;
	}

	@Override
	public Spel haalOpViaIdMetVersie(final IdMetVersie idMetVersie) {
		final Spel spel = eventStore.laadEventSource(Spel.class, idMetVersie);
		return spel;
	}

}
