package net.empuly.thegame.query.api.domain.spel;

import static org.fest.assertions.Assertions.assertThat;

import net.empuly.thegame.query.api.domain.spel.SpelId;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

public class SpelIdTest {

	@Test
	public void nieuweSpelIdHeeftAltijdEenUuid() {
		assertThat(new SpelId().getId()).isNotNull();
	}
	
	@Test
	public void equalsAndHashCode() {
		new EqualsTester()
			.addEqualityGroup(new SpelId())
			.addEqualityGroup(new SpelId())
			.testEquals();
	}

}
