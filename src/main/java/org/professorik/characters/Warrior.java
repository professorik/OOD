package org.professorik.characters;

import org.professorik.characters.interfaces.CanReceiveDamage;
import org.professorik.characters.interfaces.OurChampionHasHit;

public class Warrior implements IWarrior {
    private int health;
    private final int ATTACK;
    private final int initialHealth;
    private IWarrior nextBehind;

    public Warrior() {
        this.health = initialHealth = 50;
        this.ATTACK = 5;
    }

    public Warrior(int health, int attack) {
        this.health = initialHealth = health;
        this.ATTACK = attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.max(0, health);
        this.health = Math.min(this.health, initialHealth);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public int receiveDamage(int damage) {
        setHealth(health - damage);
        return damage;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(getAttack());
        processCommand(OurChampionHasHit.INSTANCE, null);
    }

    @Override
    public IWarrior getWarriorBehind() {
        return nextBehind;
    }

    public void setNextBehind(IWarrior nextBehind) {
        this.nextBehind = nextBehind;
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack());
    }
}
