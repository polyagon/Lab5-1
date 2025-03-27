package org.example.Pokemons;

import org.example.Moves.Physic.AeralAce;
import org.example.Moves.Physic.DoubleHit;
import org.example.Moves.Special.TriAttack;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Silvally extends Pokemon {
    public Silvally(String name, int level){
        super(name, level);
        setType(Type.NORMAL);
        setStats(95, 95, 95, 95, 95, 95);
        setMove(new DoubleHit(), new AeralAce(), new TriAttack());
    }
}
