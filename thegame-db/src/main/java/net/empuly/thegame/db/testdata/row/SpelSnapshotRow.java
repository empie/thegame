package net.empuly.thegame.db.testdata.row;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.empuly.thegame.db.testdata.RowWithId;

import org.joda.time.LocalDateTime;

import com.google.common.collect.Maps;

public class SpelSnapshotRow extends RowWithId<UUID> {

	public static final String KOLOM_NAAM_TIJDSTIP_AANGEMAAKT = "tijdstipAangemaakt";
	public static final String KOLOM_NAAM_SPEL_STATUS = "status";
	public static final String KOLOM_NAAM_SPEL_ID = "spelId";
	private static final int DEFAULT_STATUS_CODE = 1;

	public static SpelSnapshotRow spelSnapshotMet() {
		return new SpelSnapshotRow();
	}

	private LocalDateTime tijdstipAangemaakt;
	private int statusCode;

	private SpelSnapshotRow() {
		super("SpelSnapshot");
	}

	public SpelSnapshotRow allesIngevuld() {
		randomSpelId();
		tijdstipAangemaaktInHetVerleden();
		statusCode(DEFAULT_STATUS_CODE);
		return this;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public LocalDateTime getTijdstipAangemaakt() {
		return tijdstipAangemaakt;
	}

	public SpelSnapshotRow randomSpelId() {
		withId(UUID.randomUUID());
		return this;
	}

	public SpelSnapshotRow statusCode(final int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public SpelSnapshotRow tijdstipAangemaakt(final LocalDateTime tijdstipAangemaakt) {
		this.tijdstipAangemaakt = tijdstipAangemaakt;
		return this;
	}

	public SpelSnapshotRow tijdstipAangemaaktInHetVerleden() {
		this.tijdstipAangemaakt = new LocalDateTime().minusDays(10);
		return this;
	}

	@Override
	protected Map<String, Object> getParams() {
		final HashMap<String, Object> parameterMap = Maps.newHashMap();
		parameterMap.put(KOLOM_NAAM_SPEL_ID, rowValue(getId()));
		parameterMap.put(KOLOM_NAAM_TIJDSTIP_AANGEMAAKT, rowValue(tijdstipAangemaakt));
		parameterMap.put(KOLOM_NAAM_SPEL_STATUS, statusCode);
		return parameterMap;
	}

}
