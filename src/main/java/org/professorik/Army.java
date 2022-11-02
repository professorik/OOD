package org.professorik;

import org.professorik.characters.Warrior;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

public class Army {
    private Queue<Warrior> troops = new LinkedList<>();

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

    Warrior peekFirst() {
        return troops.peek();
    }

    void removeFirst() {
        troops.poll();
    }
}
