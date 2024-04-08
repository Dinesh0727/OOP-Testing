/**
 * Class to simulate a game between two characters
 * 
 *
 */

public class Game {
	
	/**
	 * String variable to store the name of the winner
	 */
	
	String nameOfWinner;
	
	/**
	 * Object of the class Character to store the first player
	 */
	
	Character player1;
	
	/**
	 * Object of the class Character to store the second player
	 */
	
	Character player2;
	
	/**
	 * Parameterized Constructor of the class Game
	 * @param player1 Object of the class Character
	 * @param player2 Object of the class Character
	 */
	
	public Game(Character player1, Character player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Function to change the health points of attacker/defender based on damage/heal value. <br>
	 *  1. If the damage/heal caused by the Special Ability is more than the damage caused by Gun and number of uses left for Special Ability is greater than zero then :-<br><br>
	 * 	1.1 If the attacker is instance of Phoenix, then decrease the health of defender<br>
	 * 	1.2 If the attacker is instance of Sage, then increase the health of the attacker<br>
	 * 	1.3 If the attacker is instance of Jett, then increase the health of the attacker and decrease the health of the defender<br><br>
	 * 2. Otherwise the attacker uses Gun and reduces the heath of the defender<br><br>
	 * <b> Hint: </b> Use useGun() and useSpecialAbility()
	 * @param attacker Player who is attacking
	 * @param defender Player who is defending
	 */
	

	private void calculateDamageAndHealth(Character attacker, Character defender) {
	    float gunDamage = attacker.gun.useGun();
	    float specialAbilityDamage = attacker.useSpecialAbility();

	    if (gunDamage < specialAbilityDamage && attacker.specialAbility.numberOfUses > 0) {
	        if (attacker instanceof Phoenix) {
	        	defender.decreaseHealth(specialAbilityDamage);
	        } else if (attacker instanceof Sage) {
	            attacker.increaseHealth(specialAbilityDamage);
	        } else {
	        	defender.decreaseHealth(specialAbilityDamage);
	            attacker.increaseHealth(specialAbilityDamage);
	        }
	    } else {
	    	defender.decreaseHealth(gunDamage);
	    }
	}
	
	/**
	 * Function to simulate the game between two characters.
	 * The game will consist of 10 rounds where in every round following things happen :- <br>
	 * 1. Player 1 uses Gun or Special Ability  <br>
	 * 2. The health of Player 1 and/or Player 2 is affected based on the Gun/Special Ability used <br>
	 * 3. If the health of Player 2 is less than or equal to zero, Player 1 wins <br>
	 * 4. Player 2 uses Gun or Special Ability <br>
	 * 5. The health of Player 1 and/or Player 2 is affected based on the Gun/Special Ability used <br>
	 * 6. If the health of Player 1 is less than or equal to zero, Player 2 wins <br>
	 * <br>
	 * Please ensure that you do the above steps in the given order only<br>
	 * <br>
	 * After 10 rounds<br>
	 * 1. The player who has the greater health wins the game<br>
	 * 2. In case both the players have the same health, the game ends in a draw<br>
	 * <br>
	 * <b>Hint: </b> use calculateDamageAndHealth() function 
	 * @return String "Player 1", "Player 2" or "Draw" based on the outcome of the game
	 */ 
	
	public String simulate() {
	    for (int j = 0; j < 10; j++) {
	        calculateDamageAndHealth(player1, player2);
	        
	        if(player2.health <= 0) {
	        	nameOfWinner = "Player 1";
	        	break;
	        }
	        
	        calculateDamageAndHealth(player2, player1);
	        
	        if(player1.health <=0) {
	        	nameOfWinner = "Player 2";
	        	break;
	        }
	    }
	    
	    if(nameOfWinner == null) {
	    	if(player1.health > player2.health) {
	    		nameOfWinner = "Player 1";
	    	} else if(player1.health < player2.health) {
	    		nameOfWinner = "Player 2";
	    	} else {
	    		nameOfWinner = "Draw";
	    	}
	    }
	    
	    return nameOfWinner;
	}
}
