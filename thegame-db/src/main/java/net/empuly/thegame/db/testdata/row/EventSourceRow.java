package net.empuly.thegame.db.testdata.row;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.empuly.thegame.db.testdata.RowWithId;

import com.google.common.collect.Maps;

public class EventSourceRow extends RowWithId<UUID> {

	private static final String KOLOM_EVENT_SOURCE_VOLGEND_VRIJ_EVENT_VOLGNUMMER = "volgendVrijEventVolgnummer";
	private static final String KOLOM_EVENT_SOURCE_VERSIE = "versie";
	private static final String KOLOM_EVENT_SOURCE_TYPE = "eventSourceType";
	private static final String KOLOM_EVENT_SOURCE_ID = "eventSourceId";

	public static EventSourceRow eventSourceRowMet() {
		return new EventSourceRow();
	}

	private Class<?> eventSourceType;
	private long versie;
	private int aantalEvents;

	private EventSourceRow() {
		super("EventSource");
	}

	public EventSourceRow allesIngevuld(Class<?> typeVanDeEventSource, int aantalEvents) {
		metRandomEventSourceId();
		metEersteVersie();
		metTypeVanDeEventSource(typeVanDeEventSource);
		metAantalEventsZodatVolgendVrijEventVolgnummerKanIngevuldWorden(aantalEvents);
		return this;
	}

	public long getVersie() {
		return this.versie;
	}

	public EventSourceRow metAantalEventsZodatVolgendVrijEventVolgnummerKanIngevuldWorden(int aantalEvents) {
		this.aantalEvents = aantalEvents;
		return this;
	}

	public EventSourceRow metEersteVersie() {
		int versie = 0;
		return metVersie(versie);
	}

	public EventSourceRow metRandomEventSourceId() {
		withId(UUID.randomUUID());
		return this;
	}

	public EventSourceRow metVersie(int versie) {
		this.versie = versie;
		return this;
	}

	private EventSourceRow metTypeVanDeEventSource(Class<?> typeVanDeEventSource) {
		this.eventSourceType = typeVanDeEventSource;
		return this;
	}

	@Override
	protected Map<String, Object> getParams() {
		final HashMap<String, Object> parameterMap = Maps.newHashMap();
		parameterMap.put(KOLOM_EVENT_SOURCE_ID, rowValue(getId()));
		parameterMap.put(KOLOM_EVENT_SOURCE_TYPE, rowValue(this.eventSourceType));
		parameterMap.put(KOLOM_EVENT_SOURCE_VERSIE, this.versie);
		parameterMap.put(KOLOM_EVENT_SOURCE_VOLGEND_VRIJ_EVENT_VOLGNUMMER, this.aantalEvents);
		return parameterMap;
	}
}
