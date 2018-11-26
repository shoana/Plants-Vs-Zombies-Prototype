
/**
 * This class is any of the 3 types of plant sunflower, peashooter, walnut and cherry bomb
 * type of plant that attacks the Zombie and prevents them from entering the house
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 25th, 2018
 */

public class Plant {
	private int cost;
	private int positionX;
	private int positionY;
	private boolean isEaten;

	/**
	 * Constructor for the peashooter
	 * @param cost is an int for the money that is required to buy a peashooter
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Plant(int cost, int positionX, int positionY, boolean isEaten)
	{
		this.cost = cost;
		this.positionX = positionX;
		this.positionY = positionY;
		this.isEaten = false;
	}

	/**
	 * This method is a getter method for position x
	 * @return int for the position for x
	 */
	public int getPositionX(){
		return positionX;
	}

	/**
	 * This method checks if the plant is eaten or not
	 * by the zombie
	 * @return a boolean if plant isEast as true, false otherwise
	 */
	public boolean getEaten()
	{
		return isEaten;
	}

	/**
	 * The method sets the desired boolean of the plant
	 */
	public void setEaten()
	{
		this.isEaten = true;
	}
	/**
	 * This methos is a setter method for position x
	 * @param positionX is an that allows to set the x coordinate on the grid
	 */
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}

	/**
	 * This method is a getter method for position y
	 * @return int for the position for y
	 */
	public int getPositionY(){
		return positionY;
	}

	/**
	 * This is a setter method for position y 
	 * @param positionX is an that allows to set the y coordinate on the grid
	 */
	public void setPositionY(int positionY){
		this.positionY = positionY;
	}
}
