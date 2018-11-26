package model;

/**
 * The Cherry Bomb is a type of plant kills all the 
 * zombies around it
 *
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 25th, 2018 
 *
 */
public class CherryBomb extends Plant{

	/**
	 * Constructor for cherry bomb
	 * @param cost is an int for the money that is required to buy a cherry bomb
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grid
	 * @param isEaten is a boolean to represent cherry bomb being eaten by a zombie 
	 */
	public CherryBomb(int cost, int positionX, int positionY, boolean isEaten) {
		super(cost, positionX, positionY, isEaten);
		// TODO Auto-generated constructor stub
	}

}
