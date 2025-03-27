package org.example.Moves.Special;

import ru.ifmo.se.pokemon.*;

public class FlashCannon extends SpecialMove {
    public FlashCannon(){
        super(Type.STEEL, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.2).stat(Stat.SPECIAL_DEFENSE,  -1));
    }

    @Override
    protected String describe() {
        return "использует Flash Cannon";
    }
}
