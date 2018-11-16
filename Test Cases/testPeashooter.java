import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a peashooter and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 15th, 2018
 *
 */
public class testPeashooter extends TestCase{

	private Peashooter p1, p2, p3;
	private ArrayList<Peashooter> peashooters;
	private static int peashooterCost = 100;
	private int total = 1000;
	
	@Before
	/**
	 * This method set's up the array list and the peashooters 
	 */
	public void setUp() throws Exception {
		peashooters = new ArrayList<Peashooter>();
		p1 = new Peashooter(10, 10, total);
		p2 = new Peashooter(20, 20, total);
		p3 = new Peashooter(30, 30, total);
	}
	
	/**
	 * This method tests when the game is starting and there are no peashooters
	 */
	public void testEmptyListSize() {
		
		ArrayList<Peashooter> emptyList = peashooters;
		assertEquals("Size of peashooter list should be 0", 0, emptyList.size());
	}
	
	/**
	 * This method tests adding of peashooter to the array list and also the sunshine used
	 */
	public void testAddPeashooter() {
		ArrayList<Peashooter> addPeashooter = peashooters;
		addPeashooter.add(p1);
		total = total - peashooterCost; // update total
		assertEquals("Size of peashooter list should be 1", 1, addPeashooter.size());
		assertEquals("The total number of sunshines should be 900", 900, total); //edge case for checking if total sunshines is updated
	}

	/**
	 * This method tests the removing of peashooter to the array list 
	 */
	public void testRemovePeashooter() {
		ArrayList<Peashooter> removePeashooter = peashooters;
		removePeashooter.add(p1);
		removePeashooter.add(p2);
		removePeashooter.add(p3);
		removePeashooter.remove(p1);
		removePeashooter.remove(p2);
		removePeashooter.remove(p3);
		assertEquals("Size of peashooter list should be 0", 0, removePeashooter.size());
	}
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(testPeashooter.class);
	}

}