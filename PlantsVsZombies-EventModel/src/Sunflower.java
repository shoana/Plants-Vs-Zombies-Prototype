/**
 * Sunflower class is a type of plant that produces sunshine(money) when you buy the plant.  
 * It allows the user to buy more plants
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version October 27th, 2018
 */

public class Sunflower {
	private int cost; 
	private int positionX; 
	private int positionY;
	
	/**
	 * Constructor for the Sunflower
	 * @param cost is an int for the money that is required to buy a peashooter
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Sunflower(int cost, int positionX, int positionY) {
		this.cost = cost;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	/**
	 * Getter method for position x
	 * @return int for the position for x
	 */
	public int getPositionX(){
		return positionX;
	}
	
	/**
	 * Setter method for position x
	 * @param positionX is an that allows to set the x coordinate on the grid
	 */
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}
	
	/**
	 * Getter method for position y
	 * @return int for the position for y
	 */
	public int getPositionY(){
		return positionY;
	}
	
	/**
	 * Setter method for position y 
	 * @param positionX is an that allows to set the y coordinate on the grid
	 */
	public void setPositionY(int positionY){
		this.positionY = positionY;
	}
}