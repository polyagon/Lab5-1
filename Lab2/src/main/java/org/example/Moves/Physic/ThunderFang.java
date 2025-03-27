package org.example.Moves.Physic;

import ru.ifmo.se.pokemon.*;

public class ThunderFang extends PhysicalMove {
    public ThunderFang(){
        super(Type.ELECTRIC, 65, 95);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.1).condition(Status.PARALYZE));
        if(Math.random() <= 0.1){
            Effect.flinch(p);
        }

    }

    @Override
    protected String describe(){
        return "использован Thunder Fang";
    }
}
