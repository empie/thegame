package net.empuly.thegame.query.api.domain.spel;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpelStatusTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void kanCodeOmzettenNaarOvereenkomstigeSpelStatus() throws Exception {
		for (final SpelStatus current : SpelStatus.values()) {
			assertThat(SpelStatus.fromCode(current.getCode())).isSameAs(current);
		}
	}
	
	@Test
	public void gegeven_EenOnbestaandeCode_wanneer_fromCode_dan_IllegalArgumentException() {
		expectedException.expect(IllegalArgumentException.class);
		SpelStatus.fromCode(-1);
	}

}
