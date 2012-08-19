package net.empuly.thegame.query.impl.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.UUID;

import javax.inject.Inject;

import net.empuly.thegame.query.api.domain.ddd.SnapshotRepository;
import net.empuly.thegame.query.api.domain.spel.SpelIdRepository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

@SnapshotRepository
public class SpelIdRepositoryViaSql implements SpelIdRepository {

	@Inject
	private NamedParameterJdbcOperations jdbcTemplate;

	@Override
	public boolean spelIdBestaat(final UUID uuidVanSpelIdDieMoetBestaan) {
		checkNotNull(uuidVanSpelIdDieMoetBestaan);
		return aantalResultatenMetSpelIdGelijkAan(uuidVanSpelIdDieMoetBestaan) == 1;
	}

	private int aantalResultatenMetSpelIdGelijkAan(final UUID uuidVanSpelIdDieMoetBestaan) {
		final SqlParameterSource namedParameters = new MapSqlParameterSource("spelId", uuidVanSpelIdDieMoetBestaan.toString());
		final int aantalResultaten = jdbcTemplate.queryForInt("select count(*) from spelSnapshot where spelId=:spelId;", namedParameters);
		return aantalResultaten;
	}

}
