package org.professorik;

import org.professorik.characters.Warrior;
import org.professorik.characters.interfaces.HasWarriorBehind;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private Collection<Warrior> troops = new ArrayList<>();
    private Warrior last;

    static class UnitInArmy extends Warrior implements HasWarriorBehind {
        Warrior warrior;
        Warrior behind;

        public UnitInArmy(Warrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public Warrior getWarriorBehind() {
            return behind;
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public boolean isAlive() {
            return warrior.isAlive();
        }

        @Override
        public int hit(Warrior opponent) {
            return warrior.hit(opponent);
        }
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior> {
        Iterator<Warrior> it = troops.iterator();
        Warrior champion;

        @Override
        public boolean hasNext() {
            if (champion != null && champion.isAlive()) {
                return true;
            }
            while (it.hasNext()) {
                champion = it.next();
                if (champion.isAlive()) return true;
            }
            return false;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }

    public Army addUnits(Warrior warrior) {
        if (last != null) {
            last.setNextBehind(warrior);
        }
        troops.add(warrior);
        last = warrior;
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addUnits(factory.get());
        }
        return this;
    }
}
