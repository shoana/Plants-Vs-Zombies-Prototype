/**
 * Zombie attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version November 25th, 2018
 */

public class Zombie {
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
	 * @param isEaten true if zombie is eaten, false otherwise
	 * @param damagePoints checks the life of the zombie in form of an integer
	 * @param isWalnut is the life has been given or taken from zombie 
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
	 * This method sets boolean to true if the zombie is in the same 
	 * grid space as the walnut
	 * @param boolean to set the true or false of the walnut being present or not
	 */
	public void setWalnutStatus(boolean a)
	{
		isWalnut = a;
	}
	/**
	 * This is method checks the walnut status
	 * @return true if walnut is set, false otherwise
	 */
	public boolean walnutStatus()
	{
		return isWalnut;
	}

	/**
	 * This methods gets the type of zombie
	 * @return a char based on the zombie present on the board
	 */
	public char getType()
	{
		return zombieType;
	}

	/**
	 * This is a getter method for position x
	 * @return int for the position for x
	 */
	public int getPositionX(){
		return positionX;
	}

	/**
	 * This method get the state of the zombies, as being eaten or not 
	 * @return an boolean true if killed or false otherwise
	 */
	public boolean getEaten()
	{
		return isEaten;
	}

	/**
	 * This method sets the state of the zombie, true if dead or false otherwise
	 */
	public void setEaten()
	{
		isEaten = true;
	}

	/**
	 * This is a setter method for position x
	 * @param positionX is an that allows to set the x coordinate on the grid
	 */
	public void setPositionX(int positionX){
		this.positionX = positionX;
	}

	/**
	 * This is a getter method for position y
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

	/**
	 * This is a getting the zombie's dmg points
	 * @return an integer for the damage cased by the plants to a zombie
	 */
	public int getDmg()
	{
		return damagePoints;
	}

	/**
	 * This method sets the zombies dmg points
	 * @param an integers dmg that contains the life remaining for the zombie
	 */
	public void setDmg(int dmg)
	{
		damagePoints = dmg;
	}

	/**
	 * this method checks the move the zombie 1 grid space
	 */
	public void move()
	{
		if(!isWalnut)
		{
			positionY = positionY - 1;
		}

	}
}
