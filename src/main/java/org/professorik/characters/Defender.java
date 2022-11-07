package org.professorik.characters;

public class Defender extends Warrior {
    static final int ATTACK = 3;
    static final int DEFENCE = 2;

    public Defender() {
        super(60);
    }

    public int getDefence() {
        return DEFENCE;
    }

    @Override
    protected int receiveDamage(int damage) {
        var dmg = Math.max(0, damage - getDefence());
        super.receiveDamage(dmg);
        return dmg;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
