package net.empuly.thegame.db.testdata;

import static com.google.common.base.Preconditions.checkState;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class LokaleDatabank {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource datasource;

	private static final List<String> TABLES = Arrays.asList(
			"SpelSnapshot",
			"Event",
			"EventSource"
			);

	public static void valideerTable(String table) {
		checkState(
				getTables().contains(table),
				table
						+ " has to be added to LokaleDatabank in order to clean this table automatically");
	}

	private static List<String> getTables() {
		return TABLES;
	}

	public void deleteAll() {
		for (final String table : getTables()) {
			deleteAllFromTable(table);
		}
	}

	private void deleteAllFromTable(final String table) {
		execute("DELETE FROM " + table);
	}

	private void execute(final String query) {
		this.jdbcTemplate.update(query, new HashMap<String, Object>());
	}
}
