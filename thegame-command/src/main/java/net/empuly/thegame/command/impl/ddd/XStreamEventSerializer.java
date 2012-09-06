package net.empuly.thegame.command.impl.ddd;

import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;

@Component
public class XStreamEventSerializer implements EventSerializer {

	private final XStream xstream;

	public XStreamEventSerializer() {
		xstream = new XStream();
	}

	@Override
	public Event deserialize(final Object serialized) {
		final Event result = (Event) xstream.fromXML((String) serialized);
		return result;
	}

	@Override
	public Object serialize(final Event event) {
		final String result = xstream.toXML(event);
		return result;
	}

}
