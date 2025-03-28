package org.example.Moves.Special;

import ru.ifmo.se.pokemon.*;

public class EnergyBall extends SpecialMove {
    public EnergyBall(){
        super(Type.GRASS, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE,  -1));
    }

    @Override
    protected String describe(){
        return "использован Energy Ball";
    }

}
