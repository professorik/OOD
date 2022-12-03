package org.professorik.characters;

import org.professorik.characters.interfaces.Command;
import org.professorik.characters.interfaces.OurChampionHasHit;

public class Warrior {
    static final int ATTACK = 5;
    private int health;
    private final int initialHealth;
    private Warrior nextBehind;

    public Warrior() {
        this(50);
    }

    protected Warrior(int initHealth) {
        health = initialHealth = initHealth;
    }

    public int getAttack() {
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    protected void setHealth(int health) {
        this.health = Math.max(0, health);
        this.health = Math.min(this.health, initialHealth);
    }

    protected void healBy(int healthPoints) {
        setHealth(getHealth() + healthPoints);
    }

    public int hit(Warrior opponent) {
        var damage = opponent.receiveDamage(getAttack());
        processCommand(OurChampionHasHit.INSTANCE, null);
        return damage;
    }

    protected int receiveDamage(int damage) {
        setHealth(getHealth() - damage);
        return damage;
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack());
    }

    protected void processCommand(Command command, Warrior sender) {
        var next = getWarriorBehind();
        if (next != null) {
            next.processCommand(command, this);
        }
    }

    protected Warrior getWarriorBehind() {
        return nextBehind;
    }

    public void setNextBehind(Warrior nextBehind) {
        this.nextBehind = nextBehind;
    }
}
