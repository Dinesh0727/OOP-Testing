import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class JUnitLifeCycleAnnotationsTest {

    private MathUtils mathUtils;
    private int sharedVariable;

    // Setup method to initialize resources before each test
    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
        sharedVariable = 0; // Initialize shared variable
        System.out.println("Shared Variable Initialized: " + sharedVariable);
        System.out.println("MathUtils object address: " + mathUtils.hashCode());
    }

    // Teardown method to clean up resources after each test
    @AfterEach
    void tearDown() {
        mathUtils = null;
        sharedVariable = 0; // Reset shared variable
        System.out.println("Shared Variable Reset: " + sharedVariable);
    }

    // Executed once before all test methods in this class
    @BeforeAll
    static void beforeAll() {
        System.out.println("Initializing resources before all tests...");
    }

    // Executed once after all test methods in this class
    @AfterAll
    static void afterAll() {
        System.out.println("Cleaning up resources after all tests...");
    }

    @Nested
    class AdditionTests {
        
        @BeforeEach
        void setUp() {
            System.out.println("Setting up for AdditionTests...");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Tearing down for AdditionTests...");
        }

        @Test
        void testAddition1() {
            System.out.println("Running testAddition1...");
            assertEquals(8, mathUtils.add(5, 3));
            sharedVariable++; // Increment shared variable
            System.out.println("Shared Variable Incremented: " + sharedVariable);
            System.out.println("MathUtils object address: " + mathUtils.hashCode());
        }

        @Test
        void testAddition2() {
            System.out.println("Running testAddition2...");
            assertEquals(10, mathUtils.add(7, 3));
            sharedVariable++; // Increment shared variable
            System.out.println("Shared Variable Incremented: " + sharedVariable);
            System.out.println("MathUtils object address: " + mathUtils.hashCode());
        }
    }

    @Nested
    class SubtractionTests {
        
        @BeforeEach
        void setUp() {
            System.out.println("Setting up for SubtractionTests...");
        }

        @AfterEach
        void tearDown() {
            System.out.println("Tearing down for SubtractionTests...");
        }

        @Test
        void testSubtraction1() {
            System.out.println("Running testSubtraction1...");
            assertEquals(2, mathUtils.subtract(5, 3), "subtract method should return the difference between a and b");
            sharedVariable++; // Increment shared variable
            System.out.println("Shared Variable Incremented: " + sharedVariable);
            System.out.println("MathUtils object address: " + mathUtils.hashCode());
        }

        @Test
        void testSubtraction2() {
            System.out.println("Running testSubtraction2...");
            assertEquals(-2, mathUtils.subtract(3, 5), "subtract method should return the difference between a and b");
            sharedVariable++; // Increment shared variable
            System.out.println("Shared Variable Incremented: " + sharedVariable);
            System.out.println("MathUtils object address: " + mathUtils.hashCode());
        }
    }

    @Test
    void testSharedVariable() {
        assertEquals(6, sharedVariable, "Shared variable should be incremented 6 times");
    }
}
