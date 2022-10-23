package org.professorik.characters;

public class Warrior {
    static final int ATTACK = 5;
    private int health = 50;

    public int getAttack() {
        return ATTACK;
    }

    public void getDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }
}
