package org.professorik.characters;

public class Vampire extends Warrior {
    static final int ATTACK = 4;
    static final int VAMPIRISM = 50;

    public Vampire() {
        super(40);
    }

    private int getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public int hit(Warrior opponent) {
        var hit = super.hit(opponent);
        setHealth(getHealth() + hit * getVampirism() / 100);
        return hit;
    }

    @Override
    public int straightHit(Warrior opponent) {
        var hit = super.straightHit(opponent);
        setHealth(getHealth() + hit * getVampirism() / 100);
        return hit;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d, vampirism = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack(), getVampirism());
    }
}
