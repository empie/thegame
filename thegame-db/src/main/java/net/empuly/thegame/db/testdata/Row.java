package net.empuly.thegame.db.testdata;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public abstract class Row extends Insertable {
	private final String tableName;

	public Row(final String tableName) {
		LokaleDatabank.valideerTable(tableName);
		this.tableName = tableName;
	}

	protected abstract Map<String, Object> getParams();

	protected String getTableName() {
		return tableName;
	}

	@Override
	protected void insertThis(DataSource datasource) {
		final Map<String, Object> params = getParams();
		new SimpleJdbcInsert(datasource)
				.withTableName(tableName)
				.usingColumns(params.keySet().toArray(new String[] {}))
				.execute(params);
	}

	protected <T> String rowValue(Class<T> clazz) {
		return clazz.getCanonicalName();
	}

	protected String rowValue(final Boolean flag) {
		return (flag != null) && flag ? "Y" : "N";
	}

	protected Date rowValue(final LocalDate date) {
		return date == null ? null : date.toDateMidnight().toDate();
	}

	protected Timestamp rowValue(final LocalDateTime dateTime) {
		return dateTime == null ? null : new Timestamp(dateTime.toDateTime().getMillis());
	}

	protected String rowValue(final UUID uuid) {
		return uuid.toString();
	}
}
