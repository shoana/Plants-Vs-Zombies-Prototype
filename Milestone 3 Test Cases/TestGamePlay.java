package TestCases;
import org.junit.Test;

import java.util.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.junit.*;
import junit.framework.TestCase;
import model.Plant;
import model.Zombie;
import model.gamePlay;
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
	private Zombie z1, z2, z3;
	private Plant p1;
	private char plantType, zombieType;
	private boolean isEaten = false; // start of game
	private int damagePoints, sunshine, row, col;
	private static char[][] board, tempBoard;

	/**
	 * This method sets up all the variables used for the test cases
	 */
	public void setUp() throws Exception {
		zombies = new ArrayList<Zombie>();
		plants = new ArrayList<Plant>();
		p1 = new Plant (0, 3, 5, isEaten); // cost = 0, (x, y) = (3,5)
		z1 = new Zombie (0,0, isEaten, damagePoints, zombieType );
		z2 = new Zombie (3,4, isEaten, damagePoints, zombieType );
		z3 = new Zombie (3,3, isEaten, damagePoints, zombieType );
	}

	/**
	 * This test case checks if the plants win
	 *//*
	public void testCopyGame() {
		
		
		gamePlay.copyGame();
		assertTrue("Game over: Plant has won.",tempBoard[i][j] == board[i][j] );

	}
*/
	
	public void testSunshineCheck() {
		
		gamePlay.sunshineCheck(row, col);
		
	}

	@Test

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestGamePlay.class);
	}

}