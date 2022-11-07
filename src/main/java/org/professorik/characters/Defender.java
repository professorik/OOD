package org.professorik.characters;

public class Defender extends Warrior {
    static final int ATTACK = 7;
    static final int DEFENCE = 2;

    @Override
    public int getAttack() {
        return ATTACK;
    }
}
