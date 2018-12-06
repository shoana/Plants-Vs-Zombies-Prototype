package testCases;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * This class contains all the test cases created to check the functionality of the game
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version December 5th, 2018 
 *
 */
public class TestAll extends TestSuite{
	
	public static void main(String[] args) {
		
		junit.textui.TestRunner.run(suite());
	}

	/**
	 * Adding test cases to the suites 
	 * @return test of all test cases
	 */

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for all testcases pertaining to game Plants vs Zombies");
		suite.addTest(new TestSuite(TestGamePlay.class));
		suite.addTest(new TestSuite(TestPeashooter.class));
		suite.addTest(new TestSuite(TestWalnut.class));
		suite.addTest(new TestSuite(TestSunflowers.class));
		suite.addTest(new TestSuite(TestCherryBomb.class));
		suite.addTest(new TestSuite(TestNormalZombie.class));
		suite.addTest(new TestSuite(TestFlagZombie.class));
		suite.addTest(new TestSuite(TestPylonZombie.class));		
		return suite;
	}

}
