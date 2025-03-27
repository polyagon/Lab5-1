package org.example.Moves.Special;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class HyperVoice extends SpecialMove {
    public HyperVoice(){
        super(Type.NORMAL, 90, 100);
    }

    @Override
    protected String describe() {
        return "использует HyperVoice";
    }

}
