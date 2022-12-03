package org.professorik.characters;

import org.professorik.characters.interfaces.Command;
import org.professorik.characters.interfaces.OurChampionHasHit;

public class Healer extends Warrior {
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(60);
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    protected void processCommand(Command command, Warrior sender) {
        if (command instanceof OurChampionHasHit) {
            heal(sender);
        }
        super.processCommand(command, sender);
    }

    public int getHealPower() {
        return HEAL_POWER;
    }

    public void heal(Warrior warrior) {
        if (warrior != null)
            warrior.healBy(getHealPower());
    }
}
