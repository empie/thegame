package net.empuly.thegame.db.testdata.row;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import net.empuly.thegame.db.testdata.ForeignKey;
import net.empuly.thegame.db.testdata.Row;

import org.joda.time.LocalDateTime;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.google.common.collect.Maps;

public class EventRow extends Row {

	private static final String EVENT_DATA_CONSTANTE = "EVENT_DATA_CONSTANTE";
	private static final LocalDateTime REFERENTIE_DATUM = new LocalDateTime(2012, 8, 31, 0, 0);
	private static final String KOLOM_EVENT_DATA = "data";
	private static final String KOLOM_EVENT_TIJDSTIP_TOEVOEGING = "tijdstipToevoeging";
	private static final String KOLOM_EVENT_VOLGNUMMER = "eventVolgnummer";
	private static final String KOLOM_EVENT_SOURCE_ID = "eventSourceId";

	public static EventRow eventRowMet() {
		return new EventRow();
	}

	private String data;
	private LocalDateTime tijdstipToevoeging;
	private int eventVolgnummer;

	private ForeignKey<UUID, EventSourceRow> eventSource;

	private EventRow() {
		super("Event");
	}

	public EventRow allesIngevuld(EventSourceRow eventSourceRow, int volgnummer, String data) {
		metVolgnummer(volgnummer);
		metRandomTijdstipToevoeging();
		metData(data);
		metEventSource(eventSourceRow);
		return this;
	}

	public int eventVolgnummer() {
		return this.eventVolgnummer;
	}

	public EventRow metVolgnummer(int volgnummer) {
		this.eventVolgnummer = volgnummer;
		return this;
	}

	public LocalDateTime tijdstipToevoeging() {
		return this.tijdstipToevoeging;
	}

	public EventRow tijdstipToevoegingInHetVerleden() {
		this.tijdstipToevoeging = new LocalDateTime().minusDays(10);
		return this;
	}

	private EventRow metAltijdDezelfd1eData() {
		this.data = EVENT_DATA_CONSTANTE;
		return this;
	}

	private void metData(String data) {
		this.data = data;
	}

	private EventRow metEventSource(EventSourceRow eventSourceRow) {
		this.eventSource = ForeignKey.foreignKey(eventSourceRow);
		return this;
	}

	private EventRow metRandomTijdstipToevoeging() {
		this.tijdstipToevoeging = new LocalDateTime().minusDays(5);
		return this;
	}

	private void metVolgnummerDatZekerVanachterInDeRijKomt() {
		long aantalMilisOpVandaag = new LocalDateTime().toDate().getTime();
		long aantalMilisOpReferentieDatum = REFERENTIE_DATUM.toDate().getTime();
		this.eventVolgnummer = (int) (aantalMilisOpVandaag - aantalMilisOpReferentieDatum);
	}

	@Override
	protected Map<String, Object> getParams() {
		final HashMap<String, Object> parameterMap = Maps.newHashMap();
		parameterMap.put(KOLOM_EVENT_VOLGNUMMER, this.eventVolgnummer);
		parameterMap.put(KOLOM_EVENT_TIJDSTIP_TOEVOEGING, rowValue(this.tijdstipToevoeging));
		parameterMap.put(KOLOM_EVENT_DATA, this.data);
		return parameterMap;
	}

	@Override
	protected void insertThis(DataSource datasource) {
		final Map<String, Object> params = getParams();
		UUID eventSourceId = this.eventSource.insertAndGetId(datasource);
		params.put(KOLOM_EVENT_SOURCE_ID, rowValue(eventSourceId));
		new SimpleJdbcInsert(datasource)
				.withTableName(this.getTableName())
				.usingColumns(params.keySet().toArray(new String[] {}))
				.execute(params);
	}
}
