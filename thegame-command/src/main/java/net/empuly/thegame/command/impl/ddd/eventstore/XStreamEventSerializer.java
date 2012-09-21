package net.empuly.thegame.command.impl.ddd.eventstore;

import net.empuly.thegame.command.impl.ddd.event.Event;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;

@Component
public class XStreamEventSerializer implements EventSerializer {

	private final XStream xstream;

	public XStreamEventSerializer() {
		this.xstream = new XStream();
	}

	@Override
	public Event deserialize(final String serialized) {
		final Event result = (Event) this.xstream.fromXML(serialized);
		return result;
	}

	@Override
	public String serialize(final Event event) {
		final String result = this.xstream.toXML(event);
		return result;
	}

}
