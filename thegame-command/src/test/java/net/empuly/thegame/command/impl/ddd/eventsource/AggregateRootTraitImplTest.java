package net.empuly.thegame.command.impl.ddd.eventsource;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.query.testutils.MockitoRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import com.google.common.collect.Lists;

public class AggregateRootTraitImplTest {

	private static final IdMetVersie ID_MET_VERSIE = new IdMetVersieBuilderForTests().build();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	@Rule
	public MockitoRule mockitoRule = new MockitoRule(this);

	@Mock
	private Event eventMock1;
	@Mock
	private Event eventMock2;

	private SomeAggregateRoot someAggregateRoot;

	private class SomeAggregateRoot extends AggregateRootTraitImpl {

		private final List<Event> toegepasteEvents = new ArrayList<Event>();

		public SomeAggregateRoot(IdMetVersie id) {
			super(id);
		}

		@Override
		protected void pasToe(Event event) {
			this.toegepasteEvents.add(event);
		}

		boolean eventToegepast(Event... eventsDieMoetToegepastZijn) {
			return toegepasteEvents.containsAll(Arrays.asList(eventsDieMoetToegepastZijn));
		}

	}

	@Before
	public void setUp() {
		someAggregateRoot = new SomeAggregateRoot(ID_MET_VERSIE);
	}

	@Test
	public void aggregateRootTraitKanEnkelGemaaktWordenMetIdMetVersieVerschillendVanNull() {
		expectedException.expect(NullPointerException.class);
		new SomeAggregateRoot(null);
	}

	@Test
	public void aanmakenVanAggregateRootTraitInitialiseertLijstVanNogTePersisterenEventsOpLegeLijst() {
		assertThat(someAggregateRoot.idMetVersie()).isEqualTo(ID_MET_VERSIE);
		assertThat(someAggregateRoot.nogTePersisterenEvents()).isNotNull();
		assertThat(someAggregateRoot.nogTePersisterenEvents()).isEmpty();
	}

	@Test
	public void nogTePersisterenEventsLektEenLijstDieNietAangepastKanWorden() throws Exception {
		List<Event> nogTePersisterenEvents = someAggregateRoot.nogTePersisterenEvents();
		expectedException.expect(UnsupportedOperationException.class);
		nogTePersisterenEvents.add(null);
	}

	@Test
	public void pasToeEnOnthoudKanEnkelWordenOpgeroepenMetEventVerschillendVanNull() {
		expectedException.expect(NullPointerException.class);
		someAggregateRoot.pasToeEnOnthoud(null);
	}

	@Test
	public void reconstrueerKanEnkelWordenOpgeroepenMetEventLijstVerschillendVanNull() {
		expectedException.expect(NullPointerException.class);
		someAggregateRoot.reconstrueer(null);
	}

	@Test
	public void reconstrueerKanEnkelWordenOpgeroepenMetEventLijstZonderNullElementen() {
		ArrayList<Event> eventList = new ArrayList<Event>();
		eventList.add(null);
		expectedException.expect(NullPointerException.class);
		someAggregateRoot.reconstrueer(eventList);
	}

	@Test
	public void reconstrueerPastAlleEventsInDeEventLijstToeZonderZeTeOnthouden() {
		List<Event> eventList = Lists.newArrayList(eventMock1, eventMock2);
		someAggregateRoot.reconstrueer(eventList);
		assertThat(someAggregateRoot.nogTePersisterenEvents()).isEmpty();
		assertThat(someAggregateRoot.eventToegepast(eventMock1, eventMock2));
	}

	@Test
	public void pasToeEnOnthoudDoetControlesOpEventPastZeToeOpAggregateRootEnOnthoudEventOmTePersisteren() throws Exception {
		someAggregateRoot.pasToeEnOnthoud(eventMock1);
		assertThat(someAggregateRoot.nogTePersisterenEvents()).containsExactly(eventMock1);
		assertThat(someAggregateRoot.eventToegepast(eventMock1)).isTrue();
	}

	@Test
	public void markeerAlleNogTePersisterenEventsAlsGepersisteerdMaaktLijstLeeg() {
		someAggregateRoot.pasToe(eventMock1);
		someAggregateRoot.markeerAlleNogTePersisterenEventsAlsGepersisteerd();
		assertThat(someAggregateRoot.nogTePersisterenEvents()).isEmpty();
	}
}
