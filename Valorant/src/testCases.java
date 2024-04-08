import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class testCases {

	@Test
	public void useGunPhantom() {
		Gun gun = new Phantom(5, 5, 5);
		assertEquals(5, gun.accuracy, "Incorrect result");
		assertEquals(5, ((Phantom) gun).damage, "Incorrect result");
		assertEquals(5, ((Phantom) gun).recoil, "Incorrect result");
		assertEquals(17.5f, gun.useGun(), "Incorrect result");
	}

	@Test
	public void useGunVandal() {
		Gun gun = new Vandal(5, 5, 5);
		assertEquals(5, gun.accuracy, "Incorrect result");
		assertEquals(5, ((Vandal) gun).damage, "Incorrect result");
		assertEquals(5, ((Vandal) gun).recoil, "Incorrect result");
		assertEquals(20f, gun.useGun(), "Incorrect result");
	}

	@Test
	public void PhoenixConstructor() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Phoenix(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((HotHands) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(5.5f, ((HotHands) player.specialAbility).damage, "Incorrect result");
		
	}

	@Test
	public void SageConstructor() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Sage(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((HealingOrb) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(6.5f, ((HealingOrb) player.specialAbility).heal, "Incorrect result");
	}

	@Test
	public void JettConstructor() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Jett(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((MoonLight) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(6.0f, ((MoonLight) player.specialAbility).lifeDrain, "Incorrect result");
	}
	
	
	@Test
	public void IncreaseHealthPoints() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Phoenix(gun, 15, 5, 5, 5);
		player.increaseHealth(2.3f);
		assertEquals(17.3f, player.health, "Incorrect result");
	}

	@Test
	public void DecreaseHealthPoints() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Sage(gun, 15, 5, 5, 5);
		player.decreaseHealth(2.3f);
		assertEquals(12.7f, player.health, "Incorrect result");
	}

	@Test
	public void useSpecialAbilityPhoenix() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Phoenix(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((HotHands) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(5.5f, ((HotHands) player.specialAbility).damage, "Incorrect result");
		assertEquals(5.5f, player.useSpecialAbility(), "Incorrect result");
		assertEquals(4.0f, ((HotHands) player.specialAbility).numberOfUses, "Incorrect result");
	}

	@Test
	public void useSpecialAbilitySage() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Sage(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((HealingOrb) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(6.5f, ((HealingOrb) player.specialAbility).heal, "Incorrect result");
		assertEquals(6.5f, player.useSpecialAbility(), "Incorrect result");
		assertEquals(4.0f, ((HealingOrb) player.specialAbility).numberOfUses, "Incorrect result");
	}

	@Test
	public void useSpecialAbilityJett() {
		Gun gun = new Phantom(5, 5, 5);
		Character player = new Jett(gun, 15, 5, 5, 5);
		assert (player.gun instanceof Phantom);
		assertEquals(15.0f, player.health, "Incorrect result");
		assertEquals(5.0f, ((MoonLight) player.specialAbility).numberOfUses, "Incorrect result");
		assertEquals(6.0f, ((MoonLight) player.specialAbility).lifeDrain, "Incorrect result");
		assertEquals(6.0f, player.useSpecialAbility(), "Incorrect result");
		assertEquals(4.0f, ((MoonLight) player.specialAbility).numberOfUses, "Incorrect result");
	}


	@Test
	void simulate1() {
		
		Gun gun1 = new Phantom(5, 5, 5);
		Gun gun2 = new Vandal(5, 5, 5);
		Character player1 = new Phoenix(gun1, 15, 5, 5, 5);
		Character player2 = new Sage(gun2, 15, 5, 5, 5);
		Game game = new Game(player1, player2);
		String winner = game.simulate();
		assert (player1.specialAbility instanceof HotHands);
		assert (player2.specialAbility instanceof HealingOrb);
		assertEquals(((HealingOrb) player2.specialAbility).heal, 6.5);
		assertEquals("Player 1", game.nameOfWinner, "Incorrect result");

	}

	@Test
	void simulate2() {

		Gun gun1 = new Phantom(5, 5, 5);
		Gun gun2 = new Phantom(5, 5, 5);
		Character player1 = new Jett(gun1, 1500, 5, 5, 5);
		Character player2 = new Jett(gun2, 1500, 5, 5, 5);
		Game game = new Game(player1, player2);
		String winner = game.simulate();
		assert (player1.specialAbility instanceof MoonLight);
		assert (player2.specialAbility instanceof MoonLight);
		assertEquals(((MoonLight) player2.specialAbility).lifeDrain, 6.0f);
		assertEquals("Draw", game.nameOfWinner, "Incorrect result");

	}
}