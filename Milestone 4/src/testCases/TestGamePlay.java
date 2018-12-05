package testCases;
import model.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.*;
import junit.framework.TestCase;

/**
 * This class a part of the test cases which is used to test the functionality of 
 * how a game is over and it's edge cases. It checks if the plants win or zombies win.
 * @author Fatima Hashi, Sarah Lamonica, Shoana Sharma,  Mounica Pillarisetty
 * @version November 25th, 2018
 *
 */
public class TestGamePlay extends TestCase {

	private ArrayList<Zombie> zombies;
	private ArrayList<Plant> plants;
	private Stack<Plant> plantUndoStack, plantRedoStack;
	private Zombie z1, z2, z3;
	private Plant p1;
	private char zombieType;
	private boolean isEaten, isWalnut, gameOver, startGame, isRemoved, isAdded; 
	private int damagePoints, numZombies, sunshine, lvl;
	private char[][] board; //board variable, the view reads this when it's updated
	

	/**
	 * This method sets up all the variables used for the test cases
	 */
	public void setUp() throws Exception {
		char[][] board = null;
		zombies = new ArrayList<Zombie>();
		plants = new ArrayList<Plant>();
		plantRedoStack = new Stack<Plant>();
		plantUndoStack = new Stack<Plant>();
		p1 = new Plant (0, 3, 5, isEaten); // cost = 0, (x, y) = (3,5)
		z1 = new Zombie (0,0, isEaten, damagePoints, 'f',isWalnut );
		z2 = new Zombie (3,4, isEaten, damagePoints, 'x' ,isWalnut);
		z3 = new Zombie (3,3, isEaten, damagePoints, 'z',isWalnut );
		startGame = false;
		
	}

	/**
	 * This test case checks if the plants win the game by checking if all zombies are dead
	 */
	public void testPlantWins() {

		if(zombies.size() == 0) {  // Zombies are all killed by plants 
			gameOver = true;
		}	
		assertTrue("Game over: Plant has won.", gameOver);
	}

	/**
	 * This test case checks if the zombies win, when the zombie reaches the house
	 */
	public void testZombieWins() {
		for(Zombie z : zombies) {
			if(z.getPositionY() == 0) {  // zombie reached house
				gameOver = true;
			}	
			assertTrue("Game over: Zombie has won.", gameOver); 
		}	

	}

	/**
	 *  This test case check if zombie has moved
	 */
	public void testMoveZombies() {	
		for (int i = 0; i < zombies.size(); i++) {
			if(!Zombie.walnutStatus()) {
				assertTrue("Zombies  have moved.", Zombie.walnutStatus());
			}
		}	
	}
	/**
	 * This test case checks if the game has not yet begun, there are multiple 
	 *  pylon or normal zombies that are added to the list of zombies
	 */
	public void testZombieTime() {

		if(!startGame && zombieType == 'x' || zombieType == 'z') { // game hasn't begun
			for(int i = 0; i >= numZombies; i++) {
				assertTrue("More than 1 zombie" , numZombies >= 0);	
			}
			zombies.add(z2); // pylon zombies added to list
			zombies.add(z3); // normal zombies added to list

			assertTrue("Zombies are added to zombies list" ,numZombies >= 0);
		}
	}

	/**
	 * This test case checks if the game has not yet begun, there are multiple
	 * flag zombies that are added to the list of zombies
	 */
	public void testFlagZombieIncoming() {

		if(!startGame && zombieType == 'f') { // game hasn't begun
			for(int i = 0; i >= numZombies; i++) {
				assertTrue("More than 1 zombie" , numZombies >= 0);	
			}
			zombies.add(z1); // flag zombies added to list
			assertTrue("Zombie is added to zombies list" ,numZombies >= 0);
		}
	}

	/**
	 * This test case checks if a plant has been removed (to implement undo method) 
	 */
	public void testUndo() {
		plantUndoStack.add(p1); // adding plant to stack
		// check if plant is last stack and has been removed
		if(plantUndoStack.peek() instanceof Plant && plants.remove(plantUndoStack.peek())){
			isRemoved = true;
			assertTrue ("Plant is removed.", isRemoved);
		}
	}
	/**
	 * This test case checks if a plant has been added (to implement redo method) 
	 */	
	public void testRedo() {
		plantRedoStack.add(p1); // adding plant to stack
		if(plantRedoStack.peek() instanceof Plant && plants.add(plantRedoStack.peek())){
			isAdded = true;
			assertTrue ("Plant is added.", isAdded);
		}
	}
	/**
	 * This test case checks if the board is cleared for all plants and zombies
	 */	
	public void testClr() {
		plants.removeAll(plants); 
		assertTrue("All plants are off the board.", plants.size()== 0);
		zombies.removeAll(zombies);
		assertTrue("All zombies are off the board.", zombies.size()== 0);
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public void testSave() throws IOException {

		int writeArr[] = {lvl, sunshine};
		OutputStream out = new FileOutputStream("testSave.txt");
		for(int i = 0; i < writeArr.length ; i++) {
			out.write (writeArr[i]);  
		}
		out.close();
		assertTrue("The file is saved.", writeArr.length> 0);	
	}
	
	/**
	 * 
	 */
	public void testLoad() throws IOException, ClassNotFoundException {
		
		 int readArr[] = {lvl, sunshine};
		 InputStream in = new FileInputStream("testSave.txt");
			for(int i = 0; i < readArr.length ; i++) {
				in.read();  
			}
			in.close();
			assertTrue("The file is read.", readArr.length> 0);			 
	}
	
	/**
	 * 
	 */
	public void testLvlOne(){
	
		Zombie z = new Zombie(1, 5, false, 100, 'z', false);
		assertEquals("Normal Zombies are present.", z.getType(), 'z');

	}
	
	/**
	 * 
	 */
	public void testLvlTwo(){
		
		Zombie z = new Zombie(1, 5, false, 100, 'z', false);
		assertEquals("Normal Zombies are present.", z.getType(), 'z');
		FlagZombie fz = new FlagZombie(0, 5, false, 100, 'f', false);
		assertEquals("Flag Zombies are present.", fz.getType(), 'f');
		
	}
	/**
	 * 
	 */
	public void testLvlThree() {
		Zombie z = new Zombie(1, 5, false, 100, 'z', false);
		assertEquals("Normal Zombies are present.", z.getType(), 'z');
		FlagZombie fz = new FlagZombie(0, 5, false, 100, 'f', false);
		assertEquals("Flag Zombies are present.", fz.getType(), 'f');
		PylonZombie pz = new PylonZombie(1, 5, false, 100, 'x', false);
		assertEquals("Pylon Zombies are present.", pz.getType(), 'x');
	}

	/**
	 * Code for initialization of level two
	 */
	
	@Test
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestGamePlay.class);
	}

}
