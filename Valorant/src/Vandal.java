
/**
 * 
 * Class Vandal which extends Abstract Class Gun
 *
 */

public class Vandal extends Gun {
	
	/**
	 * Integer containing the value of damage caused by Vandal
	 */
	
	public int damage;
	
	/**
	 * Integer variable containing the value of recoil of Vandal
	 */
	
	public int recoil;
	
	/**
	 * Parameterized constructor 
	 * @param damage Integer containing the value of damage caused by Vandal
	 * @param accuracy Float containing the value of accuracy of the Gun
	 * @param recoil Integer containing the value of recoil of Vandal
	 */
	
	public Vandal(int damage, float accuracy, int recoil) {
		this.accuracy = accuracy;
		this.damage = damage;
		this.recoil = recoil;
	}
	
	/**
	 * Function to calculate the damage caused by Gun<br>
	 * damage caused = (damage - 0.2*recoil)*accuracy
	 * 
	 * @return float with the value of damage caused
	 */
	
	public float useGun() {
		return (damage - 0.2f*recoil)*accuracy;
	}
}
