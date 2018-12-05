package model;
import java.io.Serializable;

/**
 * Flag zombie class
 * @author sarahlamonica
 *
 */
public class FlagZombie extends Zombie implements Serializable{
	

	public FlagZombie(int positionX, int positionY, boolean isEaten, int damagePoints, char zombieType, boolean isWalnut) {
		super(positionX, positionY, isEaten, damagePoints, zombieType, isWalnut);
		
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
