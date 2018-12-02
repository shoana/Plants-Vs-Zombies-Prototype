import java.io.Serializable;

/**
 * Zombie attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author sarahlamonica
 * @version MILESTONE 3
 */

public class Zombie implements Serializable{
	private int positionX; // zombie position
	private boolean isEaten; //isEaten true or false
	private int positionY;  // zombie position
	private int damagePoints;
	private char zombieType;
	private boolean isWalnut;

	/**
	 * Constructor for Zombie class
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 */
	public Zombie(int positionX, int positionY, boolean isEaten, int damagePoints, char zombieType, boolean isWalnut) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.isEaten = isEaten;
		this.damagePoints = damagePoints;
		this.zombieType = zombieType;
		this.isWalnut = isWalnut;
	}
	/**
	 * True if the zombie is in the same grid space as the walnut
	 */
	public void setWalnutStatus(boolean a)
	{
		isWalnut = a;
	}
	/**
	 * Checks the walnut status
	 * @return
	 */
	public boolean walnutStatus()
	{
		return isWalnut;
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
	
	/**
	 * Getting the zombie's dmg points
	 * @return
	 */
	public int getDmg()
	{
		return damagePoints;
	}
	
	/**
	 * Setting the zombies' dmg points
	 * @param dmg
	 */
	public void setDmg(int dmg)
	{
		damagePoints = dmg;
	}
	
	/**
	 * Move the zombie 1 grid space
	 */
	public void move()
	{
		if(!isWalnut)
		{
			positionY = positionY - 1;
		}
		
	}
}