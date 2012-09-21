package net.empuly.thegame.command.impl.ddd.eventsource;

import static org.fest.assertions.Assertions.assertThat;

import java.util.UUID;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

public class IdMetVersieTest {

	private static final UUID UUID1 = UUID.randomUUID();
	private static final UUID UUID2 = UUID.randomUUID();

	@Test
	public void equalsAndHashCode() {
		new EqualsTester()
				.addEqualityGroup(new IdMetVersie(UUID1, 1), new IdMetVersie(UUID1, 1))
				.addEqualityGroup(new IdMetVersie(UUID1, 2))
				.addEqualityGroup(new IdMetVersie(UUID2, 2))
				.testEquals();
	}

	@Test
	public void volgendeVersieMaaktNieuweIdMetVersieMetVersienummerEentjeOpgehoogd() {
		IdMetVersie idMetVersie = new IdMetVersie(UUID1, 12);
		IdMetVersie volgendeVersie = idMetVersie.volgendeVersie();
		assertThat(idMetVersie.id()).isEqualTo(volgendeVersie.id());
		assertThat(idMetVersie.versie()).isEqualTo(volgendeVersie.versie() - 1);
	}

	@Test
	public void wanneerIdMetVersieEenInitieleVersieTrue() {
		assertThat(new IdMetVersie(UUID.randomUUID(), IdMetVersie.INITIELE_VERSIE).isInitieleVersie()).isTrue();
	}

	@Test
	public void wanneerIdMetVersieNietEenInitieleVersieFalse() {
		assertThat(new IdMetVersie(UUID.randomUUID(), IdMetVersie.INITIELE_VERSIE + 1).isInitieleVersie()).isFalse();
	}
}
