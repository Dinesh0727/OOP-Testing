
/**
 * 
 * Class Sage that extends the Abstract Class Character
 *
 */

public class Sage extends Character {
	
	/**
	 * Parameterized constructor for Sage
	 * @param gun gun Object of Gun class, the gun that Sage has
	 * @param health health Integer that contains the total health of Sage
	 * @param maxNumberOfUses Integer that contains the maximum uses of uses of Special Ability allowed
	 * @param experience Integer that contains the number of years of experience
	 * @param power Integer that contains the power of Sage<br><br>
	 * <b>Note:</b> Initialise special ability as HealingOrb with heal as (power + 0.3*experience) and numOfUses as maxNumberOfUses
	 */
	
	public Sage(Gun gun, float health, int maxNumberOfUses, int experience, int power) {
		this.gun = gun;
		this.health = health;
		this.specialAbility = new HealingOrb(power + 0.3f*experience, maxNumberOfUses);
	}
	
	/**
	 * Function that calculates the damage and or heal caused by Special Ability and decrements the value of numberOfUses by 1
	 * 
	 * @return Float variable that contains the value of damage caused 
	 */
	
	public float useSpecialAbility() {
		float value = 0f;
		value = ((HealingOrb)specialAbility).heal;
		specialAbility.numberOfUses--;
		return value;
	}
}
  