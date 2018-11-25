
/**
 * Walnut class
 * @author sarahlamonica
 *
 */
public class Walnut extends Plant{
	private int walnutLife = 0;
	public Walnut(int cost, int positionX, int positionY, boolean isEaten) {
		super(cost, positionX, positionY, isEaten);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Setter method for increasing lives
	 */
	public void setLife()
	{
		walnutLife += 1;
	}
	
	/**
	 * Getter for walnut's life
	 * @return
	 */
	public int getLife()
	{
		return walnutLife;
	}

}
