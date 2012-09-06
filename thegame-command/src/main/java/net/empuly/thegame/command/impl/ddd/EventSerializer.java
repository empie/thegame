package net.empuly.thegame.command.impl.ddd;

public interface EventSerializer {

    Object serialize(Event event);
    
    Event deserialize(Object serialized);
    
}