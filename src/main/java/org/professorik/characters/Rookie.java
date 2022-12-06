package org.professorik.characters;

import org.professorik.characters.interfaces.AbstractWarriorDecorator;

public class Rookie extends AbstractWarriorDecorator {
    public Rookie() {
        super(new Warrior(50, 1));
    }
}
