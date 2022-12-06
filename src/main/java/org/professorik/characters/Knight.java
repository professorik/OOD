package org.professorik.characters;

import org.professorik.characters.interfaces.AbstractWarriorDecorator;

public class Knight extends AbstractWarriorDecorator {
    public Knight() {
        super(new Warrior(50, 7));
    }
}
