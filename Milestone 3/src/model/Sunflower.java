package model;

/**
 * Sunflower class is a type of plant that produces sunshine(money) when you buy the plant.  
 * It allows the user to buy more plants
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 25th, 2018
 */
public class Sunflower extends Plant{

	/**
	 * Constructor for the sunflower class
	 * @param cost is an int for the money that is required to buy a peashooter
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grid 
	 * @param isEaten is an boolean that sets true is the sunflower is eaten, false otherwise
	 */
	public Sunflower(int cost, int positionX, int positionY, boolean isEaten) {
		super(cost, positionX, positionY, isEaten);
		// TODO Auto-generated constructor stub
	}


}
