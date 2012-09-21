package net.empuly.thegame.command.impl.ddd.eventsource;

import java.util.UUID;

import net.empuly.thegame.query.api.domain.ddd.ValueObject;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTrait;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTraitImpl;

@ValueObject
public class IdMetVersie {
	static final long INITIELE_VERSIE = 0;

	private final ValueObjectTrait valueObjectTrait;
	private final UUID id;
	private final long versie;

	IdMetVersie(final UUID id, final long versie) {
		this.id = id;
		this.versie = versie;
		valueObjectTrait = new ValueObjectTraitImpl();
	}

	@Override
	public boolean equals(final Object obj) {
		return valueObjectTrait.areEqual(this, obj);
	}

	@Override
	public int hashCode() {
		return valueObjectTrait.computeHashCode(this);
	}

	public UUID id() {
		return id;
	}

	public boolean isInitieleVersie() {
		return versie == INITIELE_VERSIE;
	}

	@Override
	public String toString() {
		return valueObjectTrait.computeToString(this);
	}

	public long versie() {
		return versie;
	}

	public IdMetVersie volgendeVersie() {
		return andereVersie(versie + 1);
	}

	private IdMetVersie andereVersie(final long andereVersie) {
		return new IdMetVersieFactory().specifiekeVersieVanSpecifiekeId(id, andereVersie);
	}

}
