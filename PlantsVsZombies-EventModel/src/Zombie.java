/**
 * Zombie attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version October 27th, 2018
 */

public class Zombie {
	private int positionX; // zombie position
	private int positionY;  // zombie position
	
	/**
	 * Constructor for Zombie class
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Zombie(int positionX, int positionY) {
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