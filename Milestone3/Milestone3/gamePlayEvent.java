import java.util.ArrayList;
import java.util.EventObject;

/**
 * Game Play Event handles the event and its model
 * @author sarahlamonica
 *
 */
public class gamePlayEvent extends EventObject {

	
	private int x;
	private int y;
	private char plantType;
	private ArrayList<Zombie> z;
	private int sunshines;
	private ArrayList<Plant> p;
	private char[][] board;
	
	
	/**
	 * Constructor
	 * @param source
	 * @param x
	 * @param y
	 * @param plantType
	 * @param z
	 * @param sunshines
	 */
	
	public gamePlayEvent(Object source, int x, int y, char plantType, ArrayList<Zombie> z, int sunshines, ArrayList<Plant> p, char[][] board) {
		super(source);
		this.x = x;
		this.y = y;
		this.plantType = plantType;
		this.z = z;
		this.sunshines = sunshines;
		this.p = p;
		this.board = board;
		
	}
	public ArrayList<Plant> getPeas()
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
	 * get the current state of the board
	 * @return
	 */
	public char[][] getBoard()
	{
		return board;
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
