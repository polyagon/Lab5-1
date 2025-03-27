package org.example.Moves.Physic;

import ru.ifmo.se.pokemon.*;

public class Crunch extends PhysicalMove {

    public Crunch(){
        super(Type.DARK, 80, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.2).stat(Stat.DEFENSE,  -1));
    }

    @Override
    protected String describe(){
        return "использован Crunch";
    }
}
