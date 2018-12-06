package model;
import java.io.Serializable;
/**
 * Peashooter class is a type of plant that attacks the Zombie and prevents them 
 * from entering the house
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version December 5th, 2018
 */

public class Peashooter extends Plant implements Serializable {

	/**
	 * Constructor for cherry bomb
	 * @param cost is an int for the money that is required to buy a peashooter bomb
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grid
	 * @param isEaten is a boolean to represent cherry bomb being eaten by a zombie 
	 */
	public Peashooter(int cost, int positionX, int positionY, boolean isEaten) {
		super(cost, positionX, positionY, isEaten);
		// TODO Auto-generated constructor stub
	}

}
