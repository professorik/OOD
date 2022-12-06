package org.professorik.characters.interfaces;

public interface CanProcessCommand extends HasWarriorBehind {
    default void processCommand(Command command, CanProcessCommand sender) {
        var next = this.getWarriorBehind();
        if (next != null) {
            next.processCommand(command, this);
        }
    }
}
