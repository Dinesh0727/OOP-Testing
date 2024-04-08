import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Sample Test Case Class
 */

public class sampleTest {
	
	/**
	 * Sample Test Case. <br>
	 * Use this as an example and write your own test cases to test your code!
	 */
	
	@Test
	void sampleTestCase() {
		
		// Creating Gun for Player 1 of type Phantom with damage as 5, accuracy as 5 and recoil as 5
		Gun gun1 = new Phantom(5, 5, 5); 
		
		//Creating Gun for Player 2 of type Vandal with damage as 5, accuracy as 5 and recoil as 5
		Gun gun2 = new Vandal(5, 5, 5);  
		
		//Creating Player 1 of Character Phoenix, with health as 5, numberOfUses as 5, experience as 5 and power as 5
		Character player1 = new Phoenix(gun1, 15, 5, 5, 5); 
		
		//creating Player 2 of Character Sage, with health as 5, numberOfUses as 5, experience as 5 and power as 5
		Character player2 = new Sage(gun2, 15, 5, 5, 5); 
		
		//Initializing the game between Player 1 and Player 2
		Game game = new Game(player1,player2); 
		
		//Simulating the game between Player 1 and Player 2
		String winner = game.simulate();
		
		//Asserting results
		assert(player1.specialAbility instanceof HotHands);
		assert(player2.specialAbility instanceof HealingOrb);
		assertEquals(((HealingOrb) player2.specialAbility).heal, 6.5);
		assertEquals("Player 1", winner, "Incorrect result");	
	}
}
