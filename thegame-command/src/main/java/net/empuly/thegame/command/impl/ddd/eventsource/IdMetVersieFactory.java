package net.empuly.thegame.command.impl.ddd.eventsource;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

public class IdMetVersieFactory {

	public IdMetVersie initieleVersieMetId(final UUID id) {
		return specifiekeVersieVanSpecifiekeId(id, IdMetVersie.INITIELE_VERSIE);
	}

	public IdMetVersie specifiekeVersieVanSpecifiekeId(final UUID id, final long version) {
		checkNotNull(id);
		checkArgument(version >= IdMetVersie.INITIELE_VERSIE, "Versie moet groter zijn dan initiele versie: " + IdMetVersie.INITIELE_VERSIE
				+ " maar was " + version);
		return new IdMetVersie(id, version);
	}

}
