
import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a Flag Zombies and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */

public class TestFlagZombie extends TestCase{

	private FlagZombie f1, f2, f3;
	private ArrayList<FlagZombie> flagZombies;
	private ArrayList<Plant> plants;
	private boolean isEaten, walnutStatus = false; //isEaten true or false 
	private int damagePoints;
	private char plantType;

	@Before
	/**
	 * This method set's up the array list and the zombies
	 */
	public void setUp() throws Exception {
		flagZombies = new ArrayList<FlagZombie>();
		plants = new ArrayList<Plant>();
		f1 = new FlagZombie(10, 10, isEaten, damagePoints, 'f', walnutStatus );
		f2 = new FlagZombie(20, 20, isEaten, damagePoints, 'f', walnutStatus);
		f3 = new FlagZombie(30, 30, isEaten, damagePoints, 'f', walnutStatus);
		
	}
	
	/**
	 * This method tests when the game is starting and there are no flag zombies
	 */
	public void testEmptyListSize() {
		
		ArrayList<FlagZombie> emptyList = flagZombies;
		assertEquals("Size of flag zombie list should be 0", 0, emptyList.size());//edge case when the game board is empty
	}
	
	/**
	 * This method tests adding of flag zombies to the array list 
	 */
	public void testAddFlagZombie() {
		ArrayList<FlagZombie> addFlagZombie = flagZombies;
		addFlagZombie.add(f1);
		addFlagZombie.add(f2);
		addFlagZombie.add(f3);
		assertEquals("Size of normal zombie list should be 3", 3, addFlagZombie.size());
	}

	/**
	 * This method tests the removing of flag zombies to the array list 
	 */
	public void testRemoveFlagZombie() {
		ArrayList<FlagZombie> removeFlagZombie = flagZombies;
		removeFlagZombie.add(f1);
		removeFlagZombie.add(f2);
		removeFlagZombie.add(f3);
		removeFlagZombie.remove(f1);
		removeFlagZombie.remove(f2);
		removeFlagZombie.remove(f3);
		assertEquals("Size of normal zombie list should be 0", 0, removeFlagZombie.size());
	}
	
	/**
	 * This method tests if the flag zombies are eaten or not
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Flag Zombie is eaten.", isEaten);
		}
		assertFalse("Flag Zombie plant is eaten.", isEaten);
		
	}
	
	/**
	 * This test case tests it the flag zombies are attacking 
	 */
	public void testDamagePoints() {
		
		for(FlagZombie f: flagZombies ) {
			for (Plant p: plants) {
				//edge case for plant type peashooter
				if(plantType == 'p' && f.getPositionX() == p.getPositionX()) {
					damagePoints -= 100;
					assertEquals("The damage points are ", damagePoints, NormalZombie.getDmg());	
				}
				//edge case for plant type cherry bomb
				if(plantType == 'c' && (p.getPositionX() - f.getPositionX() == 1 || p.getPositionY() - f.getPositionY() <= 1)) {
					damagePoints = 0;
					assertEquals("The damage points are 0", damagePoints, NormalZombie.getDmg());	
				}
				//edge case for plant type walnut
				if(plantType == 'w' && (p.getPositionX() == f.getPositionX() && p.getPositionY() == f.getPositionY())) {
					if (walnutStatus == true) {
						assertTrue("It is walnut status", PylonZombie.walnutStatus());	
					}
					assertFalse("It is not walnut status", PylonZombie.walnutStatus());	
				}
			}	
				
			}
		}
		
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestFlagZombie.class);
	}

}
