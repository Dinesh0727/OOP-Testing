/**
 * 
 * Class Jett that extends Abstract Class Character
 *
 */

public class Jett extends Character {
	
	/**
	 * Parameterized constructor for Jett
	 * @param gun Object of Gun class, the gun that Jett has
	 * @param health Integer that contains the total health of Jett
	 * @param maxNumberOfUses Integer that contains the maximum uses of uses of Special Ability allowed
	 * @param experience Integer that contains the number of years of experience
	 * @param power Integer that contains the power of Jett<br><br>
	 * <b> Note: </b> Initialize special ability as MoonLight with lifeDrain as (power + 0.2*experience) and numberOfUses as maxNumberOfUses 
	 */
	
	public Jett(Gun gun, int health, int maxNumberOfUses, int experience, int power) {
		this.gun = gun;
		this.health = health;
		this.specialAbility = new MoonLight(power + 0.2f*experience, maxNumberOfUses);
	}
	
	/**
	 * Function that calculates the damage and or heal caused by Special Ability and decrements the value of numberOfUses by 1
	 * 
	 * @return Float variable that contains the value of damage caused 
	 */
	
	public float useSpecialAbility() {
		float value = 0f;
		value = ((MoonLight)specialAbility).lifeDrain;
		specialAbility.numberOfUses--;
		return value;
	}
}
