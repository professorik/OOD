package org.professorik;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.professorik.characters.Knight;
import org.professorik.characters.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("Smoke test for Warrior and Knight task")
    void smokeTest1() {
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
    @DisplayName("1. Fight")
    void fight1() {
        var carl = new Warrior();
        var jim = new Knight();

        var res = Battle.fight(carl, jim);

        assertFalse(res);
    }

    @Test
    @DisplayName("2. Fight")
    void fight2() {
        var ramon = new Knight();
        var slevin = new Warrior();

        var res = Battle.fight(ramon, slevin);

        assertTrue(res);
    }

    @Test
    @DisplayName("3. Fight")
    void fight3() {
        var bob = new Warrior();
        var mars = new Warrior();

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void fight4() {
        var zeus = new Knight();
        var godkiller = new Warrior();

        Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void fight5() {
        var husband = new Warrior();
        var wife = new Warrior();

        Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void fight6() {
        var dragon = new Warrior();
        var knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight")
    void fight7() {
        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var res = Battle.fight(unit_2, unit_3);

        assertFalse(res);
    }
}
