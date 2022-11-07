package org.professorik;

import org.professorik.characters.Warrior;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {
    private Queue<Warrior> troops = new LinkedList<>();

    public Iterator<Warrior> firstAlive() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior> {
        @Override
        public boolean hasNext() {
            while (peekFirst() != null && !peekFirst().isAlive()) {
                removeFirst();
            }
            return peekFirst() != null;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return peekFirst();
        }
    }

    public Army addUnits(Warrior warrior) {
        troops.add(warrior);
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addUnits(factory.get());
        }
        return this;
    }

    private Warrior peekFirst() {
        return troops.peek();
    }

    private void removeFirst() {
        troops.poll();
    }
}
