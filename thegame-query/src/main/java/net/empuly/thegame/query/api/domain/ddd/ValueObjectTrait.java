package net.empuly.thegame.query.api.domain.ddd;

public interface ValueObjectTrait {
	
	public boolean areEqual(Object firstValueObject, Object otherValueObject);
	
	public int computeHashCode(Object valueObject);
	
	public String computeToString(Object valueObject);
	
}
