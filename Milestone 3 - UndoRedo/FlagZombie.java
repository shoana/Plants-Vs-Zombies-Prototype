/**
 * Flag zombie class
 * @author sarahlamonica
 *
 */
public class FlagZombie extends Zombie{
	

	public FlagZombie(int positionX, int positionY, boolean isEaten, int damagePoints, char zombieType) {
		super(positionX, positionY, isEaten, damagePoints, zombieType);
		
		// TODO Auto-generated constructor stub
	}

	public void move()
	{
		super.setPositionY(super.getPositionY() - 1);
	}
	
	public char getType()
	{
		return super.getType();
	}

}
