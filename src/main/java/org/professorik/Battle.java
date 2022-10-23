package org.professorik;

import org.professorik.characters.Warrior;

public class Battle {
    static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior2.getDamage(warrior1.getAttack());
            if (warrior2.isAlive()) {
                warrior1.getDamage(warrior2.getAttack());
            }
        }
        return warrior1.isAlive();
    }
}
