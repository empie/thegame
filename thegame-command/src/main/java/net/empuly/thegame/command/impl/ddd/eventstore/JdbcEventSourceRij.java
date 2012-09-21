package net.empuly.thegame.command.impl.ddd.eventstore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

import net.empuly.thegame.command.impl.ddd.eventsource.EventSource;

public class JdbcEventSourceRij {

	private static final int START_VOLGEND_SEQUENCE_NUMMER = 0;
	private static final int INITIELE_VERSIE = 0;

	public static JdbcEventSourceRij rijVoorEventSource(final UUID id, final Class<?> typeVanHetEvent, final long versie,
			final long volgendEventSequenceNummer) {
		return new JdbcEventSourceRij(id, typeVanHetEvent, versie, volgendEventSequenceNummer);
	}

	public static JdbcEventSourceRij rijVoorNieuweEventSource(final UUID id, final Class<?> typeVanHetEvent) {
		return new JdbcEventSourceRij(id, typeVanHetEvent, INITIELE_VERSIE, START_VOLGEND_SEQUENCE_NUMMER);
	}

	private final UUID id;
	private final Class<?> typeVanDeEventSource;

	private final long versie;

	private long volgendEventSequenceNummer;

	private JdbcEventSourceRij(final UUID id, final Class<?> typeVanDeEventSource, final long versie, final long volgendEventSequenceNummer) {
		checkNotNull(id);
		checkNotNull(typeVanDeEventSource);
		checkArgument(EventSource.class.isAssignableFrom(typeVanDeEventSource));
		checkArgument(versie >= 0);
		checkArgument(volgendEventSequenceNummer >= 0);
		this.id = id;
		this.typeVanDeEventSource = typeVanDeEventSource;
		this.versie = versie;
		this.volgendEventSequenceNummer = volgendEventSequenceNummer;
	}

	public UUID eventSourceId() {
		return this.id;
	}

	public Class<?> typeVanDeEventSource() {
		return this.typeVanDeEventSource;
	}

	public long versie() {
		return this.versie;
	}

	public long volgendEventSequenceNummer() {
		return this.volgendEventSequenceNummer;
	}

	public long volgendEventSequenceNummerEnZetEentjeVerder() {
		return this.volgendEventSequenceNummer++;
	}

}
