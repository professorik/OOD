package org.professorik;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.professorik.characters.*;
import org.professorik.characters.Warrior;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

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

    @Test
    @DisplayName("8. Fight")
    void fight8() {
        var unit_1 = new Defender();
        var unit_2 = new Rookie();

        Battle.fight(unit_1, unit_2);

        assertEquals(60, unit_1.getHealth());
    }

    @Test
    @DisplayName("9. Fight")
    void fight9() {
        var unit_1 = new Defender();
        var unit_2 = new Rookie();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var res = Battle.fight(unit_1, unit_3);

        assertTrue(res);
    }

    @ParameterizedTest
    @ValueSource(classes = {Warrior.class, Knight.class})
    void name(Class<?> cls) {
        assertTrue(Warrior.class.isAssignableFrom(cls));
    }

    @ParameterizedTest(name = "{index} - first = {0} against second = {1}, first wins?: {2}")
    @MethodSource
    @DisplayName("Duel for two warriors")
    void testTwoWarriorsDuel(Warrior warrior1, Warrior warrior2, boolean expected) {
        var res = Battle.fight(warrior1, warrior2);

        assertEquals(expected, res);
    }

    static Stream<Arguments> testTwoWarriorsDuel() {
        return Stream.of(
                Arguments.of(new Warrior(), new Warrior(), true),
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(new Knight(), new Knight(), true)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("Battle for two warriors")
    void testTwoArmiesDuel(Army army1, Army army2, boolean expected) {
        var res = Battle.fight(army1, army2);

        assertEquals(expected, res);
    }

    static Stream<Arguments> testTwoArmiesDuel() {
        return Stream.of(
                Arguments.of(
                        new Army()
                                .addUnits(Warrior::new, 1)
                                .addUnits(Knight::new, 1),
                        new Army()
                                .addUnits(Knight::new, 1)
                                .addUnits(Warrior::new, 1),
                        true),
                Arguments.of(
                        new Army()
                                .addUnits(Warrior::new, 3),
                        new Army()
                                .addUnits(Knight::new, 3),
                        false)
        );
    }
}
