package org.professorik;

import org.professorik.characters.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.hit(warrior2);
            if (warrior2.isAlive()) {
                warrior2.hit(warrior1);
            }
        }
        return warrior1.isAlive();
    }

    public static boolean fight(Army army1, Army army2) {
        var it1 = army1.firstAliveIterator();
        var it2 = army2.firstAliveIterator();

        while (it1.hasNext() && it2.hasNext()) {
            fight(it1.next(), it2.next());
        }

        return it1.hasNext();
    }

    public static boolean straightFight(Army army1, Army army2) {
        Iterable<Pair> zipped;
        do {
            zipped = zip(army1, army2);
            zipped.forEach(pair -> fightStraight(pair.first, pair.second));
         } while (zipped.iterator().hasNext());

        return army1.firstAliveIterator().hasNext();
    }

    private static void fightStraight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.straightHit(warrior2);
            if (warrior2.isAlive()) {
                warrior2.straightHit(warrior1);
            }
        }
    }

    private record Pair(Warrior first, Warrior second){}

    private static Iterable<Pair> zip(Army army1, Army army2) {
        List<Warrior> fighters1 = army1.getLiving();
        List<Warrior> fighters2 = army2.getLiving();
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < Math.min(fighters1.size(), fighters2.size()); i++) {
            res.add(new Pair(fighters1.get(i), fighters2.get(i)));
        }
        return res;
    }
}
