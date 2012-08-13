package net.empuly.thegame.query.api.domain.ddd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ValueObjectTraitImpl implements ValueObjectTrait {

	private static final String NAME_OF_TRAIT_VARIABLE = "valueObjectTrait";

	@Override
	public boolean areEqual(Object firstValueObject, Object otherValueObject) {
		return EqualsBuilder.reflectionEquals(firstValueObject, otherValueObject,NAME_OF_TRAIT_VARIABLE);
	}

	@Override
	public int computeHashCode(Object valueObject) {
		return HashCodeBuilder.reflectionHashCode(valueObject, NAME_OF_TRAIT_VARIABLE);
	}

	@Override
	public String computeToString(Object valueObject) {
		return ToStringBuilder.reflectionToString(valueObject, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
