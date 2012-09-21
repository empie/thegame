package net.empuly.thegame.command.impl.ddd.eventsource;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import net.empuly.thegame.query.testutils.MockitoRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

public class IdMetVersieFactoryTest {

	private static final long GELDIGE_VERSIE = 5;

	@Rule
	public MockitoRule mockitoRule = new MockitoRule(this);

	@Rule
	public ExpectedException expectException = ExpectedException.none();

	private static final UUID RANDOM_UUID = UUID.randomUUID();
	private final IdMetVersieFactory idMetVersieFactory = new IdMetVersieFactory();
	@Mock
	private IdMetVersie versieMetIdMock;;

	@Test
	public void initieleVersieMetIdDelegeertDoorNaarSpecifiekeVersie() {
		IdMetVersieFactory idMetVersieFactorySpy = spy(idMetVersieFactory);
		doReturn(versieMetIdMock).when(idMetVersieFactorySpy).specifiekeVersieVanSpecifiekeId(RANDOM_UUID, IdMetVersie.INITIELE_VERSIE);
		IdMetVersie initieleVersieMetId = idMetVersieFactorySpy.initieleVersieMetId(RANDOM_UUID);
		verify(idMetVersieFactorySpy).specifiekeVersieVanSpecifiekeId(RANDOM_UUID, IdMetVersie.INITIELE_VERSIE);
		assertThat(initieleVersieMetId).isEqualTo(versieMetIdMock);
	}

	@Test
	public void specifiekeVersieVanSpecifiekeIdKanEnkelWordenOpgeroepenMetIdVerschillendVanNull() {
		expectException.expect(NullPointerException.class);
		idMetVersieFactory.specifiekeVersieVanSpecifiekeId(null, 0);
	}

	@Test
	public void specifiekeVersieVanSpecifiekeIdKanEnkelWordenOpgeroepenMetVersieGroterDanNul() {
		expectException.expect(IllegalArgumentException.class);
		idMetVersieFactory.specifiekeVersieVanSpecifiekeId(RANDOM_UUID, -1);
	}

	@Test
	public void specifiekeVersieVanSpecifiekeId() {
		IdMetVersie specifiekeVersieVanSpecifiekeId = idMetVersieFactory.specifiekeVersieVanSpecifiekeId(RANDOM_UUID, GELDIGE_VERSIE);
		assertThat(specifiekeVersieVanSpecifiekeId.id()).isEqualTo(RANDOM_UUID);
		assertThat(specifiekeVersieVanSpecifiekeId.versie()).isEqualTo(GELDIGE_VERSIE);
	}
}
