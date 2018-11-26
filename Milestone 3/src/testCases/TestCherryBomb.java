package testCases;
import model.*;

import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a cherrybomb and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */
public class TestCherryBomb extends TestCase {
	
	private CherryBomb c1, c2, c3;
	private ArrayList<CherryBomb> cherrybombs;
	private static int cherrybombCost = 200;
	private int total = 1000;
	private boolean isEaten;
	
	@Before
	/**
	 * This method set's up the array list and the cherry bombs
	 */
	public void setUp() throws Exception {
		isEaten = false;
		cherrybombs = new ArrayList<CherryBomb>();
		c1 = new CherryBomb(10, 10, total, isEaten);
		c2 = new CherryBomb(20, 20, total,isEaten);
		c3 = new CherryBomb(30, 30, total,isEaten);
	}
	
	/**
	 * This method tests when the game is starting and there are no cherrybombs
	 */
	public void testEmptyListSize() {
		ArrayList<CherryBomb> emptyList = cherrybombs;
		assertEquals("Size of cherry bomb list should be 0", 0, emptyList.size());
	}
	
	/**
	 * This method tests adding of cherry bombs to the array list and also checks the sunshine (cost)
	 */
	public void testAddCherryBomb() {
		ArrayList<CherryBomb> addCherryBomb = cherrybombs;
		addCherryBomb.add(c1);
		total = total - cherrybombCost; // update total
		assertEquals("Size of cherry bomb list should be 1", 1, addCherryBomb.size());
		assertEquals("The total number of sunshines should be 800", 800, total); //edge case for checking if total sunshines is updated 
	}

	/**
	 * This method tests the removing of cherry bombs to the array list 
	 */
	public void testRemoveSunflower() { // edge case for when the game board is empty
		ArrayList<CherryBomb> removeCherryBomb = cherrybombs;
		removeCherryBomb.add(c1);
		removeCherryBomb.add(c2);
		removeCherryBomb.add(c3);
		removeCherryBomb.remove(c1);
		removeCherryBomb.remove(c2);
		removeCherryBomb.remove(c3);
		assertEquals("Size of cherry bomb list should be 0", 0, removeCherryBomb.size());
	}
	
	/**
	 * This method tests whether the cherry bomb has been eaten 
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Cherry Bomb is eaten.", isEaten);
		}
		assertFalse("Cherry Bomb is eaten.", isEaten);		
	}
	
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestCherryBomb.class);
	}

}
