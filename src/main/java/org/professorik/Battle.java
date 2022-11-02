package org.professorik;

import org.professorik.characters.Warrior;

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
        while (true) {
            var warrior1 = army1.peekFirst();
            if (warrior1 == null) return false;

            var warrior2 = army2.peekFirst();
            if (warrior2 == null) return true;

            if (fight(warrior1, warrior2))
                army2.removeFirst();
            else
                army1.removeFirst();
        }
    }
}
