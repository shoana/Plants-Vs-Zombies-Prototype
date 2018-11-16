import java.util.ArrayList;
import java.util.EventObject;

public class gamePlayEvent extends EventObject {

	private gameEnum e;
	private int x;
	private int y;
	private char plantType;
	private ArrayList<Zombie> z;
	private int sunshines;
	
	public gamePlayEvent(Object source, int x, int y, char plantType, ArrayList<Zombie> z, int sunshines) {
		super(source);
		this.x = x;
		this.y = y;
		this.plantType = plantType;
		this.z = z;
		this.sunshines = sunshines;
		
	}
	
	public ArrayList<Zombie> returnZombie()
	{
		return this.z;
	}
	
	public gameEnum getGameEnum()
	{
		return this.e;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getSunshines()
	{
		return sunshines;
	}
	
	public char getPlantType()
	{
		return plantType;
	}

	
}
