package org.professorik.characters;

public class Lancer extends Warrior {

    private static final int PIERCING_POWER = 50;

    @Override
    public int getAttack() {
        return 6;
    }

    private int getPiercingPower() {
        return PIERCING_POWER;
    }

    @Override
    public int hit(Warrior opponent) {
        int healthBefore = opponent.getHealth();
        super.hit(opponent);
        int damageDealt = healthBefore - opponent.getHealth();
        int damageForTheNext = damageDealt * getPiercingPower() / 100;
        Warrior next = opponent.getWarriorBehind();
        if (next != null) {
            next.receiveDamage(damageForTheNext);
        }
        return 0;
    }
}
