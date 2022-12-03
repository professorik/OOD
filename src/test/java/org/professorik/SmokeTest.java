package org.professorik;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.professorik.characters.*;
import org.professorik.characters.interfaces.IWarrior;

import static org.junit.jupiter.api.Assertions.*;

class SmokeTest {

    @Test
    @DisplayName("Smoke test for Warrior and Knight task")
    void smokeTest1() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    @DisplayName("Smoke test for Army task")
    void smokeTest2() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assertTrue(Battle.fight(myArmy, enemyArmy));
        assertFalse(Battle.fight(army3, army4));
    }

    @Test
    @DisplayName("Smoke test for Defender task")
    void smokeTest3() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
        assertTrue(Battle.fight(army3, army4));
    }

    @Test
    @DisplayName("Smoke test for Vampire task")
    void smokeTest4() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));

        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());

        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());

        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));
        assertFalse(Battle.fight(eric, richard));
        assertTrue(Battle.fight(ogre, adam));

        var myArmy = new Army()
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 2)
                .addUnits(Warrior::new, 1);

        var enemyArmy = new Army()
                .addUnits(Warrior::new, 2)
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 3);

        var army3 = new Army()
                .addUnits(Warrior::new, 1)
                .addUnits(Defender::new, 4);

        var army4 = new Army()
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 2);

        assertFalse(Battle.fight(myArmy, enemyArmy));
        assertTrue(Battle.fight(army3, army4));
    }

    @Test
    @DisplayName("Smoke test for Lancer task")
    void smokeTest5() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));
        assertFalse(Battle.fight(eric, richard));
        assertTrue(Battle.fight(ogre, adam));
        assertTrue(Battle.fight(freelancer, vampire));
        assertTrue(freelancer.isAlive());

        var myArmy = new Army()
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 2)
                .addUnits(Lancer::new, 4)
                .addUnits(Warrior::new, 1);

        var enemyArmy = new Army()
                .addUnits(Warrior::new, 2)
                .addUnits(Lancer::new, 2)
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 3);

        var army3 = new Army()
                .addUnits(Warrior::new, 1)
                .addUnits(Lancer::new, 1)
                .addUnits(Defender::new, 2);

        var army4 = new Army()
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 1)
                .addUnits(Lancer::new, 2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
        assertFalse(Battle.fight(army3, army4));
    }

    @Test
    @DisplayName("Smoke test for Healer task")
    void smokeTest6() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();
        var freelancer = new Lancer();
        var vampire = new Vampire();
        var priest = new Healer();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());
        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));
        assertFalse(Battle.fight(eric, richard));
        assertTrue(Battle.fight(ogre, adam));
        assertTrue(Battle.fight(freelancer, vampire));
        assertTrue(freelancer.isAlive());
        assertEquals(14, freelancer.getHealth());
        priest.heal(freelancer);
        assertEquals(16, freelancer.getHealth());

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);
        enemyArmy.addUnits(Healer::new, 1);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Healer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Healer::new, 1);
        army4.addUnits(Lancer::new, 2);

        var army5 = new Army();
        army5.addUnits(Warrior::new, 10);

        var army6 = new Army();
        army6.addUnits(Warrior::new, 6);
        army6.addUnits(Lancer::new, 5);

        assertFalse(Battle.fight(myArmy, enemyArmy));
        assertTrue(Battle.fight(army3, army4));
        //assertFalse(Battle.straightFight(army5, army6));
    }
}
