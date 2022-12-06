package org.professorik.characters.interfaces;

public interface HasHealth {
    int getHealth();
    void setHealth(int health);
    default void healBy(int healthPoints){
        setHealth(getHealth() + healthPoints);
    }
    default boolean isAlive() {
        return getHealth() > 0;
    }
}
