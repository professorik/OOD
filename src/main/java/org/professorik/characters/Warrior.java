package org.professorik.characters;

public class Warrior {
    static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(50);
    }

    protected Warrior(int initHealth) {
        health = initHealth;
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
    }

    public int hit(Warrior opponent) {
        return opponent.receiveDamage(getAttack());
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
}
