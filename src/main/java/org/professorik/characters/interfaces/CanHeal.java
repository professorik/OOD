package org.professorik.characters.interfaces;

public interface CanHeal {
    int getHealPower();
    default void heal(HasHealth warrior){
        if (warrior != null)
            warrior.healBy(getHealPower());
    }
}
