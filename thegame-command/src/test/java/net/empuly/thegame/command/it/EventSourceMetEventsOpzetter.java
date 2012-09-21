package net.empuly.thegame.command.it;

import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersie;
import net.empuly.thegame.command.impl.ddd.eventsource.IdMetVersieBuilderForTests;
import net.empuly.thegame.command.impl.ddd.eventstore.XStreamEventSerializer;
import net.empuly.thegame.db.testdata.Row;
import net.empuly.thegame.db.testdata.row.EventRow;
import net.empuly.thegame.db.testdata.row.EventSourceRow;

import com.google.common.collect.Lists;

public class EventSourceMetEventsOpzetter {

	private final XStreamEventSerializer xStreamEventSerializer;

	private EventSourceRow eventSourceRow;

	private EventRow eventRow1;

	private EventRow eventRow2;

	private IdMetVersie idMetVersie;

	public EventSourceMetEventsOpzetter(XStreamEventSerializer xStreamEventSerializer) {
		this.xStreamEventSerializer = xStreamEventSerializer;
	}

	public EventSourceRow eventSourceRow() {
		return this.eventSourceRow;
	}

	public IdMetVersie idMetVersie() {
		return this.idMetVersie;
	}

	public Row[] rowsOmTePersisteren() {
		Row[] row = new Row[3];
		return Lists.newArrayList(this.eventSourceRow, this.eventRow1, this.eventRow2).toArray(row);
	}

	public void setup() {
		this.eventSourceRow = EventSourceRow.eventSourceRowMet().allesIngevuld(SomeEventSource.class, 2);
		this.idMetVersie = new IdMetVersieBuilderForTests().withId(this.eventSourceRow.getId())
				.withVersie(this.eventSourceRow.getVersie()).build();
		String serializedEvent1 = this.xStreamEventSerializer.serialize(new SomeEvent(this.idMetVersie));
		String serializedEvent2 = this.xStreamEventSerializer.serialize(new SomeEvent(this.idMetVersie));
		this.eventRow1 = EventRow.eventRowMet().allesIngevuld(this.eventSourceRow, 0, serializedEvent1);
		this.eventRow2 = EventRow.eventRowMet().allesIngevuld(this.eventSourceRow, 1, serializedEvent2);
	}

}
