package org.professorik.characters;

import org.professorik.characters.interfaces.*;

public interface IWarrior extends CanReceiveDamage, CanAttack, HasHealth, CanProcessCommand {
    static IWarrior newWarrior() {
        return new Warrior(50, 5);
    }
    static IWarrior newKnight() {
        return new Warrior(50, 7);
    }
    static IWarrior newRookie() {
        return new Warrior(50, 1);
    }
    static IWarrior newHealer() {
        return new Healer(new Warrior(60, 0), 2);
    }
    static IWarrior newDefender() {
        return new Defender(new Warrior(60, 3), 2);
    }
    static IWarrior newVampire() {
        return new Vampire(new Warrior(40, 4), 50);
    }
    static IWarrior newLancer() {
        return new Lancer(new Warrior(50, 6), 50);
    }
    static IWarrior newVampireDefender() {
        return new Vampire(newDefender(), 50);
    }
}
