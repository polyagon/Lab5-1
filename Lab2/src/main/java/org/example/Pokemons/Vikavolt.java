package org.example.Pokemons;

import org.example.Moves.Special.EnergyBall;

public class Vikavolt extends Charjabug{

    public Vikavolt(String name, int level) {
        super(name, level);
        setStats(77, 70, 90, 145, 75, 43);
        setMove(new EnergyBall());
    }
}
