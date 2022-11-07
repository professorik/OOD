package org.professorik.characters;

public class Vampire extends Warrior {
    static final int ATTACK = 4;
    static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    private double getVampirism() {
        return VAMPIRISM / 100d;
    }

    @Override
    public int hit(Warrior opponent) {
        var hit = super.hit(opponent);
        setHealth(getHealth() + (int) (hit * getVampirism()));
        return hit;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
