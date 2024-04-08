import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
	
	// Usage of @Test Tag for jupiter API to identify the method as test 
	@Test
	void testAddition() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(8, mathUtils.add(5, 3));
	}
		
	// Third Argument is for the description of why the test case has failed
	@Test
	void testSubtraction() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(2, mathUtils.subtract(5, 3), "subtract method should return the difference between a and b");
	}

	// Test using AssertAll
	@Test
	void testMultiply() {
		MathUtils mathUtils = new MathUtils();
		assertAll("Multiplication Test",
	            () -> assertEquals(15, mathUtils.multiply(5, 3), "multiply method should return the product of a and b"),
	            () -> assertEquals(0, mathUtils.multiply(7, 0), "multiply method should return 0 when one operand is 0"),
	            () -> assertEquals(-20, mathUtils.multiply(4, -5), "multiply method should handle negative numbers correctly")
	        );
	}
	
	// Test using assertArrayEquals
	@Test
	void testArrayEquals() {
		MathUtils mathUtils = new MathUtils();
		int[] array = {1, 2, 3};
		int[] expectedArray = {2, 4, 6};
		int[] actualArray = new int[3];
		for(int i=0;i<3;i++) {
			actualArray[i] = mathUtils.multiply(array[i], 2);
		}
		assertArrayEquals(expectedArray, actualArray, "multiply method should return the product of a and b");
	}
	
	// Test using assertIterableEquals
	@Test
    void testIterableEquals() {
        MathUtils mathUtils = new MathUtils();
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 10, 15));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(3, 8, 13));
        List<Integer> actualList = new ArrayList<>();
        for (Integer num : list) {
            actualList.add(mathUtils.subtract(num, 2));
        }
        assertIterableEquals(expectedList, actualList, "subtract method should return the difference between a and b");
    }
	
	
	// Test where arithmetic exception as exception is thrown
	@Test
    void testDivideByZeroThrowsException() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0));
    }
	
	// Test where arithmetic exception as exception is thrown
	@Disabled
	@Test
    void testDivideByZeroNotThrowsException() {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class, () -> mathUtils.divideWithoutArithmeticException(10, 0));
    }
	
	// Nested Test classes
	@Nested
    class AdditionTests {

        @Test
        void testAdditionWithPositiveNumbers() {
            MathUtils mathUtils = new MathUtils();
            assertEquals(8, mathUtils.add(5, 3));
        }

        @Test
        void testAdditionWithNegativeNumbers() {
            MathUtils mathUtils = new MathUtils();
            assertEquals(-2, mathUtils.add(-5, 3));
        }
    }
	
	@Tag("extra")
    @DisplayName("Additional tests for MathUtils")
    @Test
    void additionalTests() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(25, mathUtils.add(20, 5), "add method should return the sum of a and b");
        assertEquals(10, mathUtils.subtract(15, 5), "subtract method should return the difference between a and b");
    }
	
}
