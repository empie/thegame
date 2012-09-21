package net.empuly.thegame.command.impl.ddd.eventsource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.empuly.thegame.command.impl.ddd.event.Event;
import net.empuly.thegame.command.impl.ddd.eventstore.JdbcEventSourceRij;

//TODO jozef: euhm, hoe schrijft ge hier nen test voor?
public class EventSourceFactory<T extends EventSource<? extends Event>> {
	public T maakEventSource(final Class<T> verwachtEventSourceType, final JdbcEventSourceRij eventSourceRij, final List<Event> events) {
		try {
			final IdMetVersie idVoorVolgendeVersie = new IdMetVersieFactory().specifiekeVersieVanSpecifiekeId(
					eventSourceRij.eventSourceId(), eventSourceRij.versie()).volgendeVersie();

			final Constructor<T> constructor = verwachtEventSourceType.getConstructor(IdMetVersie.class);
			final T eventSource = constructor.newInstance(idVoorVolgendeVersie);
			eventSource.reconstrueer(events);
			return eventSource;
		} catch (final InstantiationException e) {
			throw new RuntimeException(e);
		} catch (final IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (final SecurityException e) {
			throw new RuntimeException(e);
		} catch (final NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (final IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (final InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
