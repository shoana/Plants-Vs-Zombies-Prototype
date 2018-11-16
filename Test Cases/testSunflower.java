import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a sunflowers and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 15th, 2018
 *
 */
public class testSunflower extends TestCase{

	private Sunflower s1, s2, s3;
	private ArrayList<Sunflower> sunflowers;
	private static int sunflowerCost = 50;
	private int total = 1000;
	
	@Before
/**
	 * This method set's up the array list and the sunflowers
	 */
	public void setUp() throws Exception {
		sunflowers = new ArrayList<Sunflower>();
		s1 = new Sunflower(10, 10, total);
		s2 = new Sunflower(20, 20, total);
		s3 = new Sunflower(30, 30, total);
	}

	/**
	 * This method tests when the game is starting and there are no sunflower
	 */
	public void testEmptyListSize() {
		ArrayList<Sunflower> emptyList = sunflowers;
		assertEquals("Size of sunflower list should be 0", 0, emptyList.size());
	}
	
	/**
	 * This method tests adding of sunflower to the array list and also the sunshine used
	 */
	public void testAddSunflower() {
		ArrayList<Sunflower> addSunflower = sunflowers;
		addSunflower.add(s1);
		total = total - sunflowerCost; // update total
		assertEquals("Size of peashooter list should be 1", 1, addSunflower.size());
		assertEquals("The total number of sunshines should be 950", 950, total); //edge case for checking if total sunshines is updated 
	}

	/**
	 * This method tests the removing of sunflower to the array list 
	 */
	public void testRemoveSunflower() { // edge case for when the game board is empty
		ArrayList<Sunflower> removeSunflower = sunflowers;
		removeSunflower.add(s1);
		removeSunflower.add(s2);
		removeSunflower.add(s3);
		removeSunflower.remove(s1);
		removeSunflower.remove(s2);
		removeSunflower.remove(s3);
		assertEquals("Size of peashooter list should be 0", 0, removeSunflower.size());
	}
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(testSunflower.class);
	}

}
