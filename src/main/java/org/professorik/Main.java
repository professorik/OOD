package org.professorik;

import org.professorik.characters.Knight;
import org.professorik.characters.Warrior;

public class Main {
    public static void main(String[] args) {
        var army = new Army()
                .addUnits(Warrior::new, 1)
                .addUnits(Knight::new, 10)
                .addUnits(Warrior::new, 2);
    }
}
