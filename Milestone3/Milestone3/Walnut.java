
/**
 * Walnut class is a type of plant that produces extra life
 * when you buy the plant.  
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 25th, 2018
 */
public class Walnut extends Plant{
	private int walnutLife = 0;
	
	/**
	 * Constructor for walnut plant
	 * @param cost
	 * @param positionX
	 * @param positionY
	 * @param isEaten
	 */
	public Walnut(int cost, int positionX, int positionY, boolean isEaten) {
		super(cost, positionX, positionY, isEaten);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is a setter method for increasing lives
	 */
	public void setLife()
	{
		walnutLife += 1;
	}

	/**
	 * This is a getter for walnut's life
	 * @return an int in the form walnut's life 
	 */
	public int getLife()
	{
		return walnutLife;
	}

}
