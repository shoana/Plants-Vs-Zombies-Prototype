import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of a Zombies and it's edge cases
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 15th, 2018
 *
 */

public class testZombies extends TestCase{

	private Zombie z1, z2, z3;
	private ArrayList<Zombie> zombies;
	
	@Before
	/**
	 * This method set's up the array list and the zombies
	 */
	public void setUp() throws Exception {
		zombies = new ArrayList<Zombie>();
		z1 = new Zombie(10, 10);
		z2 = new Zombie(20, 20);
		z3 = new Zombie(30, 30);
	}
	
	/**
	 * This method tests when the game is starting and there are no zombies
	 */
	public void testEmptyListSize() {
		
		ArrayList<Zombie> emptyList = zombies;
		assertEquals("Size of zombie list should be 0", 0, emptyList.size());//edge case when the game board is empty
	}
	
	/**
	 * This method tests adding of zombies to the array list 
	 */
	public void testAddZombie() {
		ArrayList<Zombie> addZombie = zombies;
		addZombie.add(z1);
		addZombie.add(z2);
		addZombie.add(z3);
		assertEquals("Size of zombie list should be 3", 3, addZombie.size());
	}

	/**
	 * This method tests the removing of zombies to the array list 
	 */
	public void testRemoveZombie() {
		ArrayList<Zombie> removeZombie = zombies;
		removeZombie.add(z1);
		removeZombie.add(z2);
		removeZombie.add(z3);
		removeZombie.remove(z1);
		removeZombie.remove(z2);
		removeZombie.remove(z3);
		assertEquals("Size of zombie list should be 0", 0, removeZombie.size());
	}
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(testZombies.class);
	}

}
