/**
 * Sunflower class is a type of plant that produces sunshine(money) when you buy the plant.  
 * It allows the user to buy more plants
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 16th, 2018
 */

public class Sunflower extends Plant{

	public static final int cost = 50;
	public static final String plantType = "sunflower";
	public static int positionX;
	public static int positionY;
	

	/**
	 * Constructor for the Sunflower
	 * @param cost is an int for the money that is required to buy a peashooter
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Sunflower() {
		super(cost, positionX, positionY, plantType);
	}

}
