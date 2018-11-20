/**
 * Peashooter class is a type of plant that attacks the Zombie and prevents them 
 * from entering the house
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 16th, 2018
 */

public class Peashooter extends Plant{
	
	public static final int cost = 100;
	public static int positionX = 0;
	public static int positionY = 0;
	
	
	
	/**
	 * Constructor for the peashooter
	 * @param cost is an int for the money that is required to buy a peashooter
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Peashooter() {
		super(cost, positionX, positionY);
		this.setCost(cost);
		this.positionX = positionX;
		this.positionY = positionY;
	}

}