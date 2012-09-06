package net.empuly.thegame.command.impl.ddd;

/**
 * Sink for change events. Every event stream has its own sequence of events
 * that are stored by the {@link JdbcEventStore}. When loading events the event
 * stream meta data and events are send to this {@link EventSink}.
 */
public interface EventSink<EventType> {

    void setType(String type);

    void setVersion(long version);

    void setTimestamp(long timestamp);

    void setEvents(Iterable<? extends EventType> events);

}
