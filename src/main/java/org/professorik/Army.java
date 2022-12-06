package org.professorik;

import org.professorik.characters.IWarrior;
import org.professorik.characters.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private final Collection<IWarrior> troops = new ArrayList<>();
    private IWarrior last;

    public Iterator<IWarrior> firstAliveIterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> it = troops.iterator();
        IWarrior champion;

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
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }

    public List<IWarrior> getLiving() {
        return troops.stream().filter(IWarrior::isAlive).toList();
    }

    public void addUnits(IWarrior warrior) {
        if (last != null) {
            last.setNextBehind(warrior);
        }
        troops.add(warrior);
        last = warrior;
    }

    public Army addUnits(Supplier<IWarrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addUnits(factory.get());
        }
        return this;
    }
}
