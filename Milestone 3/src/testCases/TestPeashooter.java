package testCases;
import model.*;
import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a peashooter and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */
public class TestPeashooter extends TestCase {
	
	private Peashooter p1, p2, p3;
	private ArrayList<Peashooter> peashooters;
	private static int peashooterCost = 100;
	private int total = 1000;
	private boolean isEaten;
	
	@Before
	/**
	 * This method set's up the array list and the peashooters
	 */
	public void setUp() throws Exception {
		isEaten = false;
		peashooters = new ArrayList<Peashooter>();
		p1 = new Peashooter(10, 10, total, isEaten);
		p2 = new Peashooter(20, 20, total,isEaten);
		p3 = new Peashooter(30, 30, total,isEaten);
	}
	
	/**
	 * This method tests when the game is starting and there are no peashooters
	 */
	public void testEmptyListSize() {
		ArrayList<Peashooter> emptyList = peashooters;
		assertEquals("Size of peashooter list should be 0", 0, emptyList.size());
	}
	
	/**
	 * This method tests adding of peashooters to the array list and also checks the sunshine (cost)
	 */
	public void testAddCherryBomb() {
		ArrayList<Peashooter> addPeashooter = peashooters;
		addPeashooter.add(p1);
		total = total - peashooterCost; // update total
		assertEquals("Size of peashooters list should be 1", 1, addPeashooter.size());
		assertEquals("The total number of sunshines should be 900", 900, total); //edge case for checking if total sunshines is updated 
	}

	/**
	 * This method tests the removing of peashooter to the array list 
	 */
	public void testRemoveSunflower() { // edge case for when the game board is empty
		ArrayList<Peashooter> removePeashooter = peashooters;
		removePeashooter.add(p1);
		removePeashooter.add(p2);
		removePeashooter.add(p3);
		removePeashooter.remove(p1);
		removePeashooter.remove(p2);
		removePeashooter.remove(p3);
		assertEquals("Size of peashooter list should be 0", 0, removePeashooter.size());
	}
	
	/**
	 * This method tests whether the peashooter has been eaten 
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Peashooter is eaten.", isEaten);
		}
		assertFalse("Peashooter is eaten.", isEaten);		
	}
	
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestPeashooter.class);
	}

}
