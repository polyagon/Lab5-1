package org.example.Moves.Status;

import ru.ifmo.se.pokemon.*;

public class Recover extends StatusMove {
    public Recover(){
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if(p.getStat(Stat.HP)/2 > p.getHP()){
            p.setMod(Stat.HP, (int)-(p.getHP()/2));
        }

    }


    @Override
    protected String describe() {
        return "использует Recover";
    }
}
