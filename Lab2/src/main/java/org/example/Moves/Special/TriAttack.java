package org.example.Moves.Special;

import ru.ifmo.se.pokemon.*;

public class TriAttack extends SpecialMove {
    public TriAttack(){
        super(Type.NORMAL, 80, 100);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.667).condition(Status.BURN));
        p.addEffect(new Effect().chance(0.667).condition(Status.PARALYZE));
        p.addEffect(new Effect().chance(0.667).condition(Status.FREEZE));

    }

    @Override
    protected String describe(){
        return "использован Tri Attack";
    }

}
