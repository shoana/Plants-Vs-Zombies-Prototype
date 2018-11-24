/**
 * Zombie attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author sarahlamonica
 * @version MILESTONE 3
 */

public class Zombie {
	private int positionX; // zombie position
	private boolean isEaten; //isEaten true or false
	private int positionY;  // zombie position
	private int damagePoints;
	private char zombieType;

	/**
	 * Constructor for Zombie class
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Zombie(int positionX, int positionY, boolean isEaten, int damagePoints, char zombieType) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.isEaten = isEaten;
		this.damagePoints = damagePoints;
		this.zombieType = zombieType;
	}
	
	public char getType()
	{
		return zombieType;
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
	
	public int getDmg()
	{
		return damagePoints;
	}
	
	public void setDmg(int dmg)
	{
		damagePoints = dmg;
	}
	
	
	public void move()
	{
		positionY = positionY - 1;
	}
}