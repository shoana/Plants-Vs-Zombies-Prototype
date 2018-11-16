import java.util.ArrayList;
import java.util.EventObject;

/**
 * Game Play Event handles the event and its model
 * @author sarahlamonica
 *
 */
public class gamePlayEvent extends EventObject {

	private gameEnum e;
	private int x;
	private int y;
	private char plantType;
	private ArrayList<Zombie> z;
	private int sunshines;
	
	/**
	 * Constructor
	 * @param source
	 * @param x
	 * @param y
	 * @param plantType
	 * @param z
	 * @param sunshines
	 */
	public gamePlayEvent(Object source, int x, int y, char plantType, ArrayList<Zombie> z, int sunshines) {
		super(source);
		this.x = x;
		this.y = y;
		this.plantType = plantType;
		this.z = z;
		this.sunshines = sunshines;
		
	}
	
	/**
	 * Getter method to get all the zombies
	 * @return ArrayList<Zombie> 
	 */
	public ArrayList<Zombie> returnZombie()
	{
		return this.z;
	}
	
	/**
	 * Getter method to get the game Enum value
	 * @return gameEnum
	 */
	public gameEnum getGameEnum()
	{
		return this.e;
	}
	
	/**
	 * Getter method to get the x coordinate
	 * @return int
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Getter method to get the Y coordinate
	 * @return int
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Getter method for the sunshines
	 * @return int
	 */
	public int getSunshines()
	{
		return sunshines;
	}
	
	/**
	 * Getter method for the plantType variale
	 * @return char
	 */
	public char getPlantType()
	{
		return plantType;
	}

	
}
