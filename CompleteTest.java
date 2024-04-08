import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Test Character and its subclasses")
class CompleteTest {

    Character character;
    Gun gun;
    SpecialAbility specialAbility;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Initializing test suite...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Cleaning up test suite...");
    }

    @BeforeEach
    void setUp() {
        gun = new Phantom(30, 0.8f, 5);
        specialAbility = new HealingOrb(20, 3);
        System.out.println("Setting up for each test...");
    }

    @Nested
    @DisplayName("Test Character class")
    class CharacterClassTests {

        @DisplayName("Test increaseHealth method")
        @Test
        void testIncreaseHealth() {
            character = new Jett(gun, 100, 3, 50, 20);
            character.increaseHealth(10);
            assertEquals(110, character.health);
        }

        @DisplayName("Test decreaseHealth method")
        @Test
        void testDecreaseHealth() {
            character = new Jett(gun, 100, 3, 50, 20);
            character.decreaseHealth(20);
            assertEquals(80, character.health);
        }

        @DisplayName("Test useSpecialAbility method in Jett class")
        @Test
        void testUseSpecialAbilityJett() {
            character = new Jett(gun, 100, 3, 50, 20);
            assertEquals(22.0f, character.useSpecialAbility());
        }
    }

    @Nested
    @DisplayName("Test SpecialAbility subclasses")
    class SpecialAbilityTests {

        @DisplayName("Test HealingOrb class")
        @Test
        void testHealingOrb() {
            specialAbility = new HealingOrb(20, 3);
            assertEquals(20, ((HealingOrb) specialAbility).heal);
        }

        @DisplayName("Test HotHands class")
        @Test
        void testHotHands() {
            specialAbility = new HotHands(15, 2);
            assertEquals(15, ((HotHands) specialAbility).damage);
        }

        @DisplayName("Test MoonLight class")
        @Test
        void testMoonLight() {
            specialAbility = new MoonLight(25, 3);
            assertEquals(25, ((MoonLight) specialAbility).lifeDrain);
        }
    }

    @Nested
    @DisplayName("Test Gun subclasses")
    class GunTests {

        @DisplayName("Test Phantom class")
        @Test
        void testPhantom() {
            gun = new Phantom(30, 0.8f, 5);
            assertEquals(30, ((Phantom) gun).damage);
        }

        @DisplayName("Test Vandal class")
        @Test
        void testVandal() {
            gun = new Vandal(35, 0.9f, 7);
            assertEquals(35, ((Vandal) gun).damage);
        }
    }
    
    @DisplayName("Test Game class")
    class GameTest {

        Character player1;
        Character player2;
        Game game;

        @BeforeEach
        void setUp() {
            Gun gun1 = new Phantom(30, 0.8f, 5);
            Gun gun2 = new Vandal(35, 0.9f, 7);
            player1 = new Jett(gun1, 100, 3, 50, 20);
            player2 = new Sage(gun2, 90, 3, 50, 20);
            game = new Game(player1, player2);
            System.out.println("Setting up for each test in GameTest...");
        }

        @Test
        @DisplayName("Test simulate method")
        void testSimulate() {
            String winner = game.simulate();
            assertTrue(winner.equals("Player 1") || winner.equals("Player 2") || winner.equals("Draw"));
            System.out.println("Simulating the game...");
        }
    }
}


