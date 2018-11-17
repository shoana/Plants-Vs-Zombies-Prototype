import org.junit.Test;
import java.util.*;
import org.junit.*;
import junit.framework.TestCase;
/**
 * This class a part of the test cases which is used to test the functionality of 
 * how a game is over and it's edge cases. It checks if the plants win or zombies win.
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 15th, 2018
 *
 */
public class testGameOver extends TestCase {

	private ArrayList<Zombie> zombies;
	private ArrayList<Peashooter> peashooters;
	private ArrayList<Sunflower> sunflowers;
	private Zombie z1, z2, z3;
	private Peashooter p1;
	private boolean zombieAttack = true; // start of game
	private int grid [][];

	/**
	 * This method sets up all the variables used for the test cases
	 */
	public void setUp() throws Exception {
		zombies = new ArrayList<Zombie>();
		peashooters = new ArrayList<Peashooter>();
		sunflowers = new ArrayList<Sunflower>();
		p1 = new Peashooter (0, 3, 5); // cost = 0, (x, y) = (3,5)
		z1 = new Zombie (0,0);
		z2 = new Zombie (3,4);
		z3 = new Zombie (3,3);
		//gamePlay.plantOrZombie();
	}

	/**
	 * This test case checks if the plants win
	 */
	public void testPlantWins() {

		// Zombies are all killed by peashooters while the game has commenced

		assertTrue("Game over: Plant has won.", zombies.size() == 0 && zombieAttack == true);

	}

	/**
	 * This test case checks if the zombies win, when there are no peashooters/sunflowers left on the grid
	 */
	public void testZombieWins1() {

		zombies.add(z1);
		// Zombies have eaten all the plants
		assertTrue("Game over: Zombie has won.", peashooters.size() == 0 && sunflowers.size()==0 && zombies.size() > 0);

	}

	/**
	 * This test case checks if the zombies have reached the end and 
	 * the spaces between the zombie and the plant is no more than 2
	 */
	public void testZombieWins2() {

		zombies.add(z1);
		zombies.add(z2);
		zombies.add(z3);
		peashooters.add(p1);

		//Zombies have reached the house
		assertTrue("Game over: Zombie has won.", z1.getPositionY() == 0);


		//Zombie in a row, peashooter not in that row and cannot buy more
		assertTrue("Game over: Zombie has won.", (z2.getPositionX() == p1.getPositionX() && 
				(z3.getPositionY() == (p1.getPositionY()) || 
				(z3.getPositionY() == p1.getPositionY()- 1) || 
				(z3.getPositionY() == p1.getPositionY()- 2) )));

	}


	@Test

	public static void main(String[] args) {
		junit.textui.TestRunner.run(testGameOver.class);
	}

}
