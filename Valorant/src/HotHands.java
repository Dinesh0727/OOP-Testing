/**
 * 
 * Class HotHands that extends the Abstract Class Special Ability
 *
 */

public class HotHands extends SpecialAbility {
	
	/**
	 * Float variable to store the amount of healthPoints that will decrease of the opponent upon the use of HotHands
	 */
	
	public float damage;
	
	/**
	 * Parameterized Constructor for HotHands
	 * @param damage Float variable to store the amount of healthPoints that will decrease of the opponent upon the use of HotHands
	 * @param numberOfUses The maximum number of uses allowed for using HotHands
	 */
	
	public HotHands(float damage, int numberOfUses) {
		this.damage = damage;
		this.numberOfUses = numberOfUses;
	}
	
}
