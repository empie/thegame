package net.empuly.thegame.command.impl.ddd.repository;

import java.util.UUID;

import net.empuly.thegame.command.impl.ddd.eventsource.AggregateRoot;

public interface Repository<T extends AggregateRoot> {

	void bewaar(T aggregateRoot);

	T haalLaatsteVersieOpViaId(UUID id) throws AggregateRootNotFoundException;

}
