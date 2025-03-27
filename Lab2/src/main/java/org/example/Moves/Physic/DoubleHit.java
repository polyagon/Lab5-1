package org.example.Moves.Physic;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleHit extends PhysicalMove {
    public DoubleHit(){
        super(Type.NORMAL, 35, 90, 1, 2);
    }

    @Override
    protected String describe(){
        return "использован Crunch";
    }


}
