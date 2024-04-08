/**
 * Abstract class Character
 * 
 *
 */
public abstract class Character {
	
	/**
	 * Float variable to store the health points of the character
	 */
	
	public float health;
	
	/**
	 * Object of the abstract class Gun
	 */
	public Gun gun;
	
	/**
	 * Object of the abstract class Special Ability
	 */
	public SpecialAbility specialAbility;
	
	/**
	 * Integer variable to store the experience of the character
	 */
	public int experience;
	
	/**
	 * Integer variable to store the power of the character
	 */
	public int power;
	
	/**
	 * Abstract Method of Character Class
	 */
	
	public abstract float useSpecialAbility();
	
	/**
	 * Function to increase the health of the character
	 * @param healthPoints Float variable to increase the value of the health of the character by the given value
	 */
	
	public void increaseHealth(float healthPoints) {
		this.health += healthPoints;
	}
	
	/**
	 * Function to decrease the health of the character
	 * @param healthPoints Float variable to decrease the value of the health of the character by the given value
	 */
	
	public void decreaseHealth(float healthPoints) {
		this.health -= healthPoints;
	}
}
