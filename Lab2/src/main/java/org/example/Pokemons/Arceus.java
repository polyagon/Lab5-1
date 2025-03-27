package org.example.Pokemons;

import org.example.Moves.Physic.Waterfall;
import org.example.Moves.Special.FlashCannon;
import org.example.Moves.Special.HyperVoice;
import org.example.Moves.Status.Recover;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Arceus extends Pokemon {
    public Arceus(String name, int level){
        super(name, level);
        setType(Type.NORMAL);
        setStats(120, 120, 120, 120, 120, 120);
        setMove(new HyperVoice(), new FlashCannon(), new Waterfall(), new Recover());
    }
}
