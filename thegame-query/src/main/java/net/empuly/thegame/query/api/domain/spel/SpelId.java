package net.empuly.thegame.query.api.domain.spel;

import java.util.UUID;

import net.empuly.thegame.query.api.domain.ddd.ValueObject;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTrait;
import net.empuly.thegame.query.api.domain.ddd.ValueObjectTraitImpl;

@ValueObject
public class SpelId {

	private final UUID id;
	private ValueObjectTrait valueObjectTrait;

	public SpelId() {
		this.id = UUID.randomUUID();
		this.valueObjectTrait = new ValueObjectTraitImpl();
	}
	
	public UUID getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return valueObjectTrait.computeToString(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return valueObjectTrait.areEqual(this, obj);
	}
	
	@Override
	public int hashCode() {
		return valueObjectTrait.computeHashCode(this);
	}

}
