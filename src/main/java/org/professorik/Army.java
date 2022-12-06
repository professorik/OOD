package org.professorik;

import org.professorik.characters.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private final Collection<Warrior> troops = new ArrayList<>();
    private Warrior last;

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

    public List<Warrior> getLiving() {
        return troops.stream().filter(Warrior::isAlive).toList();
    }

    public void addUnits(Warrior warrior) {
        if (last != null) {
            last.setNextBehind(warrior);
        }
        troops.add(warrior);
        last = warrior;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addUnits(factory.get());
        }
        return this;
    }
}
