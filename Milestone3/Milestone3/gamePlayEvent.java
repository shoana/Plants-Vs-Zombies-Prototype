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
	private ArrayList<Peashooter> p;
	
	
	/**
	 * Constructor
	 * @param source
	 * @param x
	 * @param y
	 * @param plantType
	 * @param z
	 * @param sunshines
	 */
	
	public gamePlayEvent(Object source, int x, int y, char plantType, ArrayList<Zombie> z, int sunshines, ArrayList<Peashooter> p) {
		super(source);
		this.x = x;
		this.y = y;
		this.plantType = plantType;
		this.z = z;
		this.sunshines = sunshines;
		this.p = p;
		
	}
	public ArrayList<Peashooter> getPeas()
	{
		return this.p;
	}
	/**
	 * Getter
	 * @return
	 */
	public ArrayList<Zombie> returnZombie()
	{
		return this.z;
	}
	/**
	 * Getter
	 * @return
	 */
	public gameEnum getGameEnum()
	{
		return this.e;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public int getSunshines()
	{
		return sunshines;
	}
	
	/**
	 * Getter method
	 * @return
	 */
	public char getPlantType()
	{
		return plantType;
	}

	
}
