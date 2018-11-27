package testCases;
import model.*;
import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * 
 * This class a part of the test cases which is used to test the functionality of a Pylon Zombies and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */

public class TestPylonZombie extends TestCase{

	private PylonZombie pz1, pz2, pz3;
	private ArrayList<PylonZombie> pylonZombies;
	private ArrayList<Plant> plants;
	private boolean isEaten, walnutStatus;
	private int damagePoints;
	private char plantType;
	@Before
	/**
	 * This method set's up the array list and the pylon zombies
	 */
	public void setUp() throws Exception {
		pylonZombies = new ArrayList<PylonZombie>();
		plants = new ArrayList<Plant>();
		isEaten = false; 
		pz1 = new PylonZombie(10, 10, isEaten, damagePoints, 'x', walnutStatus );
		pz2 = new PylonZombie(20, 20, isEaten, damagePoints, 'x', walnutStatus);
		pz3 = new PylonZombie(30, 30, isEaten, damagePoints, 'x', walnutStatus);
	}
	
	/**
	 * This method tests when the game is starting and there are no pylon zombies
	 */
	public void testEmptyListSize() {
		ArrayList<PylonZombie> emptyList = pylonZombies;
		assertEquals("Size of pylon zombie list should be 0", 0, emptyList.size()); //edge case when the game board is empty
	}
	
	/**
	 * This method tests adding of pylon zombies to the array list 
	 */
	public void testAddNormalZombie() {
		ArrayList<PylonZombie> addPylonZombie = pylonZombies;
		addPylonZombie.add(pz1);
		addPylonZombie.add(pz2);
		addPylonZombie.add(pz3);
		assertEquals("Size of normal zombie list should be 3", 3, addPylonZombie.size());
	}

	/**
	 * This method tests the removing of pylon zombies to the array list 
	 */
	public void testRemoveZombie() {
		ArrayList<PylonZombie> removePylonZombie = pylonZombies;
		removePylonZombie.add(pz1);
		removePylonZombie.add(pz2);
		removePylonZombie.add(pz3);
		removePylonZombie.remove(pz1);
		removePylonZombie.remove(pz2);
		removePylonZombie.remove(pz3);
		assertEquals("Size of normal zombie list should be 0", 0, removePylonZombie.size());
	}
	
	/**
	 * This method tests if the pylon zombies are eaten or not
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Pylon Zombie is eaten.", isEaten);
		}
		assertFalse("Pylon Zombie plant is eaten.", isEaten);
		
	}
	
	/**
	 * This test case tests it the pylon zombies are attacking 
	 */
	public void testDamagePoints() {
		
		for(PylonZombie pz: pylonZombies ) {
			for (Plant p: plants) {
				 // check peashooter plant
				if(plantType == 'p' && pz.getPositionX() == p.getPositionX()) {
					damagePoints -= 100;
					assertEquals("The damage points are ", damagePoints, pz.getDmg());	
				}
				 // check cherrybomb plant
				if(plantType == 'c' && (p.getPositionX() - pz.getPositionX() == 1 || p.getPositionY() - pz.getPositionY() <= 1)) {
					damagePoints = 0;
					assertEquals("The damage points are 0", damagePoints, pz.getDmg());	
				}
				//check walnut plant
				if(plantType == 'w' && (p.getPositionX() == pz.getPositionX() && p.getPositionY() == pz.getPositionY())) {
					if (walnutStatus == true) {
						assertTrue("It is walnut status", pz.walnutStatus());	
					}
					assertFalse("It is not walnut status", pz.walnutStatus());	
				}
			}	
				
		}
	}
		
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestPylonZombie.class);
	}

}
