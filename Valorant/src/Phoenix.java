
/**
 * 
 * Class Phoenix that extends the Abstract Class Character
 *
 */

public class Phoenix extends Character {
	
	/**
	 * Parameterized constructor for Phoenix
	 * @param gun gun Object of Gun class, the gun that Phoenix has
	 * @param health health Integer that contains the total health of Phoenix
	 * @param maxNumberOfUses Integer that contains the maximum uses of uses of Special Ability allowed
	 * @param experience Integer that contains the number of years of experience
	 * @param power Integer that contains the power of Phoenix<br><br>
	 * <b>Note:</b> Initialise special ability as HotHands with damage as (power + 0.1*experience) and numOfUses as maxNumberOfUses
	 */
	
	public Phoenix(Gun gun, int health, int maxNumberOfUses, int experience, int power) {
		this.gun = gun;
		this.health = health;
		this.specialAbility = new HotHands(power + 0.1f*experience, maxNumberOfUses);
	}	
	
	/**
	 * Function that calculates the damage and or heal caused by Special Ability and decrements the value of numberOfUses by 1
	 * 
	 * @return Float variable that contains the value of damage caused 
	 */
	
	public float useSpecialAbility() {
		float value = 0f;
		value = ((HotHands)specialAbility).damage;
		specialAbility.numberOfUses--;
		return value;
	}
}
