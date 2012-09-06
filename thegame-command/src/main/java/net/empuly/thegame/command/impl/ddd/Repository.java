package net.empuly.thegame.command.impl.ddd;

import java.util.UUID;


public interface Repository <T extends AggregateRootTrait> {

     T haalLaatsteVersieOpViaId(UUID id);
    
     T haalOpViaIdMetVersie(IdMetVersie idMetVersie);
    
     void bewaar(T aggregateRoot);
    
}
