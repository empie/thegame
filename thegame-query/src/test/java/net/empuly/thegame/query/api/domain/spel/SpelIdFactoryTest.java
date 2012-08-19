package net.empuly.thegame.query.api.domain.spel;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import net.empuly.thegame.query.testutils.MockitoRule;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SpelIdFactoryTest {
	
	private static final java.util.UUID UUID = java.util.UUID.randomUUID();

	@Rule
	public MockitoRule mockitodRule = new MockitoRule(this);
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Mock
	private SpelIdRepository spelIdRepositoryMock;
	
	@InjectMocks
	private final SpelIdFactory spelIdFactory = new SpelIdFactory();
	
	@Test
	public void testKanNieuweSpelIdAanmaken() throws Exception {
		final SpelId nieuweSpelId = spelIdFactory.nieuweSpelId();
		assertThat(nieuweSpelId).isNotNull();
		assertThat(nieuweSpelId.getId()).isNotNull();
	}
	
	@Test
	public void gegeven_parameterDieNullIs_wanneer_bestaandeSpelIdVanString_dan_NullpointerException() throws Exception {
		expectedException.expect(NullPointerException.class);
		spelIdFactory.bestaandeSpelIdVanString(null);
	}
	
	@Test
	public void gegeven_parameterDieNiet36LangIs_wanneer_bestaandeSpelIdVanString_dan_IllegalArgumentException() throws Exception {
		expectedException.expect(IllegalArgumentException.class);
		spelIdFactory.bestaandeSpelIdVanString(RandomStringUtils.randomAlphabetic(35));
	}
	
	@Test
	public void gegeven_uuidDieNietInDeDatabankGekendIsAlsSpelId_wanneer_bestaandeSpelIdVanString_dan_IllegalStateException() throws Exception {
		when(spelIdRepositoryMock.spelIdBestaat(UUID)).thenReturn(false);
		expectedException.expect(IllegalStateException.class);
		spelIdFactory.bestaandeSpelIdVanString(UUID.toString());
	}
	
	@Test
	public void gegeven_uuidDieInDeDatabankGekendIsAlsSpelId_wanneer_bestaandeSpelIdVanString_dan_SpelIdAangemaakt() throws Exception {
		when(spelIdRepositoryMock.spelIdBestaat(UUID)).thenReturn(true);
		SpelId spelIdVanString = spelIdFactory.bestaandeSpelIdVanString(UUID.toString());
		assertThat(spelIdVanString).isNotNull();
		assertThat(spelIdVanString.getId()).isEqualTo(UUID);
	}

}
