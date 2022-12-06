package org.professorik.characters.interfaces;

public interface CanAttack {
    int getAttack();
    default void hit(CanReceiveDamage w) {
        w.receiveDamage(getAttack());
    }
    default void straightHit(CanReceiveDamage w) {
        w.receiveDamage(getAttack());
    }
}
