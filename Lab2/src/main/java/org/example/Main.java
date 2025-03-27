package org.example;

import org.example.Pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon fp1 = new Arceus("Ann", 10);
        Pokemon fp2 = new Minior("Lous", 7);
        Pokemon fp3 = new Silvally("David", 27);
        b.addAlly(fp1);
        b.addAlly(fp2);
        b.addAlly(fp3);
        Pokemon sp1 = new Grubbin("Alex", 10);
        Pokemon sp2 = new Charjabug("Elise", 27);
        Pokemon sp3 = new Vikavolt("Helga", 15);
        b.addFoe(sp1);
        b.addFoe(sp2);
        b.addFoe(sp3);
        b.go();

    }
}