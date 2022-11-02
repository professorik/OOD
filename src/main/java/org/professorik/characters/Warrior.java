package org.professorik.characters;

public class Warrior {
    static final int ATTACK = 5;
    private int health = 50;

    public int getAttack() {
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    private void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
    }

    protected void receiveDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
