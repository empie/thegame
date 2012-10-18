package net.empuly.thegame.command.it;

import static org.fest.assertions.Assertions.assertThat;
import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersieBuilderForTests;
import net.empuly.thegame.command.impl.ddd.eventstore.EventStore;
import net.empuly.thegame.command.impl.ddd.eventstore.XStreamEventSerializer;
import net.empuly.thegame.db.testdata.TestDataInserter;
import net.empuly.thegame.query.testutils.IntegrationTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Category(IntegrationTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context-thegame-command.xml", "/context-thegame-app-test.xml" })
public class EventStoreViaSqlIntegrationTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Autowired
	private EventStore eventStore;

	@Autowired
	private TestDataInserter testDataInserter;

	@Autowired
	private XStreamEventSerializer xStreamEventSerializer;

	private EventSourceMetEventsOpzetter opzetter;

	@Test
	public void gegeven_EenEventSourceInDeDatabank_wanneer_bewaarEventSource_dan_NieuweEventsOokInDeDatabankEnRaadpleegbaar() {
		IdMetVersie idMetVersie = new IdMetVersieBuilderForTests().build();
		SomeEventSource someEventSource = new SomeEventSource(idMetVersie);
		someEventSource.pasToeEnOnthoud(new SomeEvent(idMetVersie));
		eventStore.bewaarEventSource(someEventSource);
		SomeEventSource geladenEventSource = this.eventStore.laadEventSourceViaId(SomeEventSource.class,idMetVersie.id());
		assertThat(geladenEventSource).isNotNull();
		assertThat(geladenEventSource.getEvents()).hasSize(1);
	}

	@Test
	public void gegeven_EenEventSourceInDeDatabank_wanneer_EventSourceGeladen_dan_EventSourceMetAlZijnEventsOpgehaaldUitDeDatabankMaarMetDeVersieEentjeHoger() {
		SomeEventSource geladenEventSource = this.eventStore.laadEventSourceViaId(SomeEventSource.class, this.opzetter.eventSourceRow()
				.getId());
		assertThat(geladenEventSource).isNotNull();
		IdMetVersie origineleIdMetVersieVanDeEvents = this.opzetter.idMetVersie();
		IdMetVersie verwachteIdMetVersieVoorHeleEventSource = origineleIdMetVersieVanDeEvents.volgendeVersie();
		assertThat(geladenEventSource.idMetVersie()).isEqualTo(verwachteIdMetVersieVoorHeleEventSource);
		assertThat(geladenEventSource.nogTePersisterenEvents()).isEmpty();
		assertThat(geladenEventSource.getEvents()).hasSize(2);
		Event eersteEvent = geladenEventSource.getEvents().get(0);
		Event tweedeEvent = geladenEventSource.getEvents().get(1);
		assertThat(eersteEvent).isInstanceOf(SomeEvent.class);
		assertThat(tweedeEvent).isInstanceOf(SomeEvent.class);
		assertThat(eersteEvent.eventVoorAggregateRootMetId()).isEqualTo(origineleIdMetVersieVanDeEvents);
		assertThat(tweedeEvent.eventVoorAggregateRootMetId()).isEqualTo(origineleIdMetVersieVanDeEvents);
	}

	@Before
	public void setUp() {
		this.opzetter = new EventSourceMetEventsOpzetter(this.xStreamEventSerializer);
		this.opzetter.setup();
		this.testDataInserter.with(this.opzetter.rowsOmTePersisteren()).clearAndInsert();
	}

}
