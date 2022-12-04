package org.professorik;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.professorik.characters.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattleTest {

    @Test
    @DisplayName("1. Battle")
    void battle1() {
        var army_1 = new Army().addUnits(Warrior::new, 1);
        var army_2 = new Army().addUnits(Warrior::new, 2);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("2. Battle")
    void battle2() {
        var army_1 = new Army().addUnits(Warrior::new, 2);
        var army_2 = new Army().addUnits(Warrior::new, 3);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("3. Battle")
    void battle3() {
        var army_1 = new Army().addUnits(Warrior::new, 5);
        var army_2 = new Army().addUnits(Warrior::new, 7);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("4. Battle")
    void battle4() {
        var army_1 = new Army().addUnits(Warrior::new, 20);
        var army_2 = new Army().addUnits(Warrior::new, 21);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("5. Battle")
    void battle5() {
        var army_1 = new Army().addUnits(Warrior::new, 10);
        var army_2 = new Army().addUnits(Warrior::new, 11);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("6. Battle")
    void battle6() {
        var army_1 = new Army().addUnits(Warrior::new, 11);
        var army_2 = new Army().addUnits(Warrior::new, 7);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("7. Battle")
    void battle7() {
        var army_1 = new Army()
                .addUnits(Warrior::new, 5)
                .addUnits(Defender::new, 4)
                .addUnits(Defender::new, 5);
        var army_2 = new Army().addUnits(Warrior::new, 4);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("8. Battle")
    void battle8() {
        var army_1 = new Army()
                .addUnits(Defender::new, 5)
                .addUnits(Warrior::new, 20);
        var army_2 = new Army()
                .addUnits(Warrior::new, 21)
                .addUnits(Defender::new, 4);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("9. Battle")
    void battle9() {
        var army_1 = new Army()
                .addUnits(Warrior::new, 10)
                .addUnits(Defender::new, 5);
        var army_2 = new Army()
                .addUnits(Warrior::new, 5);

        army_1 = army_1.addUnits(Defender::new, 10);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("10. Battle")
    void battle10() {
        var army_1 = new Army()
                .addUnits(Defender::new, 2)
                .addUnits(Warrior::new, 1)
                .addUnits(Defender::new, 1);
        var army_2 = new Army()
                .addUnits(Warrior::new, 5);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("11. Battle")
    void battle11() {
        var army_1 = new Army()
                .addUnits(Defender::new, 5)
                .addUnits(Vampire::new, 6)
                .addUnits(Warrior::new, 7);
        var army_2 = new Army()
                .addUnits(Warrior::new, 6)
                .addUnits(Defender::new, 6)
                .addUnits(Vampire::new, 6);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("12. Battle")
    void battle12() {
        var army_1 = new Army()
                .addUnits(Defender::new, 2)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 3);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("13. Battle")
    void battle13() {
        var army_1 = new Army()
                .addUnits(Defender::new, 11)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 13);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("14. Battle")
    void battle14() {
        var army_1 = new Army()
                .addUnits(Defender::new, 9)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 8);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 13);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("15. Battle")
    void battle15() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 5)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 5);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("16. Battle")
    void battle16() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 7)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 4);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("17. Battle")
    void battle17() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 7)
                .addUnits(Vampire::new, 3)
                .addUnits(Healer::new, 1)
                .addUnits(Warrior::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 4);

        var res = Battle.fight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("18. Battle")
    void battle18() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 1)
                .addUnits(Warrior::new, 3)
                .addUnits(Healer::new, 1)
                .addUnits(Warrior::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Knight::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 4);

        var res = Battle.fight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("19. Battle")
    void battle19() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 5)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 5);

        var res = Battle.straightFight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("20. Battle")
    void battle20() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 7)
                .addUnits(Vampire::new, 3)
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 4);

        var res = Battle.straightFight(army_1, army_2);

        assertTrue(res);
    }

    @Test
    @DisplayName("21. Battle")
    void battle21() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 7)
                .addUnits(Vampire::new, 3)
                .addUnits(Healer::new, 1)
                .addUnits(Warrior::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Defender::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Vampire::new, 6)
                .addUnits(Lancer::new, 4);

        var res = Battle.straightFight(army_1, army_2);

        assertFalse(res);
    }

    @Test
    @DisplayName("22. Battle")
    void battle22() {
        var army_1 = new Army()
                .addUnits(Lancer::new, 4)
                .addUnits(Warrior::new, 3)
                .addUnits(Healer::new, 1)
                .addUnits(Warrior::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Knight::new, 2);
        var army_2 = new Army()
                .addUnits(Warrior::new, 4)
                .addUnits(Defender::new, 4)
                .addUnits(Healer::new, 1)
                .addUnits(Vampire::new, 2)
                .addUnits(Lancer::new, 4);

        var res = Battle.straightFight(army_1, army_2);

        assertTrue(res);
    }
}
