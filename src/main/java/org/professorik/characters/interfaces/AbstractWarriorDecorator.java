package org.professorik.characters.interfaces;

import org.professorik.characters.IWarrior;

public abstract class AbstractWarriorDecorator implements IWarrior {
    private final IWarrior warrior;

    protected IWarrior getKernel() {
        if (warrior instanceof AbstractWarriorDecorator) {
            return getKernel();
        }
        return warrior;
    }

    public AbstractWarriorDecorator(IWarrior warrior) {
        this.warrior = warrior;
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
    public void setHealth(int health) {
        getKernel().setHealth(health);
    }

    @Override
    public int receiveDamage(int damage) {
        return warrior.receiveDamage(damage);
    }

    @Override
    public IWarrior getWarriorBehind() {
        return warrior.getWarriorBehind();
    }

    @Override
    public void setNextBehind(IWarrior w) {
        warrior.setNextBehind(w);
    }
}
