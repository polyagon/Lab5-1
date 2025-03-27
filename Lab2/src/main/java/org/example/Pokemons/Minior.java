package org.example.Pokemons;

import org.example.Moves.Physic.AeralAce;
import org.example.Moves.Physic.DoubleHit;
import org.example.Moves.Physic.ThunderFang;
import org.example.Moves.Special.TriAttack;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Minior extends Pokemon {
    public Minior(String name, int level){
        super(name, level);
        setType(Type.ROCK, Type.FLYING);
        setStats(60, 60, 100, 60, 100, 60);
        setMove(new DoubleHit(), new AeralAce(), new TriAttack(), new ThunderFang());
    }
}
