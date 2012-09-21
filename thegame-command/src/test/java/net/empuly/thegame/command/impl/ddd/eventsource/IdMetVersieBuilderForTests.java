package net.empuly.thegame.command.impl.ddd.eventsource;

import java.util.UUID;

public class IdMetVersieBuilderForTests {

	public static final UUID DEFAULT_UUID = java.util.UUID.randomUUID();
	public static final long DEFAULT_VERSIE = IdMetVersie.INITIELE_VERSIE;
	private long versie = DEFAULT_VERSIE;
	private UUID uuid = DEFAULT_UUID;

	public IdMetVersie build() {
		return new IdMetVersie(uuid, versie);
	}

	public IdMetVersieBuilderForTests withId(UUID uuid) {
		this.uuid = uuid;
		return this;
	}

	public IdMetVersieBuilderForTests withVersie(long versie) {
		this.versie = versie;
		return this;
	}

}
