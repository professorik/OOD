package org.professorik.characters;

import org.professorik.characters.interfaces.AbstractWarriorDecorator;
import org.professorik.characters.interfaces.CanPierce;
import org.professorik.characters.interfaces.CanReceiveDamage;
import org.professorik.characters.interfaces.HasWarriorBehind;

public class Lancer extends AbstractWarriorDecorator implements CanPierce {
    private final int PIERCING_POWER;

    public Lancer() {
        super(new Warrior(50, 6));
        this.PIERCING_POWER = 50;
    }

    public Lancer(IWarrior warrior, int piercingPower) {
        super(warrior);
        this.PIERCING_POWER = piercingPower;
    }

    @Override
    public int getPiercingPower() {
        return PIERCING_POWER;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int damageDealt = healthBefore - opponent.getHealth();
        int damageForTheNext = damageDealt * getPiercingPower() / 100;
        if (opponent instanceof HasWarriorBehind w) {
            var next = w.getWarriorBehind();
            if (next != null) {
                next.receiveDamage(damageForTheNext);
            }
        }
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d, get_piercing = %d}".
                formatted(getClass().getSimpleName(), getHealth(), getAttack(), getPiercingPower());
    }
}
