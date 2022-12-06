package org.professorik.characters;

import org.professorik.characters.interfaces.*;

public class Healer extends AbstractWarriorDecorator implements CanHeal {
    private final int HEAL_POWER;

    public Healer() {
        super(new Warrior(60, 0));
        this.HEAL_POWER = 2;
    }

    public Healer(IWarrior warrior, int healPower) {
        super(warrior);
        this.HEAL_POWER = healPower;
    }

    @Override
    public void processCommand(Command command, CanProcessCommand sender) {
        if (command instanceof OurChampionHasHit && sender instanceof HasHealth s) {
            heal(s);
        }
        super.processCommand(command, sender);
    }

    @Override
    public int getHealPower() {
        return HEAL_POWER;
    }

    @Override
    public void heal(HasHealth warrior) {
        warrior.healBy(getHealPower());
    }

    @Override
    public String toString() {
        return "%s {health = %d, attack = %d, heal = %d}"
                .formatted(getClass().getSimpleName(), getHealth(), getAttack(), getHealPower());
    }
}
