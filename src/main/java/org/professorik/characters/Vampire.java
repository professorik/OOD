package org.professorik.characters;

import org.professorik.characters.interfaces.AbstractWarriorDecorator;
import org.professorik.characters.interfaces.CanReceiveDamage;
import org.professorik.characters.interfaces.HasVampirism;

public class Vampire extends AbstractWarriorDecorator implements HasVampirism {
    private final int VAMPIRISM;

    public Vampire() {
        super(new Warrior(40, 4));
        this.VAMPIRISM = 50;
    }

    public Vampire(IWarrior warrior, int vampirism) {
        super(warrior);
        VAMPIRISM = vampirism;
    }

    @Override
    public int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public void hit(CanReceiveDamage w) {
        var healthBefore = w.getHealth();
        super.hit(w);
        var dealtDamage = healthBefore - w.getHealth();
        var selfHealing = dealtDamage * getVampirism() / 100;
        healBy(selfHealing);
    }

    @Override
    public void straightHit(CanReceiveDamage w) {
        var healthBefore = w.getHealth();
        super.straightHit(w);
        var dealtDamage = healthBefore - w.getHealth();
        var selfHealing = dealtDamage * getVampirism() / 100;
        healBy(selfHealing);
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d, vampirism = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack(), getVampirism());
    }
}
