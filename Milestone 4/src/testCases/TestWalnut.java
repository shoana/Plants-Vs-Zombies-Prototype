package testCases;
import model.*;
import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a sunflowers and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version December 5th, 2018
 *
 */
public class TestWalnut extends TestCase{

	private Walnut w1, w2, w3;
	private ArrayList<Walnut> walnuts;
	private static int walnutCost = 200;
	private int total = 1000;
	private boolean isEaten;
	private int row, column;
	private gamePlay g;
	
	@Before
	/**
	 * This method set's up the array list and the walnuts
	 */
	public void setUp() throws Exception {
		isEaten = false;
		walnuts = new ArrayList<Walnut>();
		w1 = new Walnut(10, 10, total, isEaten);
		w2 = new Walnut(20, 20, total,isEaten);
		w3 = new Walnut(30, 30, total,isEaten);
		g = new gamePlay(row, column, total);
	}

	/**
	 * This method tests when the game is starting and there are no walnuts
	 */
	public void testEmptyListSize() {
		ArrayList<Walnut> emptyList = walnuts;
		assertEquals("Size of walnut list should be 0", 0, emptyList.size());
	}
	
	/**
	 * This method tests adding of walnut to the array list and also the sunshine used
	 */
	public void testAddWalnut() {
		ArrayList<Walnut> addWalnut = walnuts;
		addWalnut.add(w1);
		total = total - walnutCost; // update total
		assertEquals("Size of walnut list should be 1", 1, addWalnut.size());
		assertEquals("The total number of sunshines should be 800", 800, total); //edge case for checking if total sunshines is updated 
	}

	/**
	 * This method tests the removing of walnut to the array list 
	 */
	public void testRemoveWalnut() { // edge case for when the game board is empty
		ArrayList<Walnut> removeWalnut = walnuts;
		removeWalnut.add(w1);
		removeWalnut.add(w2);
		removeWalnut.add(w3);
		removeWalnut.remove(w1);
		removeWalnut.remove(w2);
		removeWalnut.remove(w3);
		assertEquals("Size of walnut list should be 0", 0, removeWalnut.size());
	}
	
	/**
	 * This method tests if the plants are eaten or not
	 */
	public void testIsEaten() {
		if (isEaten == true) {
			assertTrue("Walnut plant is eaten.", isEaten);
		}
		assertFalse("Walnut plant is eaten.", isEaten);
		
	}
	
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestWalnut.class);
	}

}
