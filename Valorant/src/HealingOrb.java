/**
 * 
 * Class HealingOrb that extends the Abstract Class Special Ability
 *
 */


public class HealingOrb extends SpecialAbility {
	
	/**
	 * Float variable to store the amount of healthPoints that will increase of the user upon the use of HealingOrb
	 */
	
	public float heal;
	
	/**
	 * Parameterized Constructor for HealingOrb
	 * @param heal Float variable to store the amount of healthPoints that will increase of the user upon the use of HealingOrb
	 * @param numberOfUses The maximum number of uses allowed for using Healing Orb 
	 */
	
	public HealingOrb(float heal, int numberOfUses) {
		this.heal = heal;
		this.numberOfUses = numberOfUses;
	}
}
