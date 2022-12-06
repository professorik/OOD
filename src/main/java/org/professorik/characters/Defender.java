package org.professorik.characters;

import org.professorik.characters.interfaces.AbstractWarriorDecorator;
import org.professorik.characters.interfaces.HasDefence;

public class Defender extends AbstractWarriorDecorator implements HasDefence {
    private final int DEFENCE;

    public Defender() {
        super(new Warrior(60, 3));
        this.DEFENCE = 2;
    }

    public Defender(IWarrior warrior, int defence) {
        super(warrior);
        this.DEFENCE = defence;
    }

    @Override
    public int getDefence() {
        return DEFENCE;
    }

    @Override
    public int receiveDamage(int damage) {
        var dmg = Math.max(0, damage - getDefence());
        super.receiveDamage(dmg);
        return dmg;
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d, defence = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack(), getDefence());
    }
}
