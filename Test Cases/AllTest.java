
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * This class contains all the test cases created to check the functionality of the game
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 16th, 2018 
 *
 */
public class AllTest extends TestSuite{
	
	public static void main(String[] args) {
		
		junit.textui.TestRunner.run(suite());
	}

	/**
	 * Adding test cases to the suites 
	 * @return test of all test ca
	 */

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for all testcases pertaining to game Plants vs Zombies");
		suite.addTest(new TestSuite(testGameOver.class));
		suite.addTest(new TestSuite(testPeashooter.class));
		suite.addTest(new TestSuite(testPlantTurn.class));
		suite.addTest(new TestSuite(testSunflower.class));
		suite.addTest(new TestSuite(testZombies.class));
		return suite;
	}

}
