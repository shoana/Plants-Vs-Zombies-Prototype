/**
 * Flag zombies attacks the plants preventing themselves from dying and allowing 
 * them to enter the house.
 * @author Sarah Lamonica, Mounica Pillarisetty, Fatima Hashi, Shoana Sharma 
 * @version Novemeber 25th, 2018
 */
public class FlagZombie extends Zombie{


	/**
	 * Constructor for flag zombie
	 * @param positionX is an int for x coordinate position on the grid
	 * @param positionY is an int for y coordinate position on the grip 
	 * @param isEaten true if zombie is eaten, false otherwise
	 * @param damagePoints checks the life of the zombie in form of an integer
	 * @param isWalnut is the life has been given or taken from zombie 
	 */

	public FlagZombie(int positionX, int positionY, boolean isEaten, int damagePoints, char zombieType, boolean isWalnut) {
		super(positionX, positionY, isEaten, damagePoints, zombieType, isWalnut);

		// TODO Auto-generated constructor stub
	}
	/**
	 * This method allows flag zombies to move function
	 */
	public void move()
	{
		super.setPositionY(super.getPositionY() - 1);
	}

	/**
	 * This method allows to get the type of zombie
	 */
	public char getType()
	{
		return super.getType();
	}

}
