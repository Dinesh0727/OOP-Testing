
/**
 * 
 * Class MoonLight that extends the Abstract Class Special Ability
 *
 */

public class MoonLight extends SpecialAbility {
	
	/**
	 * Float variable to store the amount of healthPoints that will increase of the user and decrease of the opponent upon the use of Moonlight
	 */

	public float lifeDrain;
	
	/**
	 * Parameterized constructor of MoonLight Class
	 * @param lifeDrain Float variable to store the amount of healthPoints that will increase of the user and decrease of the opponent upon the use of Moonlight
	 * @param numberOfUses Integer value containing the numberOfUses of Special Ability left
	 */
	
	public MoonLight(float lifeDrain, int numberOfUses) {
		this.numberOfUses = numberOfUses;
		this.lifeDrain = lifeDrain;
	}
}
