package testCases;
import model.*;
import java.util.*;
import org.junit.*;

import junit.framework.TestCase;


/**
 * This class a part of the test cases which is used to test the functionality of a Normal Zombies and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */

//To test health in milestone 3 
public class TestNormalZombie extends TestCase{

	private NormalZombie n1, n2, n3;
	private ArrayList<NormalZombie> normalZombies;
	private ArrayList<Plant> plants;
	private boolean isEaten, walnutStatus = false; //isEaten true or false 
	private int damagePoints;
	private char plantType;
	@Before
	/**
	 * This method set's up the array list and the zombies
	 */
	public void setUp() throws Exception {
		normalZombies = new ArrayList<NormalZombie>();
		plants = new ArrayList<Plant>();
		n1 = new NormalZombie(10, 10, isEaten, damagePoints, 'z', walnutStatus );
		n2 = new NormalZombie(20, 20, isEaten, damagePoints, 'z', walnutStatus );
		n3 = new NormalZombie(30, 30, isEaten, damagePoints, 'z', walnutStatus);
		
	}
	
	/**
	 * This method tests when the game is starting and there are no normal zombies
	 */
	public void testEmptyListSize() {
		
		ArrayList<NormalZombie> emptyList = normalZombies;
		assertEquals("Size of noraml zombie list should be 0", 0, emptyList.size());//edge case when the game board is empty
	}
	
	/**
	 * This method tests adding of normal zombies to the array list 
	 */
	public void testAddNormalZombie() {
		ArrayList<NormalZombie> addNormalZombie = normalZombies;
		addNormalZombie.add(n1);
		addNormalZombie.add(n2);
		addNormalZombie.add(n3);
		assertEquals("Size of normal zombie list should be 3", 3, addNormalZombie.size());
	}

	/**
	 * This method tests the removing of normal zombies to the array list 
	 */
	public void testRemoveNormalZombie() {
		ArrayList<NormalZombie> removeNormalZombie = normalZombies;
		removeNormalZombie.add(n1);
		removeNormalZombie.add(n2);
		removeNormalZombie.add(n3);
		removeNormalZombie.remove(n1);
		removeNormalZombie.remove(n2);
		removeNormalZombie.remove(n3);
		assertEquals("Size of normal zombie list should be 0", 0, removeNormalZombie.size());
	}
	
	/**
	 * This method tests if the normal zombies are eaten or not
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Normal Zombie is eaten.", isEaten);
		}
		assertFalse("Normal Zombie plant is eaten.", isEaten);
		
	}
	
	/**
	 * This test case tests it the normal zombies are attacking 
	 */
	public void testDamagePoints() {
		
		for(NormalZombie n: normalZombies ) {
			for (Plant p: plants) {
				//edge case check for peashooter
				if(plantType == 'p' && n.getPositionX() == p.getPositionX()) {
					damagePoints -= 100;
					assertEquals("The damage points are ", damagePoints, n.getDmg());	
				}
				//edge case check for cherry bomb
				if(plantType == 'c' && (p.getPositionX() - n.getPositionX() == 1 || p.getPositionY() - n.getPositionY() <= 1)) {
					damagePoints = 0;
					assertEquals("The damage points are 0", damagePoints, n.getDmg());	
				}
				//edge case check for walnut
				if(plantType == 'w' && (p.getPositionX() == n.getPositionX() && p.getPositionY() == n.getPositionY())) {
					if (walnutStatus == true) {
						assertTrue("It is walnut status", n.walnutStatus());	
					}
					assertFalse("It is not walnut status", n.walnutStatus());	
				}
			}	
				
			}
		}
	
		
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestNormalZombie.class);
	}

}
