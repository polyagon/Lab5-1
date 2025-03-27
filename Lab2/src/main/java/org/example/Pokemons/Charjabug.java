package org.example.Pokemons;

import org.example.Moves.Physic.Crunch;
import ru.ifmo.se.pokemon.Type;

public class Charjabug extends Grubbin{

    public Charjabug(String name, int level) {
        super(name, level);
        setType(Type.ELECTRIC);
        setStats(57, 82, 95, 55, 75, 36);
        setMove(new Crunch());
    }


}
