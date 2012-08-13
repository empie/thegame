package net.empuly.thegame.query.impl.domain;

import java.util.List;

import javax.inject.Inject;

import net.empuly.thegame.query.api.domain.ddd.SnapshotRepository;
import net.empuly.thegame.query.api.domain.spel.SpelId;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshot;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotFactory;
import net.empuly.thegame.query.api.domain.spel.SpelSnapshotRepository;
import net.empuly.thegame.query.api.domain.spel.SpelStatus;

import org.joda.time.LocalDateTime;

import com.google.common.collect.Lists;

@SnapshotRepository
public class SpelSnapshotRepositoryViaSql implements SpelSnapshotRepository {

	@Inject
	private SpelSnapshotFactory spelSnapshotFactory;

	@Override
	public List<SpelSnapshot> alleSpelen() {

		return Lists.newArrayList(dummySpelSnapshot());
	}

	private SpelSnapshot dummySpelSnapshot() {
		return spelSnapshotFactory.maakSpelSnapshot(new SpelId(), new LocalDateTime().minusDays(1), SpelStatus.GESTART);
	}

}
