package org.example.Pokemons;

import  org.example.Moves.Physic.Spark;
import org.example.Moves.Status.Confide;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Grubbin extends Pokemon {
    public Grubbin(String name, int level){
        super(name, level);
        setType(Type.BUG);
        setStats(47, 62, 45, 55, 45, 46);
        setMove(new Spark(), new Confide());
    }
}
