import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * This class is a part of the test cases which is used to test the functionality of 
 * plant's turn in the game play class and it's edge cases. 
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 16th, 2018
 *
 */

public class testPlantTurn extends TestCase{

	
	private gamePlay g1;
	private int sunshine = 1000; // start of game
	private static int sun = 25; // each sun costs 25
	private char plantType;
	private int col, row;
	//private gameEnum PLANT_TIME, ZOMBIE_TIME, ZOMBIES_WIN, PLANTS_WIN;
	
	/**
	 * This test case sets up the variable for this class
	 */
	public void setUp() {
		g1 = new gamePlay(5, 5, sunshine);
		plantType = ' ';
	}
	
	/**
	 * This test case checks for the plant peashooter on the game play  
	 */
	public void testPlantTurn1() {
		
		// test peashooter in Plant turns
		plantType = 'p';
		gamePlay.plantTurn (row, col, 'p');
		assertTrue("Game Over: Zombies win", plantType == 'p' && sunshine >=100);
	}
	

	/**
	 * This test case checks for the plant sunflower on the game play  
	 */
	public void testPlantTurn2() {
		
		// test sunflower in Plant turns
		plantType = 's';
		gamePlay.plantTurn (row, col, 's');
		assertTrue("Game Over: Zombies win", plantType == 's' && sunshine >=50);
		
	}
	
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(testPlantTurn.class);
	}

}