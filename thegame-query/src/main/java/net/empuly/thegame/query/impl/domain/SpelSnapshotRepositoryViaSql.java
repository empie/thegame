package net.empuly.thegame.query.impl.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import net.empuly.thegame.query.api.domain.ddd.SnapshotRepository;
import net.empuly.thegame.query.api.domain.spel.SpelId;
import net.empuly.thegame.query.api.domain.spel.SpelIdFactory;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshot;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotFactory;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotRepository;
import net.empuly.thegame.query.api.domain.spel.SpelStatus;

import org.joda.time.LocalDateTime;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

@SnapshotRepository
public class SpelSnapshotRepositoryViaSql implements SpelSnapshotRepository {

	private class SpelSnapshotsRowMapper implements RowMapper<SpelSnapshot> {

		private static final String KOLOM_NAAM_STATUS = "status";
		private static final String KOLOM_NAAM_SPEL_ID = "spelId";
		private static final String KOLOM_NAAM_TIJDSTIP_AANGEMAAKT = "tijdstipAangemaakt";

		@Override
		public SpelSnapshot mapRow(final ResultSet rs, final int rowNum) throws SQLException {
			final String spelIdAlsString = rs.getString(KOLOM_NAAM_SPEL_ID);
			final Timestamp tijdstipAangemaakt = rs.getTimestamp(KOLOM_NAAM_TIJDSTIP_AANGEMAAKT);
			final int statusCode = rs.getInt(KOLOM_NAAM_STATUS);

			final SpelId bestaandeSpelId = spelIdFactory.bestaandeSpelIdVanString(spelIdAlsString);
			final LocalDateTime tijdstipAangemaaktAlsLocalDateTime = new LocalDateTime(tijdstipAangemaakt.getTime());
			final SpelStatus spelStatus = SpelStatus.fromCode(statusCode);

			final SpelSnapshot spelSnapshot = spelSnapshotFactory.maakSpelSnapshot(bestaandeSpelId, tijdstipAangemaaktAlsLocalDateTime, spelStatus);

			return spelSnapshot;
		}
	}

	private static final HashMap<String, Object> NO_PARAMETERS = new HashMap<String, Object>();

	@Inject
	private NamedParameterJdbcOperations jdbcTemplate;

	@Inject
	private SpelSnapshotFactory spelSnapshotFactory;

	@Inject
	private SpelIdFactory spelIdFactory;

	@Override
	public List<SpelSnapshot> alleSpelen() {
		final List<SpelSnapshot> spelSnapshots = jdbcTemplate.query("select * from spelsnapshot order by tijdstipAangemaakt desc", NO_PARAMETERS, new SpelSnapshotsRowMapper());
		return spelSnapshots;
	}

}
