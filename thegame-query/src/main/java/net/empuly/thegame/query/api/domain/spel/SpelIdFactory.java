package net.empuly.thegame.query.api.domain.spel;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.UUID;

import javax.inject.Inject;

import net.empuly.thegame.query.api.domain.ddd.ValueObjectFactory;

@ValueObjectFactory
public class SpelIdFactory {

	@Inject
	private SpelIdRepository spelIdRepository;

	public SpelId bestaandeSpelIdVanString(final String bestaandeSpelId) {
		checkNotNull(bestaandeSpelId);
		checkArgument(bestaandeSpelId.length() == 36, "bestaandeSpelId heeft niet de lengte van een geldige UUID: " + bestaandeSpelId);
		final UUID bestaandeSpelIdAlsUUID = UUID.fromString(bestaandeSpelId);
		checkState(spelIdMoetGekendZijnInDatabank(bestaandeSpelIdAlsUUID));
		return new SpelId(bestaandeSpelId);
	}

	public SpelId nieuweSpelId() {
		return new SpelId();
	}

	private boolean spelIdMoetGekendZijnInDatabank(final UUID bestaandeSpelId) {
		return spelIdRepository.spelIdBestaat(bestaandeSpelId);
	}

}
