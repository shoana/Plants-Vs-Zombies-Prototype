/**
 * Zombie attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version October 27th, 2018
 */

public class Zombie {
	private int positionX; // zombie position
	private boolean isEaten;
	private int positionY;  // zombie position
	
	/**
	 * Constructor for Zombie class
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Zombie(int positionX, int positionY, boolean isEaten) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.isEaten = isEaten;
	}
	
	/**
	 * Getter method for position x
	 * @return int for the position for x
	 */
	public int getPositionX(){
		return positionX;
	}
	
	public boolean getEaten()
	{
		return isEaten;
	}
	
	public void setEaten()
	{
		isEaten = true;
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
	
	public void move()
	{
		this.positionY = positionY - 1;
		
	}
}
